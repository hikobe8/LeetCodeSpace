package basic.dp;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {

    public static void main(String[] args) {
//        int[] nums = {-2,-1,-3,-4,-1,-2,1,-5,-4};
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

    /**
     * 动态规划
     * [-2,1,-3,4,-1,2,1,-5,4]
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxValue = Math.max(maxValue, pre);
        }
        return maxValue;
    }

    /**
     * 贪心算法
     * [-2,1,-3,4,-1,2,1,-5,4]
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int cur = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
           cur += num;
           maxValue = Math.max(maxValue, cur);
           if (cur < 0) {
               cur = 0;
           }
        }
        return maxValue;
    }

}
