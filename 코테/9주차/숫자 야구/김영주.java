import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       
       int N = Integer.parseInt(br.readLine());
       int arr[][] = new int[N][3];
       
       for(int i=0;i<N;i++){
         st = new StringTokenizer(br.readLine());
         
         for(int j=0;j<3;j++){
           arr[i][j] = Integer.parseInt(st.nextToken());
         }
       }
       
       int answer=0;
       for(int i=1;i<=9;i++){
         for(int j=1;j<=9;j++){
           for(int k=1;k<=9;k++){
             if(i!=j && i!=k && j!=k){
                boolean flag = false;
                for(int p=0;p<N;p++){
                 int strike = 0;
                 int ball = 0;
                 
                 if(arr[p][0]/100 == i) strike++;
                 if((arr[p][0]/10)%10 == j) strike++;
                 if(arr[p][0]%10 == k) strike++;
                 
                 if(arr[p][0]/100 == j || arr[p][0]/100 == k) ball++;
                 if((arr[p][0]/10)%10 == i || (arr[p][0]/10)%10 == k) ball++;
                 if(arr[p][0]%10 == i || arr[p][0]%10 == j) ball++;
                 
                 if(strike != arr[p][1] || ball != arr[p][2]) flag = true;
                 
               }
              if(!flag) answer++;
             }
           }
         }
       }
       System.out.println(answer);
    }
}
