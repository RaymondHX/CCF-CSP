import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String ISBN = in.nextLine();
        String[] parts = ISBN.split("-");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parts[0]);stringBuilder.append(parts[1]);stringBuilder.append(parts[2]);
        String num = stringBuilder.toString();
        char[] array = num.toCharArray();
        int total = 0;
        for (int i = 1; i <=array.length; i++) {
            total+=i*(array[i-1]-'0');
        }
        int left = total%11;
        if(left==10&&parts[3].equals("X"))
            System.out.println("Right");
        else if(!(left==Integer.valueOf(parts[3])&&left<10)){
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(parts[0]);
            stringBuilder1.append("-");
            stringBuilder1.append(parts[1]);
            stringBuilder1.append("-");
            stringBuilder1.append(parts[2]);
            stringBuilder1.append("-");
            if(left<10)
                stringBuilder1.append(String.valueOf(left));
            else
                stringBuilder1.append("X");
            System.out.println(stringBuilder1.toString());
        }
        else if (left==Integer.valueOf(parts[3])&&left<10)
            System.out.println("Right");
        else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(parts[0]);
            stringBuilder1.append("-");
            stringBuilder1.append(parts[1]);
            stringBuilder1.append("-");
            stringBuilder1.append(parts[2]);
            stringBuilder1.append("-");
            if(left<10)
                stringBuilder1.append(String.valueOf(left));
            else
                stringBuilder1.append("X");
            System.out.println(stringBuilder1.toString());
        }

    }
}
