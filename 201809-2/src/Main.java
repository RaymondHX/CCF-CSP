import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Domain> domains1 = new ArrayList<Domain>();
		for (int i = 0; i < n; i++) {
			domains1.add(new Domain(scanner.nextInt(), scanner.nextInt()));
		}
		List<Domain> domains2 = new ArrayList<Domain>();
		for (int i = 0; i < n; i++) {
			domains2.add(new Domain(scanner.nextInt(), scanner.nextInt()));
		}
		int result = 0;
		for(Domain domain:domains1) {
			for(Domain domain2:domains2) {
				result+=Cut(domain, domain2);
			}
		}
		System.out.println(result);
	}
	public static int Cut(Domain domain1,Domain domain2) {
		if(domain1.begin>=domain2.end)
			return 0;
		else if (domain1.end<=domain2.begin) {
			return 0;
		}
		else {
			if(domain1.begin>=domain2.begin) {
				if(domain1.end>=domain2.end)
					return domain2.end-domain1.begin;
				else
					return domain1.end-domain1.begin;
			}
			else {
				if(domain1.end<domain2.end)
					return domain1.end-domain2.begin;
				else
					return domain2.end-domain2.begin;
			}
		}
	}
}

class Domain{
	int begin,end;
	public Domain(int begin,int end) {
		this.begin = begin;
		this.end = end;
	}
}