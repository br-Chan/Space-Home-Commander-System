import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    Map<T, List<T>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public void addNode(T node) {
        adjacencyMap.putIfAbsent(node, new ArrayList<>());
    }

    public void removeNode(T node) {
        adjacencyMap.remove(node);
        for (T key : adjacencyMap.keySet()) {
            adjacencyMap.get(key).remove(node);
        }
    }

    public void addEdge(T node1, T node2) {
        // TODO add exception here for device not found
        adjacencyMap.get(node1).add(node2);
        adjacencyMap.get(node2).add(node1);
    }

    public void removeEdge(T node1, T node2) {
        // TODO add exception here for device not found
        adjacencyMap.get(node1).remove(node2);
        adjacencyMap.get(node2).remove(node1);        
    }

}
