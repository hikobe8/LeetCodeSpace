package basic.linkedlist;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {

    }

    public class ListNode {
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
     * 两次遍历，第一次确定链表的长度，第二次创建一个空节点的next指向head，然后判断位置删除
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            len++;
        }
        int target = len - n;
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;
        int index = 0;
        current = tmpHead;
        while (current.next != null) {
            if (index == target) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
            index++;
        }
        return tmpHead.next;
    }

    /**
     * 双指针法，可以一次遍历实现删除，first指针开始，遍历了n个后,second指针开始，等到first遍历到最后之后，second指针的下一个
     * 就是目标元素，进行删除操作.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        int i = 0;
        while (first.next != null) {
            first = first.next;
            i++;
            if (i > n - 1) {
                second = second.next;
            }
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
