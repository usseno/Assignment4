public class Experiment {

    public Graph createGraph(int size) {
        Graph graph = new Graph();

        for (int i = 0; i < size; i++) {
            graph.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {
            graph.addUndirectedEdge(i, i + 1);
        }

        for (int i = 0; i < size - 2; i += 2) {
            graph.addUndirectedEdge(i, i + 2);
        }

        return graph;
    }

    public void runTraversals(Graph graph) {
        graph.bfs(0);
        graph.dfs(0);
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            Graph graph = createGraph(size);

            System.out.println("Graph size: " + size);

            if (size == 10) {
                graph.printGraph();
            }

            long startBfs = System.nanoTime();
            graph.bfs(0);
            long endBfs = System.nanoTime();

            long startDfs = System.nanoTime();
            graph.dfs(0);
            long endDfs = System.nanoTime();

            System.out.println("BFS time: " + (endBfs - startBfs) + " ns");
            System.out.println("DFS time: " + (endDfs - startDfs) + " ns");
            System.out.println("-------------------------");
        }
    }

    public void printResults() {
        System.out.println("Experiment completed.");
    }
}