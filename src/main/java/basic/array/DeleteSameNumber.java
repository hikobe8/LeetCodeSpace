package basic.array;

import utils.PrintUtil;

/**
 * Author:github.com/hikobe8
 * Time:2020/11/19 23:31
 * Desc:
 *
 * 简单26题
 * 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class DeleteSameNumber {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 4, 4, 5, 5, 7, 8};
        int size = new DeleteSameNumber().removeDuplicates(nums);
        PrintUtil.printArray(nums, size);
    }
    //快慢指针法
    public int removeDuplicates(int[] nums) {
        //定义慢指针i
        int i = 0;
        //定义快指针j
        int j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                i ++;
                nums[i] = nums[j];
            }
            j ++;
        }
        return i + 1; //size = index + 1
    }

}
