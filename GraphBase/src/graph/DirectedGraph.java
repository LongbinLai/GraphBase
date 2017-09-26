package graph;

public class DirectedGraph extends Graph {

  public int addEdge(int fromId, int toId) {
    addVertex(fromId);
    addVertex(toId);
    if (!this.vertices.get(fromId).isAdjacent(toId)) {
      Edge newEdge = new Edge(fromId, toId);
      this.vertices.get(fromId).addFromAdjEdge(newEdge);
      return 0;// 0 represents the edge is not existed , otherwise return 1;
    }
    return 1;
  }

  public int addEdge(Vertex fromVertex, Vertex toVertex) {
    return addEdge(fromVertex.getId(), toVertex.getId());
  }

  public int addEdge(Edge edge) {
    return addEdge(edge.getFromId(), edge.getToId());
  }

  public Edge deleteEdge(int fromId, int toId) {
    return vertices.get(fromId).deleteAdjEdge(toId);
  }

  public Edge deleteEdge(Vertex fromVertex, Vertex toVertedx) {
    return deleteEdge(fromVertex.getId(), toVertedx.getId());
  }

  public Edge deleteEdge(Edge edge) {
    return deleteEdge(edge.getFromId(), edge.getToId());
  }
}
