package QueueDS.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1162 {
    public static void main(String[] args) {
        int[][] gird = {{1,0,0},{0,0,0},{0,1,0}};

        System.out.println(maxDistance(gird));
    }

    public static int maxDistance(int[][] grid) {
        int maxDistance = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] distances = new int[m][n];
        int[][] dirs = {{1,0} , {0,1} , {-1,0} , {0,-1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        // Store all the 1s to the Queue
        for(int i =0; i < m ; i++) {
            for(int j =0; j < n ; j++) {
                if(grid[i][j] == 1) {
                    distances[i][j] =0;
                    visited[i][j] = true;
                    q.offer(new int[] {i , j});
                }
            }
        }

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];
            for(int[] d: dirs) {
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr < 0 || nc <0 || nr >= m || nc >= n) continue;
                if(visited[nr][nc]) continue;

                distances[nr][nc] = distances[row][col] + 1;
                maxDistance = Math.max(maxDistance , distances[nr][nc]);
                visited[nr][nc] = true;
                if(grid[nr][nc] == 0) {
                    q.offer(new int[] { nr , nc});
                }
            }
        }
        return maxDistance;
    }
}
