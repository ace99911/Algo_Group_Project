import java.util.*;
import java.util.concurrent.TimeUnit;

public class Dijkstra_Algorithm {
    // Main variable for the class
    private char source_node;
    private char destination_node;
    private int distance[];
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;

    //number of vertices
    private int V;
    List<List<Node>> adj;

    //create constructor for the class
    public Dijkstra_Algorithm(int V) {
        this.V = V;
        distance = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());

    }

    //Dijkstra algo
    public void dijkstra(List<List<Node>> adj, int source) {
        this.adj = adj;

        for  (int i = 0; i < V; i++) {
            distance [i] = Integer.MAX_VALUE;
        }
        //add source node to the prio queue
        pq.add(new Node(source,0));

        //distance to source is 0
        distance[source] = 0;

        while (settled.size() != V) {

            //create a terminating condition check when the prio queue is empty

            if (pq.isEmpty())
                break;

            //remove the minimum distance node from prio queue
            int u = pq.remove().node;

            //adding the node whose distance is finalized
            if (settled.contains(u))
                continue;

            //no need to call e_neighbour(u)
            //if u already present in the settled set
            settled.add(u);

            e_Neighbour(u);
            }
        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
    }

    //Add another method
    //Used to process all the neighbours of the passed node
    private void e_Neighbour(int u) {

        int edgeDistance, newDistance;

        //create for loop to check all neighbours of v
        for (int i = 0; i <adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            //check if current node not been processed
            if (!settled.contains(v.node)){
                edgeDistance = v.cost;
                newDistance = distance[u]+ edgeDistance;

                // check if new distance is cheaper in cost
                if (newDistance < distance[v.node]) {
                    distance[v.node] = newDistance;
                }
                pq.add(new Node(v.node, distance[v.node]));
            }
        }

    }

    //create main method
    public static void main(String[] args) {
        int V = 12;
        int source = 0;

        List<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // A <-> D (3.5)
        adj.get(0).add(new Node(3, 35));
        adj.get(3).add(new Node(0, 35));

        // A <-> E (4.5)
        adj.get(0).add(new Node(4, 45));
        adj.get(4).add(new Node(0, 45));

        // B <-> D (5.0)
        adj.get(1).add(new Node(3, 50));
        adj.get(3).add(new Node(1, 50));

        // C <-> E (3.0)
        adj.get(2).add(new Node(4, 30));
        adj.get(4).add(new Node(2, 30));

        // C <-> I (6.0)
        adj.get(2).add(new Node(8, 60));
        adj.get(8).add(new Node(2, 60));

        // C <-> J (4.0)
        adj.get(2).add(new Node(9, 40));
        adj.get(9).add(new Node(2, 40));

        // D <-> E (2.5)
        adj.get(3).add(new Node(4, 25));
        adj.get(4).add(new Node(3, 25));

        // D <-> I (5.5)
        adj.get(3).add(new Node(8, 55));
        adj.get(8).add(new Node(3, 55));

        // D <-> G (3.0)
        adj.get(3).add(new Node(6, 30));
        adj.get(6).add(new Node(3, 30));

        // E <-> G (6.5)
        adj.get(4).add(new Node(6, 65));
        adj.get(6).add(new Node(4, 65));

        // E <-> K (3.5)
        adj.get(4).add(new Node(10, 35));
        adj.get(10).add(new Node(4, 35));

        // G <-> H (3.5)
        adj.get(6).add(new Node(7, 35));
        adj.get(7).add(new Node(6, 35));

        // J <-> K (3.0)
        adj.get(9).add(new Node(10, 30));
        adj.get(10).add(new Node(9, 30));

        // K <-> L (4.0)
        adj.get(10).add(new Node(11, 40));
        adj.get(11).add(new Node(10, 40));

        //get the start time
        long startTime = System.nanoTime();
        Dijkstra_Algorithm dij = new Dijkstra_Algorithm(V);
        dij.dijkstra(adj, source);

        //get the end time
        long endTime = System.nanoTime();

        // Printing the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");

        for (int i = 0; i < dij.distance.length; i++) {
            int j = i+65;
            dij.source_node = (char) 65;
            dij.destination_node = (char) j;
            System.out.println(dij.source_node + " to " + dij.destination_node + " is "
                    + dij.distance[i]);
        }
        System.out.println("Time taken in millisecond: "+(endTime-startTime)+" ns");
    }
}

// Class 2
// Helper class implementing Comparator interface
// Representing a node in the graph
class Node implements Comparator<Node> {

    // Member variables of this class
    public int node;
    public int cost;

    // Constructors of this class

    // Constructor 1
    public Node() {}

    // Constructor 2
    public Node(int node, int cost)
    {

        // This keyword refers to current instance itself
        this.node = node;
        this.cost = cost;
    }

    // Method 1
    @Override public int compare(Node node1, Node node2)
    {

        if (node1.cost < node2.cost)
            return -1;

        if (node1.cost > node2.cost)
            return 1;

        return 0;
    }
}