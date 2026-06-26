// Last updated: 6/26/2026, 8:54:41 AM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) return new String();
        
        Deque<TreeNode> queue = new LinkedList<>();

        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        queue.offer(root);

        while(!queue.isEmpty()) {

            TreeNode polledNode = queue.removeFirst();

            if(polledNode == null) {
                list.add("null");
                continue;
            }

            else list.add(Integer.toString(polledNode.val));

            queue.add(polledNode.left);
            queue.add(polledNode.right);
        }

        int i = list.size() - 1;
        while (i >= 0 && list.get(i).equals("null")) {
            list.remove(i);
            i--;
        }

        return String.join(",", list);


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == null || data.isEmpty()) return null;

        String[] nodes = data.split(",");

        TreeNode pointer;

        Deque<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        queue.offer(root);

        int dataPointer = 0;

        while(!queue.isEmpty()) {

            TreeNode node = queue.poll();

            dataPointer++;

            if(dataPointer < nodes.length) {
                TreeNode left = nodes[dataPointer].equals("null") ? null : new TreeNode(Integer.parseInt(nodes[dataPointer]));

                if(left != null) queue.offer(left);

                node.left = left;

            }

            dataPointer++;

            if(dataPointer < nodes.length) {
                TreeNode right = nodes[dataPointer].equals("null") ? null : new TreeNode(Integer.parseInt(nodes[dataPointer]));

                if(right != null) queue.offer(right);

                node.right = right;

            }

        }

        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));