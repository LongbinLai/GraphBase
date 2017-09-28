package graph;

public class UndirectedGraph extends Graph {

  @Override
  public Vertex removeVertex(int id) {
    Vertex v = super.removeVertex(id);
    if (v != null) {
      for (int adjId : v.getNeighbors()) {
        this.getVertex(adjId).removeNeighbor(id);
      }
    }
    return v;
  }

  @Override
  public Edge addEdge(Edge e) {
    this.addVertex(e.getBegin()).addEdge(e);
    return this.addVertex(e.getEnd()).addEdge(e);
  }

  @Override
  public Edge removeEdge(Edge e) {
    Vertex begin = this.getVertex(e.getBegin());
    Vertex end = this.getVertex(e.getEnd());
    if (begin == null || end == null) {
      return null; // return null if the edge doesn't exist
    }
    begin.removeNeighbor(e.getEnd());
    return end.removeNeighbor(e.getBegin());
  }

  public DirectedGraph toDirected() {
    DirectedGraph g = new DirectedGraph();
    for (Edge e : this.getEdges()) {
      g.addEdge(e);
      g.addEdge(e.reversed());
    }
    return g;
  }
}
