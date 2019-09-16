
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long r = scanner.nextLong();
		long y = scanner.nextLong();
		long g = scanner.nextLong();
		long n = scanner.nextLong();
	    long usedTime = 0;
		for (long i = 0; i < n; i++) {
			int kind = scanner.nextInt();
			long time = scanner.nextLong();
			switch (kind) {
			case 0:
				usedTime+=time;
				break;
			case 1:
				if(time>=usedTime)
					usedTime = time;
				else {
					long left = usedTime-time;
					if(left%(r+y+g)<=g)
						usedTime = usedTime;
					else if (left%(y+r+g)<=g+y) {
						usedTime +=g+y-(left%(y+r+g))+r;
					}
					else {
						usedTime+=g+y+r-(left%(y+r+g));
					}
				}
					break;
			case 2:
				if(time>=usedTime) {
					usedTime = time+r;
				}
				else {
					long left = usedTime-time;
					if(left%(r+y+g)<=r)
						usedTime +=r-left%(r+y+g);
					else if (left%(r+y+g)<=r+g) {
						usedTime = usedTime;
					}
					else {
						usedTime+=r+g+y-left%(r+y+g)+r;
					}
				}
				break;
			case 3:
				if(time>=usedTime)
					usedTime = usedTime;
				else {
					long left = usedTime-time;
					if(left%(r+y+g)<=y)
						usedTime+=y-left%(r+y+g)+r;
					else if (left%(r+y+g)<=y+r) {
						usedTime+=y+r-left%(r+y+g);
					}
					else {
						usedTime = usedTime;
					}
				}
				break;
			default:
				break;
			}
		}
		System.out.println(usedTime);
		}
}