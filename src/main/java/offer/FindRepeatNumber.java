package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        System.out.println(findRepeatNumber.findRepeatNumber2(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber.findRepeatNumber2(new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }

    /**
     * 时间复杂度O(N) 空间复杂度O(n)
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> container = new HashSet<>();
        for (int num : nums) {
            if (!container.add(num)) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 数字和下标一一对应，同一位置重复即可确定重复元素
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            //判断是否元素和下标是否对应，元素值一样，下标值不一样则为重复元素
            if (nums[i] == value && i != value) {
                return value;
            }
            int curr = i;
            //循环修改数组使元素和下标对应
            while (curr != value) {
                int tmp = nums[value];
                nums[value] = curr;
                curr = value;
                value = tmp;
            }

        }
        return -1;
    }

}
