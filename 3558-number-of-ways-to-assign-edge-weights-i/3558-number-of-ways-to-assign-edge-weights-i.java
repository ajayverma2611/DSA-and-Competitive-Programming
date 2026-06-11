import java.util.*;

class Solution {

    private long power(long a, long b, long mod) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }

        return res;
    }

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1; // number of nodes

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected tree
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        q.add(new Pair<>(1, 0));

        int[] vis = new int[n + 1];
        vis[1] = 1;

        int max = -1;

        while (!q.isEmpty()) {
            Pair<Integer, Integer> curr = q.poll();

            int node = curr.getKey();
            int c = curr.getValue();

            max = Math.max(max, c);

            for (int l : adj.get(node)) {
                if (vis[l] == 0) {
                    vis[l] = 1;
                    q.add(new Pair<>(l, c + 1));
                }
            }
        }

        return (int) power(2, max - 1, 1000000007L);
    }
}