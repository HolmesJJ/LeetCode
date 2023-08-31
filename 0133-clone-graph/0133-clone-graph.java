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
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> qn = new LinkedList<>();

        qn.add(node);
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        while (!qn.isEmpty()) {
            Node oldN = qn.poll();
            Node newN = visited.get(oldN);
            for (int i = 0; i < oldN.neighbors.size(); i++) {
                Node oldNN = oldN.neighbors.get(i);
                if (visited.get(oldNN) == null) {
                    Node newNN = new Node(oldNN.val);
                    visited.put(oldNN, newNN);
                    newN.neighbors.add(newNN);
                    qn.add(oldNN);
                } else {
                    if (!newN.neighbors.contains(oldNN)) {
                        newN.neighbors.add(visited.get(oldNN));
                    }
                }
            }
        }
        return newNode;
    }
}