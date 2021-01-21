package framework;

/**
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *  
 *
 * 提示：
 *
 * 0 <= n <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Fib {

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(20));
        System.out.println(fib.fib2(20));
        System.out.println(fib.fib3(20));
    }

    /**
     * 自顶向下
     * 暴力法 时间复杂度O(2^n)
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }


    /**
     * 自顶向下
     * 记忆已计算过的数 时间复杂度O(n)
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        int[] memory = new int[n + 1];
        return help(n, memory);
    }

    public int help(int n, int[] memory) {
        if (n == 0)
            return 0;
        if (n < 2)
            return 1;
        if (memory[n] != 0) {
            return memory[n];
        } else {
            memory[n] = help(n - 1, memory) + help(n - 2, memory);
            return memory[n];
        }
    }

    /**
     * 自底向上 时间复杂度O(n)
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 0)
            return 0;
        if (n <= 2)
            return 1;
        int pre = 1;
        int cur = 1;
        for (int i = 2; i < n; i++) {
            int sum = cur + pre;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

}
