import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.next());
        int m = Integer.valueOf(in.next());
        int k = Integer.valueOf(in.next());
        int d = Integer.valueOf(in.next());
        List<Shop> shops = new ArrayList<>();
        for (int i = 0; i <m ; i++) {
            shops.add(new Shop(Integer.valueOf(in.next()),
                    Integer.valueOf(in.next())));
        }
        List<Buyer> buyers = new ArrayList<>();
        for (int i = 0; i <k ; i++) {
            buyers.add(new Buyer(Integer.valueOf(in.next()),
                    Integer.valueOf(in.next()),
                    Integer.valueOf(in.next())));
        }

    }
}
class Shop{
    int x,int y;
    Shop(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Buyer{
    int x,y,c;
    Buyer(int x,int y,int c){
        this.x = x;
        this.y = y;
        this.c = c;
    }
}

class Block{
    int x,int y;
    Block(int x,int y){
        this.x = x;
        this.y = y;
    }
}