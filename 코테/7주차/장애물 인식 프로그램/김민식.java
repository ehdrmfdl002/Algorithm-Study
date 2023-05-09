import java.util.*;
import java.io.*;


public class Main
{
    static int n;
    static int[][] map;
    static int[] answer;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static final int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        answer = new int[n * n];
        Arrays.fill(answer, INF);

        for(int i = 0; i < n; i++){
            String[] split = br.readLine().split("");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        int idx = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1){
                    dfs(i, j, idx);
                    answer[idx] = 1;
                    visited[i][j] = true;
                    countCnt(i, j, idx++);
                }

            }
        }

        Arrays.sort(answer);
        System.out.println(idx - 2);
        for(int i = 0; i < answer.length; i++){
            if(answer[i] == INF) break;
            System.out.println(answer[i]);
        }

    }

    static void dfs(int x, int y, int idx){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isIn(nx, ny) || map[nx][ny] != 1) continue;
            map[nx][ny] = idx;
            dfs(nx, ny, idx);
        }
    }

    static boolean isIn(int x, int y){
        if(x < 0 || y < 0 || x >= n || y >= n) return true;
        return false;
    }

    static void countCnt(int x, int y, int idx){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isIn(nx, ny) || visited[nx][ny] || map[nx][ny] != idx) continue;
            visited[nx][ny] = true;
            answer[idx]++;
            countCnt(nx, ny, idx);
        }
    }
}