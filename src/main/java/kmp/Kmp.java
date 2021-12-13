package kmp;

public class Kmp {

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String key = "ABCDABD";
        System.out.println(kmpSearch(s, key));
        System.out.println(s.indexOf(key));
    }

    public static int kmpSearch(String s, String key) {
        int[] next = getNextArr(key);
        int lenS = s.length();
        int lenKey = key.length();
        char[] sChars = s.toCharArray();
        char[] keyChars = key.toCharArray();
        int i = 0;
        int j = 0;
        while (i < lenS && j < lenKey) {
            if (j == -1 || sChars[i] == keyChars[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == lenKey) {
            return i - j;
        }
        return -1;
    }

    public static int[] getNextArr(String p) {
        char[] chars = p.toCharArray();
        int len = p.length();
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            if (k == -1 || chars[j] == chars[k]) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

}
