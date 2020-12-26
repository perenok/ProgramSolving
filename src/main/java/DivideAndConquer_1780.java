import java.util.Scanner;

public class DivideAndConquer_1780 {
    static int[][] paper;
    static int[] cnt = new int[3];

    public static boolean isSameNum(int row, int col, int size) {
        int tmp = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (tmp != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void divideAndConquer(int row, int col, int size) {
        if (isSameNum(row, col, size)) {
            cnt[paper[row][col]+1]++;
        } else {
            size /= 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divideAndConquer(row + size * i, col + size * j, size);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = scanner.nextInt();
            }
        }
        divideAndConquer(0, 0, n);
        System.out.println(cnt[0] + "\n" + cnt[1] + "\n" + cnt[2]);
        scanner.close();
    }
}
