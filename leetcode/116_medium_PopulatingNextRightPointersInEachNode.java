// Importance: x
public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null && root.left != null) {
            TreeLinkNode ptr = root;
            while (ptr != null) {
                ptr.left.next = ptr.right;
                if (ptr.next != null) {
                    ptr.right.next = ptr.next.left;
                }
                ptr = ptr.next;
            }
            root = root.left;
        }
    }
}
