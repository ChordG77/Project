package Day230921;

import org.w3c.dom.ls.LSException;

import java.util.*;

/**
 * There exists an undirected and unrooted tree with n nodes indexed from 0 to n - 1. You are given an integer n and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an array coins of size n where coins[i] can be either 0 or 1, where 1 indicates the presence of a coin in the vertex i.
 * <p>
 * Initially, you choose to start at any vertex in the tree. Then, you can perform the following operations any number of times:
 * <p>
 * Collect all the coins that are at a distance of at most 2 from the current vertex, or
 * Move to any adjacent vertex in the tree.
 * Find the minimum number of edges you need to go through to collect all the coins and go back to the initial vertex.
 * <p>
 * Note that if you pass an edge several times, you need to count it into the answer several times.
 * <p>
 * Example 1:
 * Input: coins = [1,0,0,0,0,1], edges = [[0,1],[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: Start at vertex 2, collect the coin at vertex 0, move to vertex 3, collect the coin at vertex 5 then move back to vertex 2.
 * <p>
 * Input: coins = [0,0,0,1,1,0,0,1], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[5,6],[5,7]]
 * Output: 2
 * Explanation: Start at vertex 0, collect the coins at vertices 4 and 3, move to vertex 2,  collect the coin at vertex 7, then move back to vertex 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == coins.length
 * 1 <= n <= 3 * 104
 * 0 <= coins[i] <= 1
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges represents a valid tree.
 */
public class GetCoins {
    public static final int[] coins = {1, 0, 0, 0, 0, 1};
    public static final int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};

    public static void main(String[] args) {
        System.out.println(collectTheCoins(coins, edges));

    }

    public static int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        int[] degree = new int[n];
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1 && coins[i] == 0) {
                queue.offer(i);
            }
        }

        int rest = n;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            rest--;
            degree[u]--;
            for (int v : adj[u]) {
                degree[v]--;
                if (coins[v] == 0 && degree[v] == 1) {
                    queue.offer(v);
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (degree[j] == 1) {
                    queue.offer(j);
                }
            }
            while (!queue.isEmpty()) {
                int u = queue.poll();
                degree[u]--;
                rest--;
                for (int v : adj[u]) {
                    degree[v]--;
                }
            }
        }
        return rest == 0 ? 0 : (rest - 1) * 2;
    }
}

