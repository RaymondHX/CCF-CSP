import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int root = in.nextInt();
        List<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < m; i++) {
			edges.add(new Edge(in.nextInt(),in.nextInt(),in.nextInt()));
		}
		Collections.sort(edges);			
		List<Edge> miniTree = new ArrayList<Edge>();
		int[] parents = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			parents[i] = i;
		}
		for(Edge edge:edges) {
			int fathera = find(parents, edge.a);
			int fatherb = find(parents, edge.b);
			if(fathera!=fatherb) {
				miniTree.add(edge);
				parents[edge.b] = edge.a;
			}			
		}
		int max = 0;
		for(Edge edge:miniTree) {
			if(edge.value>max)
				max = edge.value;
		}
		System.out.println(max);
	}
    public static int find(int[] parents,int node) {
    	while(parents[node]!=node) {
    		parents[node] = parents[parents[node]];		//Ñ¹ËõÂ·¾¶
			node = parents[node];
    	}
    	return node;
    }
}
class Edge implements Comparable<Edge>{
	int a;
	int b;
	int value;
	public Edge(int a,int b,int value) {
		this.a = a;
		this.b = b;
		this.value = value;
	}
	@Override
	public int compareTo(Edge another) {
		return this.value-another.value;
	}
}