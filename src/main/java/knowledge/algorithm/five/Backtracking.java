package knowledge.algorithm.five;

import java.util.stream.IntStream;

/**
 * Backtracking
 * 回溯法
 *
 * @author ljh
 * created on 2020/9/29 10:32
 */
public class Backtracking {
    private static int N = 6;
    private static int R = 3;
    public static int[] a = new int[N];
    private static int[] b = new int[R];

    public static void main(String[] args) {
        IntStream.rangeClosed(1, N).forEach(i -> a[i] = i + 1);

        CombinationOfNumber(N, R);
    }

    /**
     * 数字组合
     * 从n个数中选取r个数的所有组合
     * https://www.cnblogs.com/yoona-lin/p/10510518.html
     * https://www.cnblogs.com/xiaonongpiaoliang/p/5289243.html
     */
    private static void CombinationOfNumber(int n, int r) {
        for (int i = n; i >= r; i--) {
            b[r - 1] = a[i - 1];
            if (r > 1) {
                CombinationOfNumber(i - 1, r - 1);
            } else {
                for (int j = R - 1; j >= 0; j--)
                    System.out.print(b[j] + " ");
                System.out.println();
            }
        }
    }
}
