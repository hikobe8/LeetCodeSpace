package offer;

public class KthLargest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.kthLargest(root, 3));
    }


    private int res = 0, i = 0;

    public int kthLargest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    /**
     * 二叉树中序遍历 左-根-右
     * 二叉搜索树的中序遍历为递增有序数列
     * <p>
     * 中序遍历的倒序 右-根-左
     * 逆序遍历为递减有序数列
     *
     * @param root
     * @param k
     */
    private void helper(TreeNode root, int k) {
        if (root == null)
            return;
        helper(root.right, k);
        if (i + 1 == k) {
            res = root.val;
        }
        i++;
        helper(root.left, k);
    }

}
