package hot100;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindrome("cbbd"));
        System.out.println(longestPalindrome.longestPalindrome("eabcb"));
        System.out.println(longestPalindrome.longestPalindrome("abcba"));
        System.out.println(longestPalindrome.longestPalindrome("acaa"));
        System.out.println(longestPalindrome.longestPalindrome("aacabdkacaa"));
    }

    /**
     * 中心扩展法
     * 时间复杂度O(n*n)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            int singleLen = check(s, i, i);
            int doubleLen = check(s, i, i + 1);
            int max = Math.max(singleLen, doubleLen);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int check(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
