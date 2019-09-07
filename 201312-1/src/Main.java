import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int[] numlist = new int[total];
        for (int i = 0; i <total ; i++) {
            numlist[i] = Integer.valueOf(in.next());

        }
        int times = 0,temptimes,result = 0;
        for (int i = 0; i <total ; i++) {
            temptimes = 0;
            for (int j = 0; j <total ; j++) {
                if(numlist[i]==numlist[j]){
                    temptimes++;
                }
            }
            if(temptimes>times){
                result = numlist[i];
                times = temptimes;
            }

            if(temptimes==times&&numlist[i]<result)
                result = numlist[i];
        }
        System.out.println(result);
    }

}