package basic.string;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"aag", "aac", "aasdfa"}));
        System.out.println(longestCommonPrefix(new String[]{"", "aac", "aasdfa"}));
        System.out.println(longestCommonPrefix(new String[]{"", "", "aasdfa"}));
        System.out.println(longestCommonPrefix(new String[]{"", "", ""}));
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{""}));
        System.out.println(longestCommonPrefix(new String[]{"aa"}));
        System.out.println(longestCommonPrefix(new String[]{"abab", "aba", ""}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));

        System.out.println(longestCommonPrefix2(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix2(new String[]{"aag", "aac", "aasdfa"}));
        System.out.println(longestCommonPrefix2(new String[]{"", "aac", "aasdfa"}));
        System.out.println(longestCommonPrefix2(new String[]{"", "", "aasdfa"}));
        System.out.println(longestCommonPrefix2(new String[]{"", "", ""}));
        System.out.println(longestCommonPrefix2(new String[]{}));
        System.out.println(longestCommonPrefix2(new String[]{""}));
        System.out.println(longestCommonPrefix2(new String[]{"aa"}));
        System.out.println(longestCommonPrefix2(new String[]{"abab", "aba", ""}));
        System.out.println(longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix2(new String[]{"ab", "a"}));

    }

    /**
     * 纵向扫描
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        int start = 0;
        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        while (true) {
            for (int i = 1; i < strs.length; i++) {
                if (start >= strs[i - 1].length()) {
                    return "";
                }
                if (start >= strs[i].length() || strs[i - 1].charAt(start)
                        != strs[i].charAt(start)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(start));
            start++;
            for (int i = 0; i < strs.length; i++) {
                if (start >= strs[i].length()) {
                    return sb.toString();
                }
            }
        }
    }

    /**
     * 二分查找
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        if (minLen == 0) {
            return "";
        }
        int low = 0, high = minLen;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            boolean equal = true;
            for (int i = low; i < mid; i++) {
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j - 1].charAt(i) != strs[j].charAt(i)) {
                        equal = false;
                        break;
                    }
                }
            }
            if (equal) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

}
