import java.util.*;

class Solution {
    static boolean check;
    static boolean[][] visited;
    static char[][] map;
    static int[] answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int[] solution(String[][] places) {
        answer = new int[5];
        Arrays.fill(answer, 1);
        for(int i = 0; i < 5; i++){
            map = new char[5][5];
            visited = new boolean[5][5];
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    map[j][k] = places[i][j].charAt(k); 
                }
            }
            
            check = false;
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    // 응시자 일때만 dfs
                    if(map[j][k] == 'P'){
                        visited[j][k] = true;
                        dfs(j, k, 0, 0);
                    }
                        
                    if(check){
                        answer[i] = 0;
                        break;
                    }
                }
            }
            
        }
        return answer;
    }
    
    // 총 2번 가는데 파티션이 없을때 없다고 partition에 넣어준다
    static void dfs(int x, int y, int cnt, int partition){
        // 실패하면 리턴
        if(check == true) return;
        // 2번 갔을때 응시자이고 파티션이 없었다면 실패 체크
        if(cnt == 2){
            if(map[x][y] == 'P' && partition >= 1){
                check = true;
                return;
            }
            return;
        }
        // 맨해튼 거리 2 안되면 실패 체크
        if(cnt == 1 && map[x][y] == 'P'){
            check = true;
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny]) continue;
            // 응시자까지 여러 방법으로 갈수있으므로 응시자 자리 빼고 방문처리
            if(map[nx][ny] != 'P') visited[nx][ny] = true;
            if(map[nx][ny] == 'O') dfs(nx, ny, cnt + 1, partition + 1);
            else dfs(nx, ny, cnt + 1, partition);
        }
    }
}