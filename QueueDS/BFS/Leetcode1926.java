package QueueDS.BFS;

import java.util.Queue;

import java.util.LinkedList;

public class Leetcode1926 {
    public static void main(String[] args) {
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,2};

        int no = nearestExit(maze, entrance);

        System.out.println(no);
    }   
    public static int nearestExit(char[][] maze, int[] entrance) {
        int count =0;
        int[][] dirs = {{1,0} , {-1,0} , {0,1} , {0,-1}};

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Queue<int[]> q = new LinkedList();

        visited[entrance[0]][entrance[1]] = true;
         
        // Store the first next path points
        for(int[] d : dirs) {
            int row = entrance[0] + d[0];
            int col = entrance[1] + d[1];

            if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) continue;

            if(maze[row][col] == '.') q.offer(new int[] {row ,col});
        }

        
        while(!q.isEmpty()) {
            count ++;
            int size = q.size();

            for(int i=0; i< size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for(int[] d: dirs) {
                    int nr = row + d[0];
                    int nc = col + d[1];

                    if(nc < 0 || nr < 0 || nr >= maze.length || nc >= maze[0].length) {
                        return count;
                    }

                    if(visited[nr][nc]) continue;

                    if(maze[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr , nc});
                    }

                }
            }
        }

        return -1;
    }
}
