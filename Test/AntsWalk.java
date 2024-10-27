package Test;

public class AntsWalk {
    public static int calculate(int n, int left, int right) {
        if (left > right) {
            return Math.min(left - right, left - right + 1);
        } else {
            return Math.min(left, n - right);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int left = 3;
        int right = 1;

        System.out.println(calculate(n, left, right));
    }
}
