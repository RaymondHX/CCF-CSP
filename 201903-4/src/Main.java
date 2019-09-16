import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.valueOf(in.next());
		int n = Integer.valueOf(in.next());
        in.nextLine();
		for (int i = 0; i < T; i++) {
			List<List<Signal>> commands = new ArrayList<List<Signal>>();
			for (int j = 0; j < n; j++) {
				List<Signal> signals = new ArrayList<Signal>();
				String tempString = in.nextLine();
				String[] temStrings = tempString.split(" ");
				for (int k = 0; k < temStrings.length; k++) {
				}
				for (int k = 0; k < temStrings.length; k++) {
					String dir= temStrings[k].substring(0, 1);
					int num = Integer.valueOf(temStrings[k].substring(1,temStrings[k].length()));
					signals.add(new Signal(dir, num));
				}
				commands.add(signals);
			}
			int[] indexs = new int[n];
			for (int j = 0; j < indexs.length; j++) {
				indexs[j] = 0;
			}
			boolean flag = true;
			boolean done = false;
			while(flag) {
				done = false;
				for (int j = 0; j < n; j++) {
					if(indexs[j]>=commands.get(j).size())
						break;
					Signal signal = commands.get(j).get(indexs[j]);
					if(signal.dir.equals("S")) {
						Signal anotherSignal = commands.get(signal.num).get(indexs[signal.num]);
						if(anotherSignal.dir.equals("R")&&anotherSignal.num==j) {
							indexs[signal.num]++;
							indexs[anotherSignal.num]++;
							done = true;
						}
					}				
				}
				int count = 0;
				for (int j = 0; j < indexs.length; j++) {
					if(indexs[j]>=commands.get(j).size()) {
						count++;
					}
				}
				if(count==indexs.length) {
					System.out.println(0);
					flag = false;
				}
					
				if(count<indexs.length&&!done) {
					System.out.println(1);
					flag = false;
				}
					
			}
		}

	}
	

}

class Signal{
	String dir;
	int num;
	public Signal(String dir,int num) {
		this.dir = dir;
		this.num = num;
	}

}