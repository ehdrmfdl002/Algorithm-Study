import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] snail = new int[n][n];
        
        int x = -1;
        int y = 0;
        int num = 1;
        // 이동은 총 세번씩 반복
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                // 위에서 아래 왼쪽 대각선
                if(i % 3 == 0) x++;
                // 왼쪽에서 오른쪽
                else if(i % 3 == 1) y++;
                // 아래에서 위 오른쪽 대각선
                else{
                    x--;
                    y--;
                }
                snail[x][y] = num++;
            }
        }
        
        outer:for(int i = 0; i < n; i++){
            for(int j = 0;  j < n; j++){
                if(snail[i][j] == 0) continue outer;
                answer.add(snail[i][j]);
            }
                
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}