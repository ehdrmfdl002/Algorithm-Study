import java.util.*;
import java.io.*;


public class Main
{
    static int N,M;
    static int[][] limit,test;
    static ArrayList<Integer> list;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        limit = new int[N][2];
        test = new int[M][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            limit[i][0] = Integer.parseInt(st.nextToken());
            limit[i][1] = Integer.parseInt(st.nextToken());

            if(i>0){
                limit[i][0]+=limit[i-1][0];
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            test[i][0] = Integer.parseInt(st.nextToken());
            test[i][1] = Integer.parseInt(st.nextToken());

            if(i>0){
                test[i][0]+=test[i-1][0];
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(limit[j][0] == test[i][0]){
                    list.add(test[i][1]-limit[j][1]);
                    limit[j][1] = 101;
                    }
                else if(limit[j][0]<test[i][0]){
                    list.add(test[i][1]-limit[j][1]);
                    limit[j][1] = 101;
                    if(j!=N-1) list.add(test[i][1]-limit[j+1][1]);
                }
            }
        }

        Collections.sort(list,Collections.reverseOrder());

        if(list.get(0)<0) System.out.println(0);
        else System.out.println(list.get(0));

    }
}
