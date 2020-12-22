import java.util.Scanner;

import static java.lang.Math.min;

public class ExhaustiveSearch_1107 {
    private static boolean[] brokenButton = new boolean[10];

    public static int getPossibleChannel(int channel){
        if(channel==0){
            if(brokenButton[0]){
                return 0;
            }
            else{
                return 1;
            }
        }
        int len=0;
        while(channel > 0){
            if(brokenButton[channel%10]){
                return 0;
            }
            len += 1;
            channel /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i=0; i < m; i++){
            int tmp = scanner.nextInt();
            brokenButton[tmp] = true;
        }

        int answer=Math.abs(n-100);

        for(int i=0; i <= 1000000;i++){
            int len = getPossibleChannel(i);
            if(len > 0){
                int press = Math.abs(i-n);
                answer = min(answer, len+press);
            }
        }
        System.out.println(answer);
        scanner.close();
    }
}
