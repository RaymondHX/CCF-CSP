import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        char[] chars = input.toCharArray();
        List<String> noparam = new ArrayList<>();
        List<String> param = new ArrayList<>();
        for (int i = 0; i <chars.length-1 ; i++) {
            if(chars[i+1]==':'){
                param.add(String.valueOf(chars[i]));
                i++;
            }
             else {
                noparam.add(String.valueOf(chars[i]));
            }
        }
        noparam.add(String.valueOf(chars[chars.length-1]));
        int num = in.nextInt();
        in.nextLine();
        List<List<String>> commands = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            List<String> list = new ArrayList<>();
            String a;
            a = in.nextLine();
            String[] b = a.split(" ");
            list = Arrays.asList(b);
            commands.add(list);
        }
        List<List<String>> result= new ArrayList<>();
        for(List<String> list:commands){
            List<String> temp = new LinkedList<>();
            for (int i = 1; i <list.size() ; i++) {
                if(param.contains(remove(list.get(i)))){
                    addwithparam(temp,param,list.get(i),list.get(i+1));
                    i++;
                }
                else if(noparam.contains(remove(list.get(i)))){
                    addwithoutparam(temp,param,list.get(i));
                }
                else
                    break;
            }
            result.add(temp);
        }
        int j = 0;
        for(List<String> list:result){
            System.out.printf("Case "+(j+1)+":");
            for (int i = 0; i <list.size() ; i++) {
                System.out.printf(" "+list.get(i));
            }
            System.out.printf("\n");
            j++;
        }
    }
    private static String remove(String a){
        return a.substring(1);
}
    private static void addwithparam(List<String> list,List<String> param,String a,String b){
        if(list.contains(a)){
            int index = list.indexOf(a);
            list.set(index+1,b);
        }
        else{
            boolean flag = false;
            for (int i = 0; i <list.size() ; i++) {
                if(a.compareTo(list.get(i))<0){
                    list.add(i,a);
                    list.add(i+1,b);
                    flag = true;
                    break;
                }
                if(param.contains(remove(list.get(i))))
                    i++;
            }
            if(!flag){
                list.add(a);
                list.add(b);
            }
        }
    }
    private static void addwithoutparam(List<String> list,List<String> param,String a){
        if(list.contains(a))
            return;
        else {
            boolean flag = false;
            for (int i = 0; i <list.size() ; i++) {
                if(a.compareTo(list.get(i))<0){
                    list.add(i,a);
                    flag = true;
                    break;
                }
                if(param.contains(remove(list.get(i))))
                    i++;
            }
            if(!flag){
                list.add(a);
            }
        }
    }
}
