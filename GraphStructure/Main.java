import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		Graph graph=new Graph(5);		
		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		graph.addEdge(4,0);
		graph.addEdge(1,4);
		graph.BFS(0);
		System.out.println("Hello World!");
	}
}

