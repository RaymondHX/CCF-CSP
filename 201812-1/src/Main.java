import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		int y = in.nextInt();
		int g = in.nextInt();
		in.nextLine();
		int n = in.nextInt();
		in.nextLine();
		int total = 0;
		for (int i = 0; i < n; i++) {
			int kind = Integer.parseInt(in.next());
			int time = Integer.parseInt(in.next());
			if(kind==0) {
				total+=time;
			}
			else if(kind==1) {
				total+=time;
			}
			else if(kind==2){
				total = total+time+r;
			}
			else {
				total = total;
			}
		}
		System.out.println(total);
	}

}
