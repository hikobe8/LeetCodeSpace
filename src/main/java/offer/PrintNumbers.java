package offer;

import utils.PrintUtil;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 */
public class PrintNumbers {

    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        PrintUtil.printArray(printNumbers.printNumbers(1));
        System.out.println();
        PrintUtil.printArray(printNumbers.printNumbers(2));
    }

    public int[] printNumbers(int n) {
        int len = (int) Math.min(Math.pow(10, n), Integer.MAX_VALUE) - 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = i + 1;
        }
        return res;
    }

}
