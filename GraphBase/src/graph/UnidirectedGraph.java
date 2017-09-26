package graph;

public class UnidirectedGraph extends Graph {

  public Vertex deleteVertex(int vertexIndex) {

    if (!vertices.containsKey(vertexIndex)) {
      return null;
    }
    for (Integer key : vertices.get(vertexIndex).getAdjEdges().keySet()) {
      this.deleteEdge(vertices.get(vertexIndex).getAdjEdges().get(key));
    }
    return vertices.remove(vertexIndex);
  }

  public Vertex deleteVertex(Vertex vertex) {
    return deleteVertex(vertex.getId());
  }

  public int addEdge(int fromId, int toId) {
    this.addVertex(fromId);
    this.addVertex(toId);
    if (vertices.get(fromId).isAdjacent(toId)) {
      return 0;//represents the edge has already existed.
    }
    Edge newEdge = new Edge(fromId, toId);
    vertices.get(fromId).addFromAdjEdge(newEdge);
    vertices.get(toId).addToAdjEdge(newEdge);
    return 1; // normal return
  }

  public int addEdge(Vertex fromVertex, Vertex toVertex) {
    return addEdge(fromVertex.getId(), toVertex.getId());
  }

  public int addEdge(Edge edge) {
    return addEdge(edge.getFromId(), edge.getToId());
  }

  public Edge deleteEdge(int fromId, int toId) {
    vertices.get(fromId).deleteAdjEdge(toId);
    return vertices.get(toId).deleteAdjEdge(fromId);
  }

  public Edge deleteEdge(Vertex fromVertex, Vertex toVertex) {
    return deleteEdge(fromVertex.getId(), toVertex.getId());
  }

  public Edge deleteEdge(Edge edge) {
    return deleteEdge(edge.getFromId(), edge.getToId());
  }
}
