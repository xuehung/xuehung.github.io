class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        int newLen = Math.max(len1, len2);
        int[] num = new int[newLen];
        for (int i = newLen ; i > 0 ; i--) {
            int idx = newLen - i;
            if (i <= len1) {
                num[idx] += l1.val;
                l1 = l1.next;
            }
            if (i <= len2) {
                num[idx] += l2.val;
                l2 = l2.next;
            }
        }
        ListNode ptr = null;
        int carry = 0;
        for (int i = num.length - 1 ; i >= 0 ; i--) {
            int n = num[i] + carry;
            if (n >= 10) {
                n -= 10;
                carry = 1;
            } else carry = 0;
            ListNode newNode = new ListNode(n);
            newNode.next = ptr;
            ptr = newNode;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(1);
            newNode.next = ptr;
            ptr = newNode;
        }
        return ptr;
    }

    private int getLen(ListNode root) {
        int len = 0;
        while (root != null) {
            len++;
            root = root.next;
        }
        return len;
    }
}
