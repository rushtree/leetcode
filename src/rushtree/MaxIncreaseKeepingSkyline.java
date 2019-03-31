package rushtree;

public class MaxIncreaseKeepingSkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] top = new int[grid[0].length];
        int[] left = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > left[i])
                    left[i] = grid[i][j];

                if (grid[i][j] > top[j])
                    top[j] = grid[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                result += Math.min(top[j], left[i]) - grid[i][j];
            }
        }
        return result;
    }
}
