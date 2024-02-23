import java.util.*;

public class FindCheapestPrice {
    static class Node{
        int vertex;
        int cost;
        int stops;

        public Node(int vertex, int cost, int stops) {
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a.cost,b.cost));
        minHeap.add(new Node(src, 0, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();

            if (current.vertex == dst) {
                return current.cost;
            }

            if (current.stops <= k) {
                List<int[]> neighbors = graph.getOrDefault(current.vertex, new ArrayList<>());
                for (int[] neighbor : neighbors) {
                    minHeap.add(new Node(neighbor[0], current.cost + neighbor[1], current.stops + 1));
                }
            }
        }

        return -1;  
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;

        int result = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }
}
