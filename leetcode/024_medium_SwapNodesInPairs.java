public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fakeNode = new ListNode(-1);
        fakeNode.next = head;
        ListNode ptr = fakeNode;
        while (ptr.next != null && ptr.next.next != null) {
            ListNode firstNode = ptr.next;
            ListNode thirdNode = ptr.next.next.next;
            ptr.next = firstNode.next;
            ptr.next.next = firstNode;
            firstNode.next = thirdNode;
            ptr = firstNode;
        }
        return fakeNode.next;
    }
}
