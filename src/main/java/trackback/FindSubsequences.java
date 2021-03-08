package trackback;

import java.util.*;

/**
 * 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubsequences {

    public static void main(String[] args) {
        FindSubsequences findSubsequences = new FindSubsequences();
        int[] nums = new int[]{4,6,7,7};
        List<List<Integer>> subsequences = findSubsequences.findSubsequences(nums);
        for (List<Integer> subsequence : subsequences) {
            for (Integer integer : subsequence) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, 0, new LinkedList<>(), res);
        return res;
    }

    private void dfs(int [] nums, int start , LinkedList<Integer> track, List<List<Integer>> res){
        if (track.size() > 1){
            res.add(new ArrayList<>(track));
        }
        Set<Integer> visited = new HashSet<>();
        for (int j = start; j < nums.length; j++) {
            if (!track.isEmpty() && track.getLast() > nums[j] || visited.contains(nums[j])) {
                continue;
            }
            visited.add(nums[j]);
            track.add(nums[j]);
            dfs(nums, j + 1, track, res);
            track.removeLast();
        }
    }

}
