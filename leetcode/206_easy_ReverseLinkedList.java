// Importance:x
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode nextPtr = head.next;
        head.next = null;
        while (nextPtr != null) {
            ListNode nextNext = nextPtr.next;
            nextPtr.next = head;
            head = nextPtr;
            nextPtr = nextNext;
        }
        return head;
    }
}
