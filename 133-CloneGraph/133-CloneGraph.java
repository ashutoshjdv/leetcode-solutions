// Last updated: 6/26/2026, 8:55:03 AM
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> visited = new HashMap<>();

        Node clonedNode = dfs(node, visited);

        return clonedNode;
    }

    public Node dfs(Node node, Map<Node,Node> visited) {

        if(node == null ) return null;

        if(visited.containsKey(node)) return visited.get(node);

        Node clonedNode = new Node(node.val);


        visited.put(node, clonedNode);

        List<Node> neighbors = new ArrayList<>();

        for(Node neighbor : node.neighbors) {
            neighbors.add(dfs(neighbor, visited));
        }

        clonedNode.neighbors = neighbors;


        return clonedNode;

    }
}