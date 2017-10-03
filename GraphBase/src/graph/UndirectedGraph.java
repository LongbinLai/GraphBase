package graph;

import java.lang.Cloneable;
import java.util.Collection;

public class UndirectedGraph extends Graph implements Cloneable {

  public Vertex deleteVertex(int vertexIndex) {
    if (!vertices.containsKey(vertexIndex)) {
      return null;
    }
    vertices.get(vertexIndex).getAdjEdges().forEach(e -> deleteEdge(e));
    return vertices.remove(vertexIndex);
  }

  public Vertex deleteVertex(Vertex vertex) {
    return deleteVertex(vertex.getId());
  }

  public boolean addEdge(int fromId, int toId) {
    Edge newEdge = new Edge(fromId, toId);
    return addEdge(newEdge);
  }

  public boolean addEdge(Vertex fromVertex, Vertex toVertex) {
    return addEdge(fromVertex.getId(), toVertex.getId());
  }

  public boolean addEdge(Edge edge) {
    addVertex(edge.getFrom());
    addVertex(edge.getTo());
    if (vertices.get(edge.getFrom()).isAdjacent(edge.getTo())) {
      return false;
    }
    vertices.get(edge.getFrom()).addFromAdjEdge(edge);
    vertices.get(edge.getTo()).addToAdjEdge(edge);
    return true;
  }

  public boolean addEdge(Collection<Edge> edgeCollection) {
    for (Edge edge : edgeCollection) {
      if (!addEdge(edge)) {
        return false;
      }
    }
    return true;
  }

  public Edge deleteEdge(int fromId, int toId) {
    vertices.get(fromId).deleteAdjEdge(toId);
    return vertices.get(toId).deleteAdjEdge(fromId);
  }

  public Edge deleteEdge(Vertex fromVertex, Vertex toVertex) {
    return deleteEdge(fromVertex.getId(), toVertex.getId());
  }

  public Edge deleteEdge(Edge edge) {
    return deleteEdge(edge.getFrom(), edge.getTo());
  }

  @Override
  public UndirectedGraph clone() {
    Collection<Vertex> vertexCollection = getVertices();
    Collection<Edge> edgeCollection = getEdges();
    UndirectedGraph newGraph = new UndirectedGraph();
    vertexCollection.forEach(v -> newGraph.addVertex(v.getId()));
    edgeCollection.forEach(e -> newGraph.addEdge(e.clone()));
    return newGraph;
  }
}
