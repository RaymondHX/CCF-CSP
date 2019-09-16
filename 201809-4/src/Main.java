import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nextday = new int[n];
		for (int i = 0; i < nextday.length; i++) {
			nextday[i] = scanner.nextInt();
		}
		List<Integer> current = new ArrayList<Integer>();
		int begin = 1;
		while(current.size()<n) {
			if(current.isEmpty())
				current.add(begin);
			else if (current.size()==1) {
				int second = findMin2(nextday[0], current.get(0));
				if(second>0)
					current.add(second);
				else {
					current.clear();
					begin++;
				}					
			}
			else if (current.size()>1&&current.size()<n-1) {
				int temp =findMin( nextday[current.size()-1], current.get(current.size()-1), current.get(current.size()-2));
				if(temp>0)
					current.add(temp);
				else {
					current.clear();
					begin++;
				}					
			}
			else if(current.size()==n-1){
				int temp = findMin2(nextday[n-1],current.get(current.size()-1));
				if(temp>0)
					current.add(temp);
				else {
					current.clear();
					begin++;
				}
			}			
		}
		System.out.printf("%d",current.get(0));
		for (int i = 1; i < current.size(); i++) {
			System.out.printf(" %d",current.get(i));
		}
	}
public static int findMin(int aver,int a,int b) {
	if(a+b+1>=(aver+1)*3)
		return -1;
	else {
		int i = 1;
		while(true) {
			if(a+b+i<(aver+1)*3&&a+b+i>=aver*3)
				return i;
			i++;
		}		
	}
}
public static int findMin2(int aver,int a) {
	if(a+1>=(aver+1)*2)
		return -1;
	else {
		int i = 1;
		while(true) {
			if(a+i<(aver+1)*2&&a+i>=aver*2)
				return i;
			i++;
		}
	}
}
}
