/*
 * Feature 1 - Suggest Friends - PROBLEM - Number of Islands
 */
package Facebook;

public class NumberOfIslands {
    public static void DFS(boolean[][] friends, int n, boolean[] visited, int v) {
        for (int i = 0; i < n; i++) {
            if (friends[v][i] == true && !visited[i] && i != v) {
                visited[i] = true;
                DFS(friends, n, visited, i);
            }
        }
    }

    public static int friendCircles(boolean[][] friends, int n) {
        if (n == 0) {
            return 0;
        }

        int numCircles = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(friends, n, visited, i);
                numCircles = numCircles + 1;
            }
        }

        return numCircles;
    }
}
