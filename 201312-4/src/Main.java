import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long mod = 1000000007;
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        long [][] status = new long[number + 1][6];
        for (int i = 0; i < 6; i ++)
            status[0][i] = 0;


        for (int i = 1; i < number + 1; i ++){
            status[i][0] = 1;
            status[i][1] = (status[i - 1][1] * 2 + status[i - 1][0]) % mod;
            status[i][2] = (status[i - 1][2] + status[i - 1][0]) % mod;
            status[i][3] = (status[i - 1][3] * 2 + status[i - 1][1]) % mod;
            status[i][4] = (status[i - 1][4] * 2 + status[i - 1][2] + status[i - 1][1]) % mod;
            status[i][5] = (status[i - 1][5] * 2 + status[i - 1][4] + status[i - 1][3]) % mod;
        }
        System.out.println(status[number][5]);

    }


}
