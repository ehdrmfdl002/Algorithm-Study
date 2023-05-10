import java.util.*;
import java.io.*;


public class Main
{   
    static int N,count;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] arr;
    static ArrayList<Integer> list;
    public static void main(String args[]) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        int cnt=0;
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    count=0;
                    dfs(i,j);
                    list.add(count);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    static void dfs(int x, int y){

        visited[x][y] = true;
        count++;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if(visited[nx][ny] || arr[nx][ny] == 0) continue;

            dfs(nx,ny);
        }
    }
}
