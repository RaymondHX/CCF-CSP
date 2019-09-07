import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int num[] = new int[total];
        for (int i = 0; i <total ; i++) {
            num[i] = Integer.valueOf(in.next());
        }
        int tempheight,tempsize,size = 0;
        for (int i = 0; i <total ; i++) {
            tempheight = num[i];
            for (int j = i; j <total ; j++) {
                if(num[j]<tempheight)
                    tempheight = num[j];
                tempsize = (j-i+1)*tempheight;
                if(tempsize>size)
                    size = tempsize;
            }
        }
        System.out.println(size);
    }
}
