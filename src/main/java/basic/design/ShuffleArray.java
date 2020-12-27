package basic.design;

import utils.PrintUtil;

import java.util.Random;

/**
 * 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * <p>
 * 实现 Solution class:
 * <p>
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShuffleArray {

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        for (int i = 0; i < nums.length; i++) {
            int swapIndex = i + new Random().nextInt(nums.length - i);
            //不能交换两个int值相同的值，异或相同为0！！！！！！！！！
            nums[i] = nums[i] ^ nums[swapIndex];
            nums[swapIndex] = nums[i] ^ nums[swapIndex];
            nums[i] = nums[i] ^ nums[swapIndex];
        }
        PrintUtil.printArray(nums);
    }

    class Solution {

        int[] original;
        int[] shuffle;
        Random random = new Random();

        public Solution(int[] nums) {
            original = nums.clone();
            shuffle = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            shuffle = original;
            original = original.clone();
            return original;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < shuffle.length; i++) {
                int swapIndex = i + random.nextInt(shuffle.length - i);
                int tmp = shuffle[swapIndex];
                shuffle[swapIndex] = shuffle[i];
                shuffle[i] = tmp;
            }
            return shuffle;
        }
    }
}
