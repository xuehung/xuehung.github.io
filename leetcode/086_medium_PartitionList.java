public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftNode = new ListNode(0), rightNode = new ListNode(0);
        ListNode leftPtr = leftNode, rightPtr = rightNode;
        while (head != null) {
            if (head.val < x) {
                leftPtr.next = head;
                leftPtr = head;
            } else {
                rightPtr.next = head;
                rightPtr = head;
            }
            head = head.next;
        }
        leftPtr.next = rightNode.next;
        rightPtr.next = null;
        return leftNode.next;
    }
}
