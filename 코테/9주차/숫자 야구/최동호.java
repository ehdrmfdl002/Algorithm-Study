import java.util.*;

public class Main {
    static class NumberInfo {
        int[] number;
        int strike;
        int ball;
    
        public NumberInfo(int[] number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }
    
    public static void main(String[] args) {
        List<NumberInfo> list = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            int[] arr = new int[3];
            arr[0] = num / 100;
            arr[1] = (num / 10) % 10;
            arr[2] = num % 10;
            
            NumberInfo numberInfo = new NumberInfo(arr, sc.nextInt(), sc.nextInt());
            list.add(numberInfo);
        }

        int possibleCount = getPossibleCount(list);
        System.out.println(possibleCount);
    }

    private static int getPossibleCount(List<NumberInfo> numberList) {
        List<int[]> possibleNumbers = new ArrayList<>();

        // 모든 가능한 세 자리 수를 리스트에 추가
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == i) continue;
                for (int k = 1; k <= 9; k++) {
                    if (k == i || k == j) continue;
                    int[] number = {i, j, k};
                    possibleNumbers.add(number);
                }
            }
        }

        // 가능한 답의 개수를 축소
        for (NumberInfo info : numberList) {
            possibleNumbers.removeIf(num -> !isPossibleNumber(num, info));
        }

        return possibleNumbers.size();
    }

    private static boolean isPossibleNumber(int[] number, NumberInfo info) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (number[i] == info.number[i]) {
                strike++;
            } else if (containsNumber(number, info.number[i])) {
                ball++;
            }
        }

        return strike == info.strike && ball == info.ball;
    }

    private static boolean containsNumber(int[] number, int target) {
        for (int num : number) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
