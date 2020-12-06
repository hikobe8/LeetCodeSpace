package basic.string;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) '0');
        System.out.println((int) '9');
        String s = "A man, a plan, a canal: Panama";
//        String s = "OP";
        System.out.println(isPalindrome(s));
    }

    //双指针，一前一后开始遍历
    public static boolean isPalindrome(String s) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(array[i])) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(array[j])) {
                j--;
                continue;
            }
            if (Character.toLowerCase(array[i]) != Character.toLowerCase(array[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
