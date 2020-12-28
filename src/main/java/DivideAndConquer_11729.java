import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideAndConquer_11729 {

    static StringBuilder sb = new StringBuilder();

    public static void move(int n, int start, int arrival) {
        sb.append(start).append(" ").append(arrival).append("\n");
    }

    public static void hanoi(int n, int start, int arrival, int via) {
        if (n == 1) {
            move(1, start, arrival);
        } else {
            hanoi(n - 1, start, via, arrival);
            move(n, start, arrival);
            hanoi(n - 1, via, arrival, start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2, n) - 1)).append('\n');
        hanoi(n, 1, 3, 2);
        System.out.println(sb);
    }
}
