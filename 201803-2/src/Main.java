import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int L = in.nextInt();
		int t = in.nextInt();
		List<Ball> balls = new ArrayList<Ball>();
		for (int i = 0; i < n; i++) {
			balls.add(new Ball(in.nextInt(), 1));
		}
		for (int i = 0; i < t; i++) {
			for(Ball ball:balls) {
				ball.place+=ball.direction;
			}
			for(Ball ball:balls) {
				if(ball.place==0||ball.place==L)
					ball.direction = -(ball.direction);
			}
			for(Ball ball:balls) {
				for(Ball ball2:balls) {
					if(ball.place==ball2.place&&ball.place!=0&&ball.place!=L&&!ball.equals(ball2))
						ball.direction = -ball.direction;
				}
			}
		}
		System.out.printf("%d", balls.get(0).place);
		for (int i = 1; i < n; i++) {
			System.out.printf(" %d", balls.get(i).place);
		}
	}

}

class Ball{
	int place;
	int speed;
	int direction;
	public Ball(int place,int direction) {
		this.place = place;
		this.speed = 1;
		this.direction = direction;
	}
}