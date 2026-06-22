package QueueDS.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode542 {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};

        int[][] distances = updateMatrix(mat);

        

        System.out.println(Arrays.deepToString(distances));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] distances = new int[m][n];
        Queue<int []> q = new LinkedList<>(); 
        int[][] dirs = {{1,0} , {-1,0} , {0,-1} , {0,1}};

        boolean[][] visited = new boolean[m][n];
        for(int i=0; i < m; i++) {
            for(int j =0;j < n ; j++) {
                if(mat[i][j] == 0) {
                    distances[i][j] =0;
                    visited[i][j] = true;
                    q.offer(new int[] {i,j});
                }
                else distances[i][j] = Integer.MAX_VALUE;
            }
        }
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for(int[] d : dirs) {
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr <0 || nc < 0 || nr >= m || nc >=n) continue;

                if(visited[nr][nc]) continue;

                if(distances[nr][nc] > distances[row][col] + 1) {
                    distances[nr][nc] = distances[row][col] + 1;
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr , nc});
                }
            }
        }
        return distances;
    }
}
