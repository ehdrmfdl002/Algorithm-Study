class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[][] sol = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < 3; j++) {
                if(answers[i] == sol[j][i % sol[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = 0;
        int count = 0;

        for(int i = 0; i < 3; i++) {
            maxScore = Math.max(maxScore, scores[i]);
        }

        for(int i = 0; i < 3; i++) {
            if(scores[i] == maxScore) {
                count++;
            }
        }

        answer = new int[count];

        for(int i = 0, j = 0; i < 3; i++) {
            if(scores[i] == maxScore) {
                answer[j] = i + 1;
                j++;
            }
        }

        return answer;
    }
}