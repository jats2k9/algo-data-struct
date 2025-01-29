package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graphs {

    /**
     * https://leetcode.com/problems/course-schedule/
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> adj = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            adj.put(prerequisite[1], prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i, visited, path, adj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(int i, boolean[] visited, boolean[] path, HashMap<Integer, Integer> adj) {
        if (!visited[i]) {
            visited[i] = true;
            path[i] = true;

            if (adj.get(i) != null && !visited[adj.get(i)] && hasCycle(adj.get(i), visited, path, adj)) {
                return true;
            } else if (adj.get(i) != null && path[adj.get(i)]) {
                return true;
            }
        }

        path[i] = false;
        return false;
    }


    // Function to detect cycle in a directed graph
    public static boolean isCyclic(List<List<Integer>> adj) {
        int vertices = adj.size();
        boolean[] visited = new boolean[vertices];
        boolean[] path = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && isCyclicHelper(i, visited, path, adj)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicHelper(int i, boolean[] visited, boolean[] path, List<List<Integer>> adj) {
        if (!visited[i]) {
            visited[i] = true;
            path[i] = true;
            List<Integer> targets = adj.get(i);
            for (int target : targets) {
                if (!visited[target] && isCyclicHelper(target, visited, path, adj)) {
                    return true;
                } else if (path[target]) {
                    return true;
                }
            }
        }
        path[i] = false;
        return false;
    }


    public static void main(String[] args) {
        canFinish(3, new int[][]{});


        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(3);


        // Function call
        if (isCyclic(adj)) {
            System.out.println("Contains cycle");
        } else {
            System.out.println("No Cycle");
        }
    }
}