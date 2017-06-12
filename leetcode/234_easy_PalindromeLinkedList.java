public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode ptr = head ; ptr != null ; ptr = ptr.next) list.add(ptr.val);
        for (int i = 0, j = list.size() - 1 ; i < j ; i++, j--) {
            if (!list.get(i).equals(list.get(j))) return false;
        }
        return true;
    }
}
