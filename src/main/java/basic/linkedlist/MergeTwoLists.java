package basic.linkedlist;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 1->2->3
     * 4->5->6
     * <p>
     * 双指针
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                current.next = c1;
                c1 = c1.next;
            } else {
                current.next = c2;
                c2 = c2.next;
            }
            current = current.next;
        }
        current.next = c1 == null ? c2 : c1;
        return dummy.next;
    }

}
