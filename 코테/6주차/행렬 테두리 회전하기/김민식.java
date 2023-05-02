class Solution {
    static int[][] map;
    static int[] answer;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        Arrays.fill(answer, 100001);
        map = new int[rows][columns];
        init(rows, columns);
        for(int i = 0; i < queries.length; i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            // 각 끝점 세개만 담으면 됨
            int right = map[x1][y2];
            int down = map[x2][y2];
            int left = map[x2][y1];
            
            moveRight(x1, y1, y2, i);
            moveDown(x1, x2, y2, i);
            moveLeft(y1, x2, y2, i);
            moveUp(x1, y1, x2, i);
            
            // 끝점 하나씩 이동한곳 넣어주기
            map[x1 + 1][y2] = right;
            map[x2][y2 - 1] = down;
            map[x2 - 1][y1] = left; 
        }
        return answer;
    }
    
    static void init(int x, int y){
        int cnt = 1;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                map[i][j] = cnt++;
            }
        }
    }
    
    static void moveRight(int x1, int y1, int y2, int idx){
        for(int i = y2; i > y1; i--){
            answer[idx] = Math.min(answer[idx], map[x1][i]);
            map[x1][i] = map[x1][i - 1];
        }
    }
    
    static void moveDown(int x1, int x2, int y2, int idx){
        for(int i = x2; i > x1; i--){
            answer[idx] = Math.min(answer[idx], map[i][y2]);
            map[i][y2] = map[i - 1][y2];
        }
    }
    
    static void moveLeft(int y1, int x2, int y2, int idx){
        for(int i = y1; i < y2; i++){
            answer[idx] = Math.min(answer[idx], map[x2][i]);
            map[x2][i] = map[x2][i + 1];
        }
    }
    
    static void moveUp(int x1, int y1, int x2, int idx){
        for(int i = x1; i < x2; i++){
            answer[idx] = Math.min(answer[idx], map[i][y1]);
            map[i][y1] = map[i + 1][y1];
        }
    }
}