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
    public void dfs(Node node, Node copy, Map<Integer, Node> map, Set<Integer> vis) {

        int val = node.val;

        if (vis.contains(val))
            return;
        vis.add(val);

        if (map.get(val) != null) {
            copy = map.get(val);
        } else {
            Node temp = new Node(val);
            map.put(val, temp);
            copy = temp;
        }

        for (Node adjNode : node.neighbors) {

            dfs(adjNode, map.get(adjNode.val), map, vis);

            int adjVal = adjNode.val;
            Node adjNodeCopy = null;

            if (map.get(adjVal) == null) {
                adjNodeCopy = new Node(adjVal);
                copy.neighbors.add(adjNodeCopy);
                map.put(adjVal, adjNodeCopy);
            } else {
                adjNodeCopy = map.get(adjVal);
                copy.neighbors.add(adjNodeCopy);
            }
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> map = new HashMap<>();
        dfs(node, null, map, new HashSet<>());
        return map.get(node.val);
    }
}