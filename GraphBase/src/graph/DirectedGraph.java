package graph;

public class DirectedGraph extends Graph {

  public Vertex deleteVertex(int vertexIndex) {
    Vertex deletedVertex = vertices.remove(vertexIndex);
    if (deletedVertex != null) {
      for (Integer key : vertices.keySet()) {
        vertices.get(key).deleteAdjEdge(vertexIndex);
      }
    }
    return deletedVertex;
  }

  public Vertex deleteVertex(Vertex vertex)  {
    return deleteVertex(vertex.getId());
  }

  public boolean addEdge(int fromId, int toId) {
    addVertex(fromId);
    addVertex(toId);
    if (!this.vertices.get(fromId).isAdjacent(toId)) {
      Edge newEdge = new Edge(fromId, toId);
      this.vertices.get(fromId).addFromAdjEdge(newEdge);
      return false;// 0 represents the edge is not existed , otherwise return 1;
    }
    return true;
  }

  public boolean addEdge(Vertex fromVertex, Vertex toVertex) {
    return addEdge(fromVertex.getId(), toVertex.getId());
  }

  public boolean addEdge(Edge edge) {
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
