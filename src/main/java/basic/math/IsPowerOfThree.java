package basic.math;

/**
 * 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *  
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *  
 *
 * 进阶：
 *
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPowerOfThree {

    /**
     * 暴力法,循环
     * 时间复杂度O(log n)
     * 空间复杂度O(1)
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        while(n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    /**
     * 底数法
     * 时间复杂度O(log n)
     * 空间复杂度O(1)
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    /**
     * 整数限制
     *
     * MaxInt = 2147483647
     *
     * ​
     * 因为我们使用 32 位来表示数字，所以范围的一半用于负数，0 是正数的一部分。
     * 知道了 n 的限制，我们现在可以推断出 n 的最大值，也就是 3 的幂，是 1162261467。我们计算如下：
     *
     * 时间复杂度O(1)
     * 空间复杂度O(1)
     * @param n
     * @return
     */
    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
