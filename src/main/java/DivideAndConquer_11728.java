import java.util.*;

public class DivideAndConquer_11728 {

    static int[] a;
    static int[] b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        a = new int[n];
        b = new int[m];
        int []result = new int[n+m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        Arrays.sort(b);

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n && j < m){
            if(a[i] > b[j]){
                result[k++] = b[j++];
            }else{
                result[k++] = a[i++];
            }
        }
        while(j < m){
            result[k++] = b[j++];
        }
        while(i < n){
            result[k++] = a[i++];
        }

        StringBuilder sb = new StringBuilder();
        for (int value : result) {
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString());
        scanner.close();
    }
}
