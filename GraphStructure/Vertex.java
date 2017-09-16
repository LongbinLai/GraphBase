import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Vertex{
	public Integer id;
	public HashSet<Integer> adjvertex;
	public Vertex(){
		this.id=new Integer(-1);
		this.adjvertex=new HashSet<Integer>();
	}
	public boolean ifAdj(Integer vid){
		return adjvertex.contains(vid);
	}

}