package QueueDS.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1765 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{0,0,0},{0,0,0}};

        int[][] maxPeek = highestPeak(grid);

       System.out.println(Arrays.deepToString(maxPeek));
    }
    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] heights = new int[m][n];

        int[][] dirs = {{1,0} , {-1, 0} , {0,1} , {0,-1}};

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i < m ; i++) {
            for(int j =0; j < n; j++) {
                if(isWater[i][j] == 1) {
                    heights[i][j] = 0;
                    visited[i][j] = true;
                    q.offer(new int[] {i , j});
                }
                else {
                    heights[i][j] = -1;
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

                if(nr < 0 || nc < 0 ||nr >= m || nc >= n ) continue;
                if(visited[nr][nc]) continue;
                heights[nr][nc] = heights[row][col] + 1;
                visited[nr][nc] = true;
                if(heights[nr][nc] >= 1) q.offer(new int[] {nr , nc});
            }
        }
        return heights;
    }
}
