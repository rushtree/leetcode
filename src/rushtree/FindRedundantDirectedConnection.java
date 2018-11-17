package rushtree;

public class FindRedundantDirectedConnection {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        int[] parents = new int[len + 1];
        int[] fistEdge = new int[2];
        int[] secondEdge = new int[2];
        for (int i = 0; i < len; i++) {
            int[] edge = edges[i];
            if (parents[edge[1]] == 0) {
                parents[edge[1]] = edge[0];
            } else {
                fistEdge[0] = parents[edge[1]];
                fistEdge[1] = edge[1];
                secondEdge[0] = edge[0];
                secondEdge[1] = edge[1];
                edge[1] = 0;
            }
        }
        int[] connects = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            connects[i] = i;
        }
        for (int i = 0; i < len; i++) {
            int[] edge = edges[i];
            if (edge[1] == 0) continue;
            int x = getRoot(connects, edge[0]);
            int y = getRoot(connects, edge[1]);
            if (x == y) {
                if (fistEdge[0] == 0 && fistEdge[1] == 0) {
                    return edge;
                } else {
                    return fistEdge;
                }
            }
            connects[x] = y;
        }
        return secondEdge;
    }

    private int getRoot(int[] roots, int i) {
        if (roots[i] != i)
            return getRoot(roots, roots[i]);
        else
            return i;
    }
}
