package QueueDS.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Template {
    public static void main(String[] args) {
        Queue<int[]> q = new LinkedList<>();

        int[][] arr = { {1,2,3},
                        {4,5,6},
                        {7,8,9}};

        boolean[][] visited = new boolean[arr.length][arr[0].length];

        int[][] dirs = {{1,0} /*down*/ , {-1, 0} /*Up*/ , {0, 1}/*Right*/ , {0,-1}/*Left*/};
        int startRow = 0;
        int startCol = 0;
        q.offer(new int[]{startRow,startCol});
        visited[startRow][startCol] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for(int[] d : dirs) {
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr < 0 || nc < 0 || nr >=3|| nc >= 3) continue; 

                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;
                System.out.println(arr[nr][nc] + " ");
                q.offer(new int[] {nr,nc});
            }
            System.out.println("Skipped");
        }
    }
}
