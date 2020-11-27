package basic;

import utils.PrintUtil;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
//        int nums[] = {1,2,3};
        int nums[] = {1,2,9};
//        int nums[] = {9, 9, 9};
        PrintUtil.printArray(plusOne2(nums));
    }

    /**
     * 先获取原始数组的最后一位，加1判断是否进位，然后遍历剩余的元素根据carry变量确定是否进位，每次进位carry都会减-1，
     * 遍历结束，carry小于0的话表示原始数组整体位数+1,即{99...99}变成{1..000}，直接创建新数组首位为1即可
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int carry = digits.length - 1;
        int add = digits[digits.length - 1] + 1;
        if (add > 9) {
            carry--;
            digits[digits.length - 1] = 0;
        } else {
            digits[digits.length - 1] = add;
            return digits;
        }
        for (int i = digits.length - 2; i > -1; i--) {
            if (carry == i) {
                if (digits[i] + 1 > 9) {
                    digits[i] = 0;
                    carry--;
                } else {
                    digits[i] = digits[i] + 1;
                }
            }
        }
        if (carry < 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }

    }

    /**
     * 从数组尾部开始遍历数组进行加1操作，判断是否有进位，如果没有就结束循环直接返回，
     * 直至正常结束循环表示原始数组整体位数+1,即{99...99}变成{1..000}，直接创建新数组首位为1即可
     *
     * @param digits
     * @return
     */
    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            digits[i] %= 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

}
