// Importance: x
// Use quicksort?
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode leftNode = new ListNode(0), rightNode = new ListNode(0);
        ListNode leftPtr = leftNode, rightPtr = rightNode;
        int n = 0;
        while(head != null) {
            if (n++ % 2 == 0) {
                leftPtr.next = head;
                leftPtr = head;
            } else {
                rightPtr.next = head;
                rightPtr = head;
            }
            head = head.next;
        }
        leftPtr.next = null;
        rightPtr.next = null;
        return merge(sortList(leftNode.next), sortList(rightNode.next));
    }
    private ListNode merge(ListNode left, ListNode right) {
        ListNode fakeHead = new ListNode(0);
        ListNode ptr = fakeHead;
        while (left != null) {
            if (right != null && right.val < left.val) {
                ptr.next = right;
                right = right.next;
            } else {
                ptr.next = left;
                left = left.next;
            }
            ptr = ptr.next;
        }
        ptr.next = right;
        return fakeHead.next;
    }
}
