import java.util.Scanner;

public class DivideAndConquer_2447 {
    static char[][] star;
    static int n;

    public static void divideAndConquer(int row, int col, int size, boolean blank){
        if(blank){
            for(int i=row; i < row+size; i++){
                for(int j = col; j < col+size; j++){
                    star[i][j] = ' ';
                }
            }
            return;
        }

        if(size==1){
            star[row][col] = '*';
            return;
        }

        int newSize = size / 3;
        int count=0;
        for(int i=row; i < row+size; i += newSize){
            for(int j = col; j < col+size; j += newSize){
                count++;
                divideAndConquer(i,j,newSize, count == 5);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        star = new char[n][n];
        divideAndConquer(0,0,n,false);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                sb.append(star[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
