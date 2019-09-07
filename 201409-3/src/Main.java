import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String standard = in.nextLine();
        boolean capital;
        if( Integer.valueOf(in.next())==0)
            capital = true;
        else
            capital = false;
        int n =  Integer.valueOf(in.next());
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            strings.add(in.nextLine());
        }
        for(String string:strings){
            if(capital){
                if(plain(string.toLowerCase(),standard.toLowerCase()))
                    System.out.println(string);
            }
            else {
                if(plain(string,standard))
                    System.out.println(string);
            }
        }
    }
    private static boolean plain(String source, String pattern) {
        int res=0;
        int sourceLength=source.length();
        int patternLength=pattern.length();
        for(int i=0;i<=(sourceLength-patternLength);i++){
            res++;
            String str=source.substring(i, i+patternLength);
            if(str.equals(pattern)){
                return true;
            }
        }
        return false;
    }
}
