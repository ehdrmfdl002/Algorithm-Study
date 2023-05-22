import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        for(int i=0;i<N;i++){
          st = new StringTokenizer(br.readLine());
          
          int L = Integer.parseInt(st.nextToken());
          int H = Integer.parseInt(st.nextToken());
          
          start = Math.min(start,L);
          end = Math.max(end,L);
          
          arr[L] = H;
        }
        
        Stack<Integer> stk = new Stack<>();
        
        int height = arr[start];
        for(int i=start+1;i<=end;i++){
          if(arr[i]<height){
            stk.push(i);
          }else{
            while(!stk.isEmpty()){
              int x = stk.pop();
              arr[x] = height;
            }
            height = arr[i];
          }
        }
        stk.clear();
        
        height = arr[end];
        for(int i=end-1;i>=start;i--){
          if(arr[i]<height){
            stk.push(i);
          }else{
            while(!stk.isEmpty()){
              int x = stk.pop();
              arr[x] = height;
            }
            height = arr[i];
          }
        }
        
        int answer=0;
        for(int i=start;i<=end;i++){
          answer+=arr[i];
        }
        
        System.out.println(answer);
    }
}
