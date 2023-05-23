import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Point[] arr = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new Point(x, y);
        }

        Arrays.sort(arr);

        ArrayList<Point> left = new ArrayList<>();
        ArrayList<Point> right = new ArrayList<>();

        int max = -1;
        for (int i = 0; i < N; i++) {
            if (max <= arr[i].y) {
                max = arr[i].y;
                left.add(arr[i]);
            }
        }

        int sum = 0;
        Point tmp = left.get(0);
        for (int i = 1; i < left.size(); i++) {
            Point cur = left.get(i);
            sum += Math.abs(cur.x - tmp.x) * tmp.y;
            tmp = cur;
        }

        if (!left.contains(arr[N - 1])) {
            max = -1;
            for (int i = N - 1; i >= 0; i--) {
                if (max <= arr[i].y) {
                    max = arr[i].y;
                    if (!left.contains(arr[i])) {
                        right.add(arr[i]);
                    }
                }
            }

            tmp = right.get(0);
            sum += Math.abs(left.get(left.size() - 1).x - right.get(right.size() - 1).x) * right.get(right.size() - 1).y;
            for (int i = 1; i < right.size(); i++) {
                Point cur = right.get(i);
                sum += Math.abs(cur.x - tmp.x) * tmp.y;
                tmp = cur;
            }
        }

        sum += left.get(left.size() - 1).y;

        System.out.println(sum);
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point w) {
            return this.x - w.x;
        }
    }
}
