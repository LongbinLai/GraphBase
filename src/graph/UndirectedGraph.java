package graph;

public class UndirectedGraph extends Graph {

  @Override
  public Vertex removeNode(int id) {
    Vertex v = super.removeNode(id);
    if (v != null) {
      for (int adjId : v.getNeighbors()) {
        this.getNode(adjId).removeNeighbor(id);
      }
    }
    return v;
  }

  @Override
  public Edge addEdge(Edge e) {
    this.addNode(e.getStart()).addEdge(e);
    return this.addNode(e.getEnd()).addEdge(e);
  }

  @Override
  public Edge removeEdge(Edge e) {
    this.getNode(e.getStart()).removeNeighbor(e.getEnd());
    return this.getNode(e.getEnd()).removeNeighbor(e.getStart());
  }
}
