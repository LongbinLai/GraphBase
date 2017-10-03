package graph;

import java.util.Collection;
import java.lang.Cloneable;

public class DirectedGraph extends Graph implements Cloneable {

  public Vertex deleteVertex(int vertexId) {
    Vertex deletedVertex = vertices.remove(vertexId);
    if (deletedVertex != null) {
      vertices.values().forEach(v -> v.deleteAdjEdge(vertexId));
    }
    return deletedVertex;
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
    int fromId = edge.getFrom();
    int toId = edge.getTo();
    addVertex(fromId);
    addVertex(toId);
    if (this.vertices.get(fromId).isAdjacent(toId)) {
      return false;
    }
    this.vertices.get(fromId).addFromAdjEdge(edge);
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
    return vertices.get(fromId).deleteAdjEdge(toId);
  }

  public Edge deleteEdge(Vertex fromVertex, Vertex toVertedx) {
    return deleteEdge(fromVertex.getId(), toVertedx.getId());
  }

  public Edge deleteEdge(Edge edge) {
    return deleteEdge(edge.getFrom(), edge.getTo());
  }

  @Override
  public DirectedGraph clone() {
    Collection<Vertex> vertexCollection = getVertices();
    DirectedGraph newGraph = new DirectedGraph();
    vertexCollection.forEach(vertex -> newGraph.addVertex(vertex.clone()));
    return newGraph;
  }

}

