import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
      Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); 
        scanner.nextLine(); 

        int[][] map = new int[N][N]; 
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        scanner.close();

        int[][] visited = new int[N][N]; 
        int blockCount = 0; 
        List<Integer> obstacleCounts = new ArrayList<>(); 

        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    int count = dfs(map, visited, i, j, blockCount + 2);
                    blockCount++;
                    obstacleCounts.add(count);
                }
            }
        }

        Collections.sort(obstacleCounts); 

        System.out.println(blockCount);
        for (int count : obstacleCounts) {
            System.out.println(count);
        }
    }

    // DFS를 통해 연결된 장애물 블록을 탐색하고 장애물 수를 반환하는 메소드
    private static int dfs(int[][] map, int[][] visited, int row, int col, int blockNumber) {
        int N = map.length;
        if (row < 0 || row >= N || col < 0 || col >= N) {
            return 0;
        }
        if (visited[row][col] != 0 || map[row][col] != 1) {
            return 0;
        }

        visited[row][col] = blockNumber;
        int count = 1;

        count += dfs(map, visited, row - 1, col, blockNumber);
        count += dfs(map, visited, row + 1, col, blockNumber);
        count += dfs(map, visited, row, col - 1, blockNumber);
        count += dfs(map, visited, row, col + 1, blockNumber);

        return count;
    }
}