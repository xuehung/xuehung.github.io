class Solution {

    int len = 0;
    ListNode head = null;
    Random r = new Random();
    /** @param head The linked list's head.
     *         Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        while (head != null) {
            len++;
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int n = len;
        ListNode ptr = head;
        while (n > 0) {
            if (r.nextFloat() < 1.0 / n) return ptr.val;
            ptr = ptr.next;
            n--;
        }
        return ptr.val;
    }
}
