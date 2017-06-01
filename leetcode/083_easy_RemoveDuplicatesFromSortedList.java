public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            ListNode nextNotDuplicate = ptr.next;
            while (nextNotDuplicate != null && nextNotDuplicate.val == ptr.val) nextNotDuplicate = nextNotDuplicate.next;
            ptr.next = nextNotDuplicate;
            ptr = ptr.next;
        }
        return head;
    }
}
