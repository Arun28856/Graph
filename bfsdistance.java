import java.util.*;

class Graph {
    private static final int nodes = 0;
    //initializing graph and visited array
    List<List<Integer>> graph;
    boolean visited[] = new boolean[nodes];
    
    Graph(int nodes){
        graph = new ArrayList<>();
        visited = new boolean[nodes];
        //adding nodes to the graph
        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }
    }
    public void addEdge(int a, int b)
    {
        graph.get(a).add(b);
    }

    //function to find the shprtest distance
    public int minimumDistanceBetweenTwoNodes(int source, int destination){
        if (source==destination) {
            return 0;
        }

        //initialize queue and minimum distance
        Queue<Integer> queue = new LinkedList<>();
        int minDistance = 0;

        //add source to the queue
        queue.add(source);
        visited[source] = true;

        //defining size of the queue
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Integer node = queue.poll();

                //set neigbhors
                List<Integer> chilList = graph.get(node);

                for (Integer child : chilList) {
                    //if child is visited
                    if (child==destination) {
                        return ++minDistance;
                    }
                    //if child is not visited
                    if(!visited[child]){
                        queue.add(child);
                        visited[child]=true;
                    }
                }

                size--;
            }

            minDistance++;

        }
        //if there is no path from source to destination
        return -1;

    }

}

public class bfsdistance{
    public static void main(String[] args) {
        int nodes=5;

        Graph a = new Graph(nodes);

        a.addEdge(0, 1);
        a.addEdge(0, 3);
        a.addEdge(1, 2);
        a.addEdge(2, 3);
        a.addEdge(3, 4);

        System.out.println(a.minimumDistanceBetweenTwoNodes(4, 0));

    }
}