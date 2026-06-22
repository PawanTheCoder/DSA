package QueueDS.BFS;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int ans = orangesRotting(grid);

        System.out.println(ans);
    }
    public static int orangesRotting(int[][] grid) {
        int count =0;

        int[][] dirs = {{1,0} , {-1, 0} , {0,1} , {0,-1} };
        int m = grid.length;
        int n = grid[0].length;
        System.out.println(m + " " + n);
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int oranges = 0;
        // Add all the source nodes to the queue

        for(int i =0; i < m ; i++) {
            for(int j =0; j < n ; j++) {
                if(grid[i][j] == 1) oranges ++;
                if(grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.offer(new int[] {i ,j});
                }
            }
        }
        int meet =0;

        while(!q.isEmpty()) {
            if(meet == oranges) return count;
            count ++;
            
            int size = q.size();

            for(int i=0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for(int[] d : dirs) {
                    int nr = row + d[0];
                    int nc = col + d[1];
                    if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

                    if(visited[nr][nc]) continue;
                    if(grid[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        meet++;
                        grid[nr][nc] = 2;
                        q.offer(new int[] {nr , nc});
                    }
                }
            }
        }
        System.out.println(oranges);
        return -1;
    }
}
