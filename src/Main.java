public class Main {

    public static void main(String[] args) {

        Experiment experiment = new Experiment();

        experiment.runMultipleTests();

        experiment.printResults();


        System.out.println("\nBonus Task: Dijkstra Algorithm");

        Graph weightedGraph = new Graph();

        for (int i = 0; i < 5; i++) {
            weightedGraph.addVertex(new Vertex(i));
        }

        weightedGraph.addWeightedEdge(0, 1, 4);
        weightedGraph.addWeightedEdge(0, 2, 2);
        weightedGraph.addWeightedEdge(1, 2, 1);
        weightedGraph.addWeightedEdge(1, 3, 5);
        weightedGraph.addWeightedEdge(2, 3, 8);
        weightedGraph.addWeightedEdge(3, 4, 3);

        weightedGraph.printWeightedGraph();

        weightedGraph.dijkstra(0);
    }
}