package HC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private int numVerticals;
    private Map<String, Map<Character, Integer>> vertices;

    public Graph(int numVerticals) {
        this.numVerticals = numVerticals;
        vertices = new HashMap<>();
        for (int i = 0; i < numVerticals; i++) {
            vertices.put(String.valueOf((char) (i + 65)), new HashMap<>());
        }

    }

    public void addEdge(String start, String end, int weight) {
        vertices.get(start).put(end.charAt(0), weight);
    }


    public Map<String, Map<Character, Integer>> getVertices() {
        return vertices;
    }
    public void hillClimbing() {
        Map<String, Map<Character, Integer>> vertices = getVertices();
        String currentVertex = "A";
        StringBuilder path = new StringBuilder(currentVertex);
        while (true) {
            Map<Character, Integer> connectedVertices = vertices.get(currentVertex);
            if (connectedVertices == null || connectedVertices.isEmpty()) {
                break;
            }
            int minCost = Integer.MAX_VALUE;
            String nextVertex = null;
            for (Map.Entry<Character, Integer> entry : connectedVertices.entrySet()) {
                if (entry.getValue() < minCost) {
                    minCost = entry.getValue();
                    nextVertex = entry.getKey().toString();
                }
            }
            vertices.remove(currentVertex);
            currentVertex = nextVertex;
            path.append(" -> ").append(currentVertex);
        }
        System.out.println("Path: " + path.toString());
    }
}
