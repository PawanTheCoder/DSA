package QueueDS.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode934 {
    public static void main(String[] args) {
        int[][] grid = { {0,1,0},{0,0,0},{0,0,1} };

        System.out.println(shortestBridge(grid));
    }

    public static int shortestBridge(int[][] grid) {
        // First we have to find the edges of one of the island
        // We have to find the co-ordinates of 1
        int m = grid.length;
        int n = grid[0].length;
        int r = -1;
        int c = -1;
        boolean signal = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                    signal = true;
                    break;
                }
            }
            if (signal)
                break;
        }
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> edges = returnEdges(grid, r, c , visited);

        int[][] dirs = {{1,0}, { 0,1} , {0,-1} , {-1,0}};

        for (int[] edge : edges) {
           visited[edge[0]][edge[1]] = true;
        }
        int count = -1;
        while (!edges.isEmpty()) {
            count++;
            int size = edges.size();

            for(int i =0 ; i < size; i++) {
                int[] curr = edges.poll();

                int row = curr[0];
                int col = curr[1];

                for(int[] d: dirs) {
                    int nr = row + d[0];
                    int nc = col + d[1];

                    if(nr < 0 || nc< 0 || nr >= m || nc >= n) continue;

                    if(visited[nr][nc]) continue;

                    if(grid[nr][nc] == 1) {
                        return count;
                    }
                    else if(grid[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        edges.offer(new int[] {nr , nc});
                    }
                }
            }
        }
        return count;
    }

    public static Queue<int[]> returnEdges(int[][] grid, int x, int y , boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> edges = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };


        q.offer(new int[] { x, y });
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];
            boolean signal = true;

            for (int[] d : dirs) {
                int nr = row + d[0];
                int nc = col + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                if (visited[nr][nc])
                    continue;

                if (grid[nr][nc] == 0 && signal) {
                    edges.offer(new int[] { row, col });
                    signal = false;

                } else if (grid[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                }
            }
        }
        return edges;
    }
}
