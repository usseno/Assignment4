import java.util.*;

public class Graph {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private ArrayList<ArrayList<Integer>> adjacencyList;
    private ArrayList<ArrayList<Edge>> weightedList;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        adjacencyList = new ArrayList<>();
        weightedList = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
        adjacencyList.add(new ArrayList<>());
        weightedList.add(new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adjacencyList.get(from).add(to);
        edges.add(new Edge(from, to, 1));
    }

    public void addUndirectedEdge(int from, int to) {
        addEdge(from, to);
        addEdge(to, from);
    }


    public void addWeightedEdge(int from, int to, int weight) {
        weightedList.get(from).add(new Edge(from, to, weight));
        weightedList.get(to).add(new Edge(to, from, weight)); // undirected
    }

    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }


    public void printWeightedGraph() {
        System.out.println("Weighted Adjacency List:");
        for (int i = 0; i < weightedList.size(); i++) {
            System.out.print(i + " -> ");
            for (Edge edge : weightedList.get(i)) {
                System.out.print(edge.getDestination() + "(" + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertices.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjacencyList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[vertices.size()];
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int neighbor : adjacencyList.get(current)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }


    public void dijkstra(int start) {
        int[] distance = new int[vertices.size()];
        boolean[] visited = new boolean[vertices.size()];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int count = 0; count < vertices.size() - 1; count++) {
            int minVertex = -1;

            for (int i = 0; i < vertices.size(); i++) {
                if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                    minVertex = i;
                }
            }

            if (minVertex == -1) {
                break;
            }

            visited[minVertex] = true;

            for (Edge edge : weightedList.get(minVertex)) {
                int neighbor = edge.getDestination();
                int weight = edge.getWeight();

                if (!visited[neighbor] && distance[minVertex] != Integer.MAX_VALUE
                        && distance[minVertex] + weight < distance[neighbor]) {
                    distance[neighbor] = distance[minVertex] + weight;
                }
            }
        }

        System.out.println("Dijkstra shortest distances from vertex " + start + ":");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(start + " -> " + i + " = " + distance[i]);
        }
    }
}