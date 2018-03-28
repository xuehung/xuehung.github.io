class Trie {
    static class Node {
        Node[] next = new Node[26];
        boolean hasValue;
    }
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node ptr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (ptr.next[idx] == null) {
                ptr.next[idx] = new Node();
            }
            ptr = ptr.next[idx];
        }
        ptr.hasValue = true;
    }

    public boolean search(String word) {
        Node ptr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (ptr.next[idx] == null) {
                return false;
            }
            ptr = ptr.next[idx];
        }
        return ptr.hasValue;
    }

    public boolean startsWith(String prefix) {
        Node ptr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (ptr.next[idx] == null) {
                return false;
            }
            ptr = ptr.next[idx];
        }
        return true;
    }
}
