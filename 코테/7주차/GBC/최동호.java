import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] sections = new int[N][2];

        for (int i = 0; i < N; i++) {
            sections[i][0] = scanner.nextInt();
            sections[i][1] = scanner.nextInt();
        }

        int maxExceedSpeed = 0;

        for (int i = 0; i < M; i++) {
            int testLength = scanner.nextInt();
            int testSpeed = scanner.nextInt();

            for (int j = 0; j < N; j++) {
                if (testLength > 0 && testLength <= sections[j][0]) {
                    int exceedSpeed = testSpeed - sections[j][1];
                    if (exceedSpeed > maxExceedSpeed) {
                        maxExceedSpeed = exceedSpeed;
                    }
                }
                testLength -= sections[j][0];
            }
        }

        System.out.println(maxExceedSpeed);
    }
}