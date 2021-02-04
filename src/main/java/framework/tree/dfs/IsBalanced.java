package framework.tree.dfs;


import data_structure.TreeNode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 * 提示：
 *
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(dfs(root.left) - dfs(root.right)) < 2
                && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 自顶向下
     * @param node
     * @return
     */
    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }

}
