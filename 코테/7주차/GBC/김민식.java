import java.util.*;
import java.io.*;


public class Main
{
	static int N, answer;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + M][2];

        for(int i = 0; i < N + M; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        // 이동 구간
        int next = N;
        int section = map[next][0];
        int speed = map[next][1];
        // 제한 구간
        int idx = 0;
        int limitSection = map[idx][0];
        int limitSpeed = map[idx][1];
        answer = 0;
        while(true){
            int minus = limitSection - section;
            // 제한구간보다 더 이동했을때
            if(minus < 0){
                section = minus * -1;
                calc(limitSpeed, speed);
                // 제한구역 다음으로 이동
                if(isIn(idx)) break;
                limitSection = map[++idx][0];
                limitSpeed = map[idx][1];
            // 제한구간보다 적게 이동했을때
            }else if(minus > 0){
                limitSection = minus;
                calc(limitSpeed, speed);
                // 이동구간 다음으로 이동
                if(isIn(next)) break;
                section = map[++next][0];
                speed = map[next][1];
            // 제한구역, 이동구역 거리가 같으면 하나씩 다음으로 이동
            }else{
            	calc(limitSpeed, speed);
            	if(isIn(idx)) break;
                limitSection = map[++idx][0];
                limitSpeed = map[idx][1];
                
                if(isIn(next)) break;
                section = map[++next][0];
                speed = map[next][1];
            }
        }
        System.out.println(answer);
    }
    
    static void calc(int limitSpeed, int speed) {
    	if(limitSpeed - speed < 0) answer = Math.max(answer, speed - limitSpeed);
    }

    static boolean isIn(int num){
        if(num + 1 == N) return true;
        else return false;
    }
}