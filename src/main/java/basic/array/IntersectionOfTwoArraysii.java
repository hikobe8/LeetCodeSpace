package basic.array;

import utils.PrintUtil;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionOfTwoArraysii {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 1, 1, 3, 4, 5, 6};
        PrintUtil.printArray(intersectByTwoPointer(nums1, nums2));
    }

    /**
     * 哈希表遍历数组，key对应元素，value对应出现的次数，出现次数大于1次的为交集
     * 时间复杂度O(1)
     * 空间复杂度O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] minNum;
        int[] maxNum;
        if (nums1.length > nums2.length) {
            minNum = nums2;
            maxNum = nums1;
        } else {
            minNum = nums1;
            maxNum = nums2;
        }
        int[] intersection = new int[minNum.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < minNum.length; i++) {
            int count = map.getOrDefault(minNum[i], 0);
            count++;
            map.put(minNum[i], count);
        }
        int index = 0;
        for (int j = 0; j < maxNum.length; j++) {
            if (map.containsKey(maxNum[j])) {
                int count = map.getOrDefault(maxNum[j], 0);
                if (count > 0) {
                    intersection[index++] = maxNum[j];
                    count--;
                    if (count > 0) {
                        map.put(maxNum[j], count);
                    } else {
                        map.remove(maxNum[j]);
                    }

                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    /**
     * 有序数组双指针, 先对数组进行排序，然后双指针法遍历数组得到相同元素
     * nums[m] 排序时间复杂度O(m*logm)
     * nums[n] 排序时间复杂度O(n*logn)
     * 空间复杂度 O(min(m,n))
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersectByTwoPointer(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int pointer1 = 0;
        int pointer2 = 0;
        int index = 0;
        int[] intersection = new int[Math.min(len1, len2)];
        while (pointer1 < len1 && pointer2 < len2) {
            if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                pointer2++;
            } else {
                intersection[index++] = nums1[pointer1];
                pointer1++;
                pointer2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
