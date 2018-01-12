public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        if (lenA > lenB) {
            for (int i = lenA - lenB ; i > 0 ; i--) headA = headA.next;
        } else if (lenB > lenA) {
            for (int i = lenB - lenA ; i > 0 ; i--) headB = headB.next;
        }
        while (headA != headB && headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }
        if (headA == null || headB == null) return null;
        return headA == headB ? headA : null;
    }
    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
