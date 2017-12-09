// Importance:xxx
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        ListNode a = fakeNode;
        for (int i = 1 ; i < m ; i++) a = a.next;
        ListNode last = a.next;
        ListNode ptr = last;
        ListNode next = ptr.next;
        for (int i = n - m ; i > 0 ; i--) {
            ListNode tmp = next.next;
            next.next = ptr;
            ptr = next;
            next = tmp;
        }
        a.next = ptr;
        last.next = next;
        return fakeNode.next;
    }
}
