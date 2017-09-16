import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class Graph{
	public ArrayList<Vertex> vertexes;
	public ArrayList<Boolean> visitMark;

	public Graph(){
		this.vertexes=new ArrayList<Vertex>();
		this.visitMark=new ArrayList<Boolean>();
	}
	public Graph(Integer graphSize){
		this();
		int i=0;
		while(i<graphSize){
			i++;
			Vertex newVt=new Vertex();
			addVertex(newVt);
		}
			
	}
	public void addVertex(Vertex newVertex){
		newVertex.id=new Integer(vertexes.size());
		this.vertexes.add(newVertex);
		this.visitMark.add(false);
	}
	public void addEdge(Integer i,Integer j){
		if(i==j){
			System.out.println("Loop is not allowed");
			return;
		}
		if(!this.vertexes.get(i).ifAdj(j)){
			this.vertexes.get(i).adjvertex.add(j);
		}

		if(!this.vertexes.get(j).ifAdj(i)){
			this.vertexes.get(j).adjvertex.add(i);
		}
	}
	public void visit(Integer k){
		    System.out.println(k);
			this.visitMark.set(k,true);
	}
	public boolean ifVisit(Integer k){
		return this.visitMark.get(k);
	}
	public void DFS(Integer k){
		if(ifVisit(k)){
			return;
		}
		visit(k);
		Iterator<Integer> iter=vertexes.get(k).adjvertex.iterator();
		Integer it;
		if(iter.hasNext()){
			it=iter.next();
		}
		else{
			return;
		}
		while(ifVisit(it)){
			if(iter.hasNext()){
				it=iter.next();
			}
			else{
				return;
			}
		}
		DFS(it);
		return;
	}
	public void BFS(Integer k){
		LinkedList<Integer> vertexQueue=new LinkedList<Integer>();
		if(!ifVisit(k)){
			visit(k);
		}
		Iterator<Integer> iter=vertexes.get(k).adjvertex.iterator();
		Integer it;
		if(iter.hasNext()){
			it=iter.next();
			if(!ifVisit(it)){
				vertexQueue.add(it);
				visit(it);
			}
		}
		else{
			return;
		}
		while(iter.hasNext()){
			it=iter.next();
			if(!ifVisit(it)){
				vertexQueue.add(it);
				visit(it);
			}
		}
		it=vertexQueue.poll();
		while(it!=null){
			BFS(it);
			it=vertexQueue.poll();
		}
	}
}