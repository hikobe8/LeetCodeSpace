package framework;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange.coinChange(new int[]{3}, 2));
        System.out.println(coinChange.coinChange(new int[]{1}, 0));
        System.out.println(coinChange.coinChange2(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange.coinChange2(new int[]{3}, 2));
        System.out.println(coinChange.coinChange2(new int[]{1}, 0));
        System.out.println(coinChange.coinChange3(new int[]{1, 2, 5}, 100));
    }

    /**
     * 暴力法，{1, 2, 5}, 100 超出时间限制
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        int max = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subMax = coinChange(coins, amount - coin);
            if (subMax == -1)
                continue;
            max = Math.min(max, 1 + subMax);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    /**
     * 带备忘录，解决重复计算，时间复杂度O(kn), {1, 2, 5}, 100 超出时间限制
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        HashMap<Integer, Integer> memory = new HashMap<>();
        return dp(coins, amount, memory);
    }

    public int dp(int[] coins, int amount, HashMap<Integer, Integer> memory) {
        if (memory.containsKey(amount)) {
            return memory.get(amount);
        }
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        int max = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subMax = coinChange(coins, amount - coin);
            if (subMax == -1)
                continue;
            max = Math.min(max, 1 + subMax);
        }
        max = max == Integer.MAX_VALUE ? -1 : max;
        memory.put(amount, max);
        return max;
    }

    /**
     * 动态规划
     *
     * @param coins
     * @param amount
     */
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    //无解
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
