package QueueDS.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode200 {
    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        int numberOfIslands = numIslands(grid);

        System.out.println(numberOfIslands);
    }

    public static int numIslands(char[][] grid) {
        int count =0;
        int[][] dirs = {{1,0} , {0,-1} , {0,1} , {-1, 0}};
        // Scan entire island
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i =0; i < grid.length ; i++) {
            for(int j =0; j < grid[0].length ; j++) {
                if(grid[i][j] == '0') {
                    visited[i][j] = true;
                }

                if(grid[i][j] == '1') {
                    if(visited[i][j]) continue;
                    count ++;
                    Queue<int[] > q = new LinkedList<>();
                    q.offer(new int[] {i , j});
                    visited[i][j] = true;
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();

                        int row = curr[0];
                        int col = curr[1];

                        for(int[] d : dirs) {
                            int nr = row + d[0];
                            int nc = col + d[1];

                            if(nc < 0 || nr < 0 || nr >= grid.length || nc >= grid[0].length) continue;
                            if(visited[nr][nc]) continue;

                            visited[nr][nc] = true;
                            if(grid[nr][nc] == '1') q.offer(new int[] {nr,nc});
                        }
                    }
                }
            }
        }
        return count;
    }
}
