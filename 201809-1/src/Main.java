import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt();
	List<Integer> shops= new ArrayList<Integer>();
	for (int i = 0; i < n; i++) {
		shops.add(scanner.nextInt());
	}
	List<Integer> result = new ArrayList<Integer>();
	for (int i = 0; i < n; i++) {
		if(i==0)
			result.add((shops.get(i)+shops.get(i+1))/2);
		else if (i==n-1) {
			result.add((shops.get(i)+shops.get(i-1))/2);
		}
		else {
			result.add((shops.get(i-1)+shops.get(i)+shops.get(i+1))/3);
		}
	}
	System.out.printf("%d", result.get(0));
	for (int i = 1; i < n; i++) {
		System.out.printf(" %d", result.get(i));
	}
	}

}
