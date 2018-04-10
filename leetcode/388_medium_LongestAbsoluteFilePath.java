// Importance:xxxx
class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int[] stack = new int[lines.length];
        int maxLen = 0;
        for(String line : lines) {
            int level = line.lastIndexOf("\t") + 1;
            int currentLen = (level == 0 ? 0 : stack[level - 1] + 1) + line.length() - level;
            stack[level] = currentLen;
            if (line.indexOf(".") >= 0) maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }
}
class Solution {
    class Node {
        List<Node> nexts;
        String name;
        public Node(String name) {
            this.nexts = new ArrayList<>();
            this.name = name;
        }
    }
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        Stack<Node> stack = new Stack<>();
        Node root = new Node("");
        int currentLevel = 0;
        for (String line : lines) {
            System.out.println("line = "+line);
            String cleanName = line.replace("\t", "");
            int level = line.length() - cleanName.length() + 1;
            Node node = new Node(cleanName);
            if (level > currentLevel) {
                stack.push(root);
                if (root.nexts.size() > 0) root = root.nexts.get(root.nexts.size() - 1);
                root.nexts.add(node);
                currentLevel++;
                continue;
            } else if (level < currentLevel) {
                while (level < currentLevel) {
                    root = stack.pop();
                    currentLevel--;
                }
            }
            root.nexts.add(node);
        }
        while (!stack.isEmpty()) root = stack.pop();
        return Math.max(0, helper(root, 0) - 1);
    }

    private int helper(Node root, int level) {
        boolean isFile = root.name.indexOf(".") >= 0;
        int nameLen = root.name.length();
        if (root.nexts.isEmpty()) return isFile ? nameLen : 0;
        int maxLen = 0;
        for (int i = 0 ; i < level ; i++) System.out.print("  ");
        level++;
        for (Node n : root.nexts) {
            int v = helper(n, level);
            if (v > 0) {
                maxLen = Math.max(maxLen, nameLen + v + 1);
            }
        }
        return maxLen;
    }   
}
