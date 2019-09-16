import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int size = in.nextInt();
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.valueOf(in.next());
		}
		if(a[0]<a[size-1]) {
			if(size%2==0) {
				if((a[size/2]+a[size/2-1])%2==1)
				System.out.println(a[size-1]+" "+((float)a[size/2]+(float)a[size/2-1])/2+" "+a[0]);
				else {
					System.out.println(a[size-1]+" "+(a[size/2]+a[size/2-1])/2+" "+a[0]);
				}
			}
			else {
				System.out.println(a[size-1]+" "+a[size/2]+" "+a[0]);
			}
		}
		else {
			if(size%2==0) {
				if((a[size/2]+a[size/2-1])%2==1)
				System.out.println(a[0]+" "+((float)a[size/2]+(float)a[size/2-1])/2+" "+a[size-1]);
				else {
					System.out.println(a[0]+" "+(a[size/2]+a[size/2-1])/2+" "+a[size-1]);
				}
			}
			else {
				System.out.println(a[0]+" "+a[size/2]+" "+a[size-1]);
			}
		}
		in.close();
	}
	

}
