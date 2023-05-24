import java.util.*;
import java.io.*;

public class Main{
    static class Stick{
        int L, H;

        public Stick(int L, int H){
            this.L = L;
            this.H = H;
        }
    }

    static int N, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        ArrayList<Stick> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            list.add(new Stick(L, H));
        }
        Collections.sort(list, (o1, o2) -> (o1.L - o2.L));

        // 왼쪽끝에서 시작
        Stick left = list.get(0);
        // 가장 큰 막대 인덱스
        int maxIdx = 0;
        for(int i = 1; i < list.size(); i++){
            Stick next = list.get(i);
            if(left.H <= next.H){
                answer += (next.L - left.L) * left.H;
                maxIdx = i;
                left = next;
            }
        }

        // 오른쪽끝에서 시작
        Stick right = list.get(list.size() - 1);
        for(int i = list.size() - 2; i > maxIdx - 1; i--){
            Stick next = list.get(i);
            if(right.H <= next.H){
                answer += (right.L - next.L) * right.H;
                right = next;
            }
        }
        // 가장 큰 막대 높이 더하기
        answer += list.get(maxIdx).H;
        System.out.println(answer);
    }

}