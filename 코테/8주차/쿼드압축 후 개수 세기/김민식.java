class Solution {
    static int[] answer;
    static int[][] map;
    public static int[] solution(int[][] arr) {
        map = arr;
        answer = new int[2];
        int n = arr.length;
        dfs(0, 0, n);
        return answer;
    }
    
    static void dfs(int x, int y, int n) {
        int temp = map[x][y];
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(temp != map[i][j]){
                    int t = n / 2;
                    dfs(x, y, t);
                    dfs(x, y + t, t);
                    dfs(x + t, y, t);
                    dfs(x + t, y + t, t);
                    return;
                }
            }
        }
        answer[temp]++;
    }
}
