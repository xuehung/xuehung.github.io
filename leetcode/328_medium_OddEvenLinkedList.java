public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = new ListNode(-1);
        ListNode evenTail = evenHead;
        ListNode oddHead = new ListNode(-1);
        ListNode oddTail = oddHead;
        ListNode ptr = head;
        boolean isOdd = true;
        while (ptr != null) {
            if (isOdd) {
                oddTail.next = ptr;
                oddTail = ptr;
            } else {
                evenTail.next = ptr;
                evenTail = ptr;
            }
            isOdd = !isOdd;
            ptr = ptr.next;
        }
        oddTail.next = evenHead.next;
        evenTail.next = null;
        return oddHead.next;

    }
}
