class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int overflow = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null)  {
                ptr.val = ptr.val + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                ptr.val = ptr.val + l2.val;
                l2 = l2.next;
            }
            overflow = ptr.val >= 10 ? 1 : 0;
            ptr.val -= (10 * overflow);
            if (l1 != null || l2 != null || overflow != 0) {
                ListNode nextNode = new ListNode(overflow);
                ptr.next = nextNode;
                ptr = ptr.next;
            }
        }
        return result;
    }
}
