package graph;

public class DirectedGraph extends AbstractGraph {

  @Override
  public Vertex removeNode(int id) {
    Vertex v = super.removeNode(id);
    if (v != null) {
      for (Vertex n : this.getNodes()) {
        n.removeNeighbor(id);
      }
    }
    return v;
  }

  @Override
  public Edge addEdge(Edge e) {
    this.addNode(e.getEnd());
    return this.addNode(e.getStart()).addEdge(e);
  }

  @Override
  public Edge removeEdge(Edge e) {
    return this.getNode(e.getStart()).removeNeighbor(e.getEnd());
  }
}
