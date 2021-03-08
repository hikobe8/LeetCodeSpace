package basic.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {

    public static void main(String[] args) {
//        System.out.println(climbStairs(5));
        System.out.println(climbStairs2(70));
    }

    /**
     * 动态规划 f(n) = f(n-1) + f(n-2), 48溢出
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int i, j = 0, k = 1;
        int l = 0;
        while (l < n) {
            i = j;
            j = k;
            k = i + j;
            l++;
        }
        return k;
    }

    private static Map<Integer, Integer> memory = new HashMap<Integer, Integer>();

    /**
     * 带记忆的DFS
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n <= 3) {
            memory.put(n, n);
            return n;
        }
        if (memory.containsKey(n)) {
            return memory.get(n);
        }
        memory.put(n, climbStairs2(n - 1) + climbStairs2(n - 2));
        return memory.get(n);
    }


}
