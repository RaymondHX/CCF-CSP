import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int num = Integer.valueOf(in.next());
        int click = Integer.valueOf(in.next());
        List<Square> squares = new ArrayList<>();
        for (int i = num; i >0 ; i--) {
            int x1 = Integer.valueOf(in.next());
            int y1 = Integer.valueOf(in.next());
            int x2 = Integer.valueOf(in.next());
            int y2 = Integer.valueOf(in.next());
            squares.add(new Square(x1,y1,x2,y2,i,num-i+1));
        }
        for (int i = 0; i <click ; i++) {
            int x = Integer.valueOf(in.next());
            int y = Integer.valueOf(in.next());
            Square square = Click(squares,x,y);
            if(square!=null){
                System.out.println(square.index);
                refresh(squares,square.place);
            }
            else
                System.out.println("IGNORED");
        }

    }

    private static Square Click(List<Square> squares,int x,int y){
        int l = squares.size();
        for (int i = 0; i <l ; i++) {
            Square square = findSquare(squares,i+1);
            if(square.beginX<=x&&square.endX>=x&&square.beginY<=y&&square.endY>=y)
                return square;
        }
        return null;
    }
    private static Square findSquare(List<Square> squares,int time){
        for(Square square:squares){
            if(square.place==time)
                return square;
        }
        return null;
    }
    private static void refresh(List<Square> squares,int place){
        for(Square square:squares){
            if(square.place<place)
                square.place++;
            else if(square.place==place)
                square.place = 1;
        }
    }
}

class Square{
    int beginX,beginY,endX,endY,place,index;
    Square(int beginX,int beginY,int endX, int endY,int place,int index){
        this.beginX = beginX;
        this.beginY = beginY;
        this.endX = endX;
        this.endY = endY;
        this.place = place;
        this.index = index;
    }
}
