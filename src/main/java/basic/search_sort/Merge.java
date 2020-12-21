package basic.search_sort;

import utils.PrintUtil;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *  
 *
 * 提示：
 *
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge {


    public static void main(String[] args) {
//        int[] n1 = new int[]{1, 2, 5, 6, 0, 0, 0};
        int[] n1 = new int[]{1};
//        int[] n2 = new int[]{7, 8, 9};
        int[] n2 = new int[]{};
        merge(n1, 1, n2, 0);
        PrintUtil.printArray(n1);
    }

    /**
     * 1 3 5 7
     * 2 6 8
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < 1 || nums2.length < 1)
            return;
        int i = 0;
        int j = 0;
        while (i < m) {
            if (nums2[j] < nums1[i]) {
                // 移动
                System.arraycopy(nums1, i, nums1, i + 1, m - i);
                //插入
                nums1[i] = nums2[j];
                //nums1 数量加1
                m += 1;
                j++;
            }
            i++;
        }
        for (; j < n; j++) {
            nums1[i++] = nums2[j];
        }
    }

}
