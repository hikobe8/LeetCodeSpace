package framework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> res = permute.permute(new int[]{1, 2, 3});
        for (List<Integer> list : res) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return result;
    }

    public void backTrack(int[] nums, LinkedList<Integer> track) {
        //结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //去重,排除不符合的条件
            if (track.contains(nums[i]))
                continue;
            //选择
            track.add(nums[i]);
            //进入下一层决策树
            backTrack(nums, track);
            //取消选择
            track.removeLast();
        }
    }

}
