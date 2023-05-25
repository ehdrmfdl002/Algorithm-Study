import java.util.*;

class Solution {
    static char[][] map = {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}, {'*', '0', '#'}};
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int leftX = 3;
    static int leftY = 0;
    static int rightX = 3;
    static int rightY = 2;
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        outer:for(int num : numbers){
            // 왼쪽은 왼손만
            if(num % 3 == 1 && num != 0){
                sb.append("L");
                change(true, (char)(num + '0'));
                continue outer;
            // 오른쪽은 오른손만
            }else if(num % 3 == 0 && num != 0){
                sb.append("R");
                change(false, (char)(num + '0'));
                continue outer;
            }
            // 각각 거리 측정
            int left = dist(leftX, leftY, (char)(num + '0'));
            int right = dist(rightX, rightY, (char)(num + '0'));
            boolean isLeft = true;
            if(left == right){
                if(hand.equals("left")) sb.append("L");
                else{
                    sb.append("R");
                    isLeft = false;
                }
            }
            else if(left > right) {
                sb.append("R");
                isLeft = false;
            }
            else sb.append("L");
            change(isLeft, (char)(num + '0'));
        }
        return sb.toString();
    }

    static void change(boolean isLeft, char num){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(map[i][j] != num) continue;
                if(isLeft){
                    leftX = i;
                    leftY = j;
                }else{
                    rightX = i;
                    rightY = j;
                }
                return;
            }
        }
    }

    static int dist(int x, int y, char num){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[4][3];
        q.add(new int[] {x, y});
        int cnt = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] temp = q.poll();
                if(map[temp[0]][temp[1]] == num) return cnt;
                visited[temp[0]][temp[1]] = true;
                for(int i = 0; i < 4; i++){
                    int nx = temp[0] + dx[i];
                    int ny = temp[1] + dy[i];
                    if(isIn(nx, ny) || visited[nx][ny]) continue;
                    q.add(new int[] {nx, ny});
                }
            }
            cnt++;
        }
        return cnt;
    }

    static boolean isIn(int x, int y){
        if(x < 0 || y < 0 || x >= 4 || y >= 3) return true;
        return false;
    }
}