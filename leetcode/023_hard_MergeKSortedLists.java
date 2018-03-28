// Importance:xxx
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (n1, n2) -> n1.val - n2.val);
        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }
        ListNode fakeRoot = new ListNode(0);
        ListNode ptr = fakeRoot;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            ptr.next = node;
            ptr = ptr.next;
            if (node.next != null) pq.add(node.next);
        }
        return fakeRoot.next;
    }
}
