package Graph;

public class DirectedGraph extends Graph {
  
  @Override
  public Edge addEdge(Edge e) {
    this.addVertex(e.getEnd());
    return this.addVertex(e.getStart()).addEdge(e);
  }
  
  @Override
  public Edge rmvEdge(Edge e) {
    Vertex start = this.getVertex(e.getStart());
    if (start == null) {
      return null;
    }
    return start.rmvEdge(e);
  } 
  
  @Override
  public void rmvVertex(Vertex v) {
    int id = v.getVertexId();
    for (Edge e: this.getAllEdges()) {
      if (e.getStart() == id || e.getEnd() == id) {
        this.rmvEdge(e);
      }      
    }
    super.rmvVertex(v);
  }
  
}
