package framework.tree.dfs;

import data_structure.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {

    TreeNode mRoot = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return mRoot;
    }

    /**
     * 二叉树的后序遍历 递归查找
     * @param root
     * @param p
     * @param q
     * @return
     */
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        //叶子节点结束递归，并且返回false
        if (root == null) return false;
        //递归调用获取root的左子树是否包含p或者q
        boolean lSon = dfs(root.left, p, q);
        //递归调用获取root的右子树是否包含p或者q
        boolean rSon = dfs(root.right, p, q);

        if (lSon && rSon || ((root.val == p.val || root.val == q.val) && (lSon || rSon))) {
            mRoot = root;
        }
        return lSon || rSon || (root.val == p.val || root.val == q.val);
    }

}
