import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] clothes = new int[n];
        
        // 모든 학생에게 체육복을 하나씩 준다.
        for (int i = 0; i < n; i++) {
            clothes[i] = 1;
        }
        
        // 여벌 체육복이 있는 학생이 도난당한 경우, 체육복을 하나씩 가져온 것으로 간주한다.
        for (int i = 0; i < reserve.length; i++) {
            clothes[reserve[i]-1]++;
        }
        for (int i = 0; i < lost.length; i++) {
            clothes[lost[i]-1]--;
        }
        
        // 도난당한 학생의 앞번호 학생이 체육복을 빌려주거나, 뒷번호 학생이 체육복을 빌려줄 수 있으면 빌려준다.
        for (int i = 0; i < n; i++) {
            if (clothes[i] == 0) {
                if (i > 0 && clothes[i-1] == 2) {
                    clothes[i]++;
                    clothes[i-1]--;
                } else if (i < n-1 && clothes[i+1] == 2) {
                    clothes[i]++;
                    clothes[i+1]--;
                } else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}

