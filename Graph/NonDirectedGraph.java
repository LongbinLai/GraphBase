package Graph;

//import java.util.Map;

public class NonDirectedGraph extends Graph {
  
  @Override
  public Edge addEdge(Edge e) {
    this.addVertex(e.getStart()).addEdge(e);
    return this.addVertex(e.getEnd()).addEdge(e);
  }
  
  @Override
  public Edge rmvEdge(Edge e) {
    Vertex start = this.getVertex(e.getStart());
    Vertex end = this.getVertex(e.getEnd());
    start.rmvEdge(e);
    return end.rmvEdge(e);
  } 
  
  @Override
  public void rmvVertex(Vertex v) {
    //v.getEdges().forEach(e -> {this.rmvEdge(e);});
    for (Edge e : v.getEdges()) {
      this.rmvEdge(e);
    }
    super.rmvVertex(v);
  }
 
}
