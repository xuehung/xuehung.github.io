public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) sb.append("N").append(",");
        else {
            sb.append(root.val).append(",");;
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Deque<String> nodes = new LinkedList<>();
        for (String s : arr) nodes.add(s);
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Deque<String> data) {
        String val = data.remove();
        if ("N".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(data);
        root.right = deserializeHelper(data);
        return root;
    }
}
