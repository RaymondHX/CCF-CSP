import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		in.nextLine();
		for (int i = 0; i < size; i++) {
			String tempString = in.nextLine();
			if(Judge(tempString))
				System.out.println("Yes");
			else
				System.out.println("No");
			
		}

	}
	public static boolean Judge(String string) {
		char[] chars = new char[7];
		chars = string.toCharArray();
		List<Character> stack = new ArrayList<Character>();
		List<Character> houzui = new ArrayList<Character>();
		for (int i = 0; i < chars.length; i++) {
			if(chars[i]=='+'||chars[i]=='-'||chars[i]=='x'||chars[i]=='/') {
				char temp = Push(stack, chars[i]);
				if(temp!=0) {
					houzui.add(temp);
				}
			}
			else {
				houzui.add(chars[i]);
			}
			
		}
		while(stack.size()>0) {
			houzui.add(Pop(stack));
		}
		List<Integer> numList = new ArrayList<Integer>();
		for(Character character:houzui) {
			if(character=='+'||character=='-'||character=='x'||character=='/') {
				int temp = 0;
				if(character=='+') {
					temp = numList.get(numList.size()-1)+numList.get(numList.size()-2);
				}
					
			    else if (character=='-') {
			    	temp = numList.get(numList.size()-2)-numList.get(numList.size()-1);
				}
				else if (character=='x') {
					temp = numList.get(numList.size()-1)*numList.get(numList.size()-2);

				}
				else {
					temp = numList.get(numList.size()-2)/numList.get(numList.size()-1);		
				}

			numList.remove(numList.size()-1);
			numList.remove(numList.size()-1);
			numList.add(temp);
			}
			else {
				numList.add(character-'0');
			}
		}
		if(numList.get(0)==24)
			return true;
		else
			return false;
	}
	
	public static char Push(List<Character> stack,char a) {
		if(stack.size()>=1) {
			if((a=='x'||a=='/')&&(stack.get(stack.size()-1)=='+'||(stack.get(stack.size()-1)=='-'))){
				stack.add(a);
				return 0;
			}
			else {
				char b = Pop(stack);
				stack.add(a);
				return b;
			}
		}	
		else {
			stack.add(a);
			return 0;
		}
	}
	public static char Pop(List<Character> stack) {
		char a = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return a;
		
	}
}
