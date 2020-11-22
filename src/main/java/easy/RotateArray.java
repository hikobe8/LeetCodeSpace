package easy;

import sun.security.util.Length;
import utils.PrintUtil;

/**
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        rotate(array, 3);
//        int[] array = {-1, -100, 3, 99};
//        rotateByReverse(array, 2);
        PrintUtil.printArray(array);
    }

    static void rotate(int[] nums, int k) {
        k %= nums.length;
        //暴力 时间复杂度O(n*k) 空间复杂度O(1)
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

    static void rotateByReverse(int[] nums, int k) {
        k %= nums.length;
        //三次反转，时间复杂度O(n) 空间复杂度O(1)
        //反转全部
        reverse(nums, 0, nums.length - 1);
        //反转前k个
        reverse(nums, 0, k);
        //反转后n-k个, n = 数组长度
        reverse(nums, k + 1, nums.length - 1);
    }

    static void reverse(int[] nums, int start, int end) {
        int times = (end - start + 1) >> 1;
        for (int i = 0; i < times; i++) {
            int tmp = nums[end];
            nums[end --] = nums[start];
            nums[start ++] = tmp;
        }
    }

}
