package QueueDS.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindCoordinates {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3} , {4,5,6} , {7,8,9}};

        int[][] dirs = {{0,1}  , {-1,0} , {1,0} ,  {0,-1}};

        boolean[][] visited = new boolean[arr.length][arr[0].length];

        Queue<int[]> q = new LinkedList<>();

        int target = 3;
        int startRow = 2;
        int startCol = 2;
        q.offer(new int[] {startRow , startCol});
        LinkedList<Integer> list = new LinkedList<>();
        list.add(arr[startRow][startCol]);
        visited[startRow][startCol] = true;

        boolean[][] com = visited;
        Arrays.fill(visited , true);

        while(visited != com) {
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];
            for(int[] d : dirs) {
                int nr = row + d[0];
                int nc = col + d[1];

                list.add(arr[nr][nc]);
                while(nr < 0 || nc < 0 || nr >= arr.length || nc >= arr[0].length) {
                    if(list.peek() != arr[nr][nc]) list.add(arr[nr][nc]);
                    nr = row + d[0];
                    nc = row + d[1];
                }
                
            }
        }
    }
}