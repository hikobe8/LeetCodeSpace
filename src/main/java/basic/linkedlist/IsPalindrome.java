package basic.linkedlist;

import java.util.ArrayList;


/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    /**
     * 复制到一个数组里面再通过双指针首尾遍历进行判断,时间复杂度O(2n), 空间复杂度O(n)
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> array = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            array.add(current);
            current = current.next;
        }
        int len = array.size() / 2;
        for (int i = 0; i < len; i++) {
            if (array.get(i).val != array.get(array.size() - i - 1).val) {
                return false;
            }
        }
        return true;
    }

}
