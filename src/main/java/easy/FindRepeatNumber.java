package easy;

import utils.PrintUtil;

import java.util.HashMap;

/**
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
//        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int[] arr = {7, 2, 6, 1, 0, 4, 5, 7, 3};
//        int[] arr = {2, 2, 1};
        System.out.println(findRepeatNumber(arr));
        PrintUtil.printArray(arr);
    }

    /**
     * 因为条件已明确说明"在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内"，
     * 可以使用下标与元素一一对应的方法查重
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            //已排序的数组中下标应该和值一一对应，如果没有对应则表示元素重复
            if (nums[i] == nums[num] && num != i) {
                return num;
            }
            //记录开始的下标
            int j = i;
            //开始排序数组
            while (num != j) {
                //暂存下标为元素值的元素
                int tmp = nums[num];
                //num下标的元素下标一一对应
                nums[num] = nums[j];
                nums[j] = tmp;
                //更新判断的元素值
                num = nums[j];
                //更新判断的元素下标
                j = nums[num];
            }
        }
        return -1;
    }

}
