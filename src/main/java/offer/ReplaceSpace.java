package offer;

/**
 * 剑指 Offer 05. 替换空格
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        char[] array = new char[s.length() * 3];
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                array[curr] = '%';
                array[curr + 1] = '2';
                array[curr + 2] = '0';
                curr += 3;
            } else {
                array[curr] = s.charAt(i);
                curr++;
            }
        }
        return new String(array, 0, curr);
    }

}
