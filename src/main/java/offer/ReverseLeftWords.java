package offer;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class ReverseLeftWords {

    public static void main(String[] args) {
        ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
        System.out.println(reverseLeftWords.reverseLeftWords("abcdefg", 2));
    }

    public String reverseLeftWords(String s, int n) {
        if (n == 0 || n > s.length())
            return s;
        int len = s.length();
        char[] array = s.toCharArray();
        char[] tmp = new char[n];
        System.arraycopy(array, 0, tmp, 0, n);
        if (array.length - n >= 0) System.arraycopy(array, n, array, 0, array.length - n);
        System.arraycopy(tmp, 0, array, len - n, tmp.length);
        return new String(array);
    }

}
