class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextPtr = head.next;
        head.next = null;
        nextPtr = insertionSortList(nextPtr);
        ListNode fakeNode = new ListNode(0);
        ListNode prev = fakeNode;
        while (nextPtr != null && head.val > nextPtr.val) {
            prev.next = nextPtr;
            prev = nextPtr;
            nextPtr = nextPtr.next;
        }
        if (nextPtr == null) prev.next = head;
        else {
            prev.next = head;
            head.next = nextPtr;
        }
        return fakeNode.next;
    }
}
