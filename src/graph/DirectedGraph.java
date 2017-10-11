package graph;

public class DirectedGraph extends Graph {

  @Override
  public Vertex removeVertex(int id) {
    Vertex v = super.removeVertex(id);
    if (v != null) {
      this.getVertices().forEach(n -> n.removeNeighbor(id));
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
    this.getVertices().forEach(v -> g.addVertex((Vertex) v.clone()));
    return g;
  }

}
