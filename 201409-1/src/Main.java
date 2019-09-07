import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int []num = new int[n];
        for (int i = 0; i <n ; i++) {
            num[i] = Integer.valueOf(in.next());
        }
        int result = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(num[i]-num[j]==1)
                    result++;
            }
        }
        System.out.println(result);
    }
}
