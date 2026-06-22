package QueueDS.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode695 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int maxArea = maxAreaOfIsland(grid);

        System.out.println(maxArea);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea =0;

        int[][] dirs = {{1,0} , {0,1} , {0,-1} , {-1, 0}};

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i =0; i < grid.length; i++) {
            for(int j =0; j < grid[0].length; j++) {
                int currentArea =0;
                if(grid[i][j] == 1) {
                    if(visited[i][j]) continue;
                    currentArea = 1;
                    Queue<int[]> q = new LinkedList<>();
                    visited[i][j] = true;
                    q.offer(new int[] {i , j});

                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        int row = curr[0];
                        int col = curr[1];

                        for(int[] d : dirs) {
                            int nr = row + d[0];
                            int nc = col + d[1];

                            if(nr < 0 || nc < 0 ||nr >= grid.length || nc >=grid[0].length) continue;

                            if(visited[nr][nc]) continue;

                            
                            visited[nr][nc] = true;
                            if(grid[nr][nc] == 1) {
                                currentArea ++;
                                q.offer(new int[] {nr , nc});
                            }
                           
                        }
                    } 
                }
                maxArea = Math.max(currentArea , maxArea);
            }
        }
        return maxArea;
    }
}
