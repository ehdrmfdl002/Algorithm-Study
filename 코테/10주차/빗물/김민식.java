import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        boolean[] visited = new boolean[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) arr[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        int left = 0;
        // 왼쪽부터 큰 블럭 나올때 까지 찾고 더해주기
        for(int i = 1; i < W; i++){
            if(arr[left] <= arr[i]){
                visited[left] = true;
                visited[i] = true;
                for(int j = left + 1; j < i; j++){
                    if(visited[j]) continue;
                    answer += arr[left] - arr[j];
                    visited[j] = true;
                }
                left = i;
            }
        }
        // 오른쪽부터 큰 블럭 나올때 까지 찾고 더해주기
        int right = W - 1;
        for(int i = W - 2; i > -1; i--){
            if(arr[right] <= arr[i]){
                visited[right] = true;
                visited[i] = true;
                for(int j = right - 1; j > i; j--){
                    if(visited[j]) continue;
                    answer += arr[right] - arr[j];
                    visited[j] = true;
                }
                right = i;
            }
        }

        System.out.println(answer);
    }
}