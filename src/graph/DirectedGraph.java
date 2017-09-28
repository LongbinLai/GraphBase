package graph;

public class DirectedGraph extends Graph {

  @Override
  public Vertex removeVertex(int id) {
    Vertex v = super.removeVertex(id);
    if (v != null) {
      for (Vertex n : this.getVertices()) {
        n.removeNeighbor(id);
      }
    }
    return v;
  }

  @Override
  public Edge addEdge(Edge e) {
    this.addVertex(e.getEnd());
    return this.addVertex(e.getBegin()).addEdge(e);
  }

  @Override
  public Edge removeEdge(Edge e) {
    Vertex begin = this.getVertex(e.getBegin());
    if (begin == null) {
      return null; // return null if the edge doesn't exist
    }
    return begin.removeNeighbor(e.getEnd());
  }

  @Override
  public Object clone() {
    DirectedGraph g = new DirectedGraph();
    for (Edge e : this.getEdges()) {
      g.addEdge((Edge) e.clone());
    }
    return g;
  }

  public UndirectedGraph toUndirected() {
    UndirectedGraph g = new UndirectedGraph();
    for (Edge e : this.getEdges()) {
      g.addEdge(e);
    }
    return g;
  }
}
