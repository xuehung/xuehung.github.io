public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummyRoot = new RandomListNode(0);
        RandomListNode ptr = dummyRoot;
        HashMap<RandomListNode, RandomListNode> oldToNew = new HashMap<>();
        while (head != null) {
            RandomListNode newNode = getCopy(head, oldToNew);
            ptr.next = newNode;
            ptr = ptr.next;
            if (head.random != null) {
                newNode.random = getCopy(head.random, oldToNew);
            }
            head = head.next;
        }
        return dummyRoot.next;
    }

    private RandomListNode getCopy(RandomListNode old, HashMap<RandomListNode, RandomListNode> oldToNew) {
        RandomListNode newNode = oldToNew.get(old);
        if (newNode == null) {
            newNode = new RandomListNode(old.label);
            oldToNew.put(old, newNode);
        }
        return newNode;
    }
}
