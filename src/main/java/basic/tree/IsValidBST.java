package basic.tree;

import java.util.ArrayList;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static ArrayList<TreeNode> nodes = new ArrayList<>();

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(5);
        System.out.println(isValidBST(root));
    }

    /**
     * 中须遍历二叉树生成数组，然后检查数组是否有序
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        assembleArray(root);
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i).val >= nodes.get(i + 1).val) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历二叉树
     *
     * @param root
     */
    public static void assembleArray(TreeNode root) {
        if (root != null) {
            assembleArray(root.left);
            nodes.add(root);
            assembleArray(root.right);
        }
    }

}
