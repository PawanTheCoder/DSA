package QueueDS.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] dirs = {{1,0} , {-1, 0} , {0,1} , {0,-1}};

        boolean[][] visited = new boolean[3][3];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});

        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for(int[] d : dirs) {
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr < 0 || nc < 0 || nr >= 3 || nc >=3) continue;

                if(visited[nr][nc]) continue;

                
            }
        }
    }
}