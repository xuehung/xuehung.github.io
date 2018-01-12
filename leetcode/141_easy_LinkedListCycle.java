public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slowPtr = head;
        ListNode fastPtr = head.next;
        while (fastPtr != null) {
            if (fastPtr == slowPtr) return true;
            fastPtr = fastPtr.next;
            if (fastPtr == null) return false;
            if (fastPtr == slowPtr) return true;
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        return false;
    }
}
