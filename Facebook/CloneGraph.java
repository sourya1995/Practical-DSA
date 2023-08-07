package Facebook;

public class CloneGraph {
    private Map<Node, Node> visited;
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        visited = new HashMap<>();
        return cloneNode(node);
    }

    private Node cloneNode(Node node) {
        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors){
            clonedNode.neighbors.add(cloneNode(neighbor));
        }

        return clonedNode;
    }
}
