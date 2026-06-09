package pekan9_2511532009;
import java.util.*;

public class GraphTraversal_2511532009 {
    private Map<String, List<String>> graph_2009 = new HashMap<>();

    // Menambahkan edge (graf tak berarah)
    public void addEdge_2009(String node1_2009, String node2_2009) {
        graph_2009.putIfAbsent(node1_2009, new ArrayList<>());
        graph_2009.putIfAbsent(node2_2009, new ArrayList<>());
        graph_2009.get(node1_2009).add(node2_2009);
        graph_2009.get(node2_2009).add(node1_2009);
    }

    // Menampilkan graf awal
    public void printGraph_2009() {
        System.out.println("Graf Awal (Adjacency List) : ");
        for (String node_2009 : graph_2009.keySet()) {
            System.out.print(node_2009 + "-> ");
            List<String> neighbors_2009 = graph_2009.get(node_2009);
            System.out.println(String.join(",", neighbors_2009));
        }
        System.out.println();
    }

    // DFS rekursif
    public void dfs_2009(String start_2009) {
        Set<String> visited_2009 = new HashSet<>();
        System.out.println("Penelusuran DFS : ");
        dfsHelper_2009(start_2009, visited_2009);
        System.out.println();
    }

    private void dfsHelper_2009(String current_2009, Set<String> visited_2009) {
        if (visited_2009.contains(current_2009)) return;
        visited_2009.add(current_2009);
        System.out.print(current_2009 + " ");
        for (String neighbor_2009 : graph_2009.getOrDefault(current_2009, new ArrayList<>())) {
            dfsHelper_2009(neighbor_2009, visited_2009);
        }
    }

    private void bfs_2009(String start_2009) {
        Set<String> visited_2009 = new HashSet<>();
        Queue<String> queue_2009 = new LinkedList<>();
        queue_2009.add(start_2009);
        visited_2009.add(start_2009);
        System.out.println("Penelusuran BFS :");
        while (!queue_2009.isEmpty()) {
            String current_2009 = queue_2009.poll();
            System.out.print(current_2009 + " ");
            for (String neighbor_2009 : graph_2009.getOrDefault(current_2009, new ArrayList<>())) {
                if (!visited_2009.contains(neighbor_2009)) {
                    queue_2009.add(neighbor_2009);
                    visited_2009.add(neighbor_2009);
                }
            }
        }
        System.out.println();
    }

    // main
    public static void main(String[] Args) {
        GraphTraversal_2511532009 graph_2009 = new GraphTraversal_2511532009();

        // contoh graf = A-B, A-C, B-D, B-E
        graph_2009.addEdge_2009("A", "B");
        graph_2009.addEdge_2009("A", "C");
        graph_2009.addEdge_2009("B", "D");
        graph_2009.addEdge_2009("B", "E");

        // cetak graph awal
        System.out.println("Graf Awal adalah : ");
        graph_2009.printGraph_2009();

        // lakukan penelusuran
        graph_2009.dfs_2009("A");
        graph_2009.bfs_2009("A");
    }
}
