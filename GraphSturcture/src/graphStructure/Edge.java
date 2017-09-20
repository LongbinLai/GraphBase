package graphStructure;

public class Edge {

  private Integer edgeId;

  private Vertex from;
  private Vertex to;

  public Edge(Integer newEdgeId, Vertex newFrom, Vertex newTo) {
    edgeId = newEdgeId;
    from = newFrom;
    to = newTo;
  }

  public Integer getEdgeId() {
    return edgeId;
  }

  public Vertex getFrom() {
    return from;
  }

  public Vertex getTo() {
    return to;
  }
}
