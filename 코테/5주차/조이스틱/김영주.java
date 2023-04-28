class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        int index; // 다음 값들을 확인할 인덱스
        int move = length-1; // 좌, 우 움직임 수를 체크
        
        for(int i=0;i<name.length();i++){
            answer+=Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A')); // 상,하 알파벳 맞추기
            int endA = i+1;
            while(endA<name.length() && name.charAt(endA) == 'A') endA++;
            move = Math.min(move,i*2+(name.length()-endA)); // 오른쪽
            move = Math.min(move, i+(name.length()-endA)*2); // 왼쪽
        }
        return answer+move;
    }
}
