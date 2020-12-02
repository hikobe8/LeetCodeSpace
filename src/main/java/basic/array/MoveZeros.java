package basic.array;

import utils.PrintUtil;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeros {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0, 0, 0, 5, 1, 0, 3, 12};
//        int[] nums = {1, 0};
        int[] nums = {2, 1};
        moveZeroes2(nums);
        PrintUtil.printArray(nums);
    }

    /**
     * 时间复杂度O(n^2) 空间复杂度O(1)
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        //从倒数第二个开始向前遍历
        int zerosCount = 0;
        for (int i = nums.length - 2; i > -1; i--) {
            //移动数组
            if (nums[i] == 0) {
                int tmp = nums[i];
                int j = i;
                for (; j < nums.length - zerosCount - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[j] = tmp;
                zerosCount++;
            }
        }
    }

    /**
     * 双指针法
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        if (nums.length < 2)
            return;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                //移动
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        if (i == 0)
            return;
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


}
