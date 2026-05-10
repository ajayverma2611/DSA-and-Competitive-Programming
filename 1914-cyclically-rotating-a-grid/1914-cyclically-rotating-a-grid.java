class Solution {
    public int[][] rotateGrid(int[][] grid, int t) {

        int n = grid.length;
        int m = grid[0].length;

        int i = 0;
        int j = 0;
        int k = n;
        int l = m;

        while (i < k && j < l) {

            int size = 2 * (k - i) + 2 * (l - j) - 4;

            int[] tmp = new int[size];

            int o = 0;
            int d = 1;

            while (d <= 4) {

                if (d == 1) {
                    for (int p = j; p < l; p++) {
                        tmp[o] = grid[i][p];
                        o++;
                    }
                }

                if (d == 2) {
                    for (int p = i + 1; p < k; p++) {
                        tmp[o] = grid[p][l - 1];
                        o++;
                    }
                }

                if (d == 3) {
                    for (int p = l - 2; p >= j; p--) {
                        tmp[o] = grid[k - 1][p];
                        o++;
                    }
                }

                if (d == 4) {
                    for (int p = k - 2; p > i; p--) {
                        tmp[o] = grid[p][j];
                        o++;
                    }
                }

                d++;
            }

            int r = t % size;

            int[] tmp2 = new int[size];

            for (int q = 0; q < size; q++) {
                tmp2[q] = tmp[(q + r) % size];
            }

            o = 0;
            d = 1;

            while (d <= 4) {

                if (d == 1) {
                    for (int p = j; p < l; p++) {
                        grid[i][p] = tmp2[o];
                        o++;
                    }
                }

                if (d == 2) {
                    for (int p = i + 1; p < k; p++) {
                        grid[p][l - 1] = tmp2[o];
                        o++;
                    }
                }

                if (d == 3) {
                    for (int p = l - 2; p >= j; p--) {
                        grid[k - 1][p] = tmp2[o];
                        o++;
                    }
                }

                if (d == 4) {
                    for (int p = k - 2; p > i; p--) {
                        grid[p][j] = tmp2[o];
                        o++;
                    }
                }

                d++;
            }

            i++;
            j++;
            k--;
            l--;
        }

        return grid;
    }
}