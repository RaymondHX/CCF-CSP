import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <total ; i++) {
            int temp = Integer.valueOf(in.next());
            map.put(temp,temp);
        }
        int result = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getKey()<0){
                if(map.containsKey(-entry.getKey()))
                    result++;
            }
        }
        System.out.println(result);
    }

}
