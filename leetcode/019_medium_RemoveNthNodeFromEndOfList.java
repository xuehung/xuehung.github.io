class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeNode = new ListNode(0);
        ListNode ptr = fakeNode;
        LinkedList<ListNode> queue = new LinkedList<>();
        while (head != null) {
            if (queue.size() == n) {
                ptr.next = queue.poll();
                ptr = ptr.next;
            }
            queue.add(head);
            head = head.next;
        }
        queue.poll();
        ptr.next = queue.poll();
        return fakeNode.next;
    }
}
