import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]); // 간선을 가중치 오름차순으로 정렬
        int[] parent = new int[n]; // Union-Find 알고리즘에 사용할 배열
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int answer = 0;
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            int root1 = find(parent, from);
            int root2 = find(parent, to);
            if (root1 != root2) { // 사이클을 형성하지 않는 경우에만 연결
                parent[root2] = root1;
                answer += cost;
            }
        }
        return answer;
    }

    private int find(int[] parent, int x) { // Union-Find 알고리즘
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
}
