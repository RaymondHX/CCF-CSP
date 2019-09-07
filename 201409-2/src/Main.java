import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<Triangle> triangles = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            triangles.add(new Triangle(Integer.valueOf(in.next()),
                    Integer.valueOf(in.next()),
                    Integer.valueOf(in.next()),
                    Integer.valueOf(in.next())));
        }
        Boolean[][] size = new Boolean[100][100];
        for (int i = 0; i <100 ; i++) {
            for (int j = 0; j <100 ; j++) {
                size[i][j] = false;
            }
        }
        for(Triangle triangle:triangles){
            for (int i = triangle.x1; i <triangle.x2 ; i++) {
                for (int j = triangle.y1; j <triangle.y2 ; j++) {
                    size[i][j] = true;
                }
            }
        }
        int result = 0;
        for (int i = 0; i <100 ; i++) {
            for (int j = 0; j <100 ; j++) {
                if(size[i][j])
                    result++;
            }
        }
        System.out.println(result);
    }
}

class Triangle{
    int x1,x2,y1,y2;
    Triangle(int x1,int y1,int x2,int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}