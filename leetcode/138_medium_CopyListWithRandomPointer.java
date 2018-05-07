// Importance:xxx
public class Solution {
    Map<RandomListNode, RandomListNode> mapping = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode prev = null;
        RandomListNode headBackup = head;
        while (head != null) {
            RandomListNode copy = getCopy(head);
            if (prev != null) {
                prev.next = copy;
            }
            copy.random = getCopy(head.random);
            prev = copy;
            head = head.next;
        }
        return getCopy(headBackup);
    }

    RandomListNode getCopy(RandomListNode node) {
        if (node == null) return null;
        RandomListNode copy = mapping.get(node);
        if (copy == null) {
            copy = new RandomListNode(node.label);
            mapping.put(node, copy);
        }
        return copy;
    }
}
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
