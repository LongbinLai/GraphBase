package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public abstract class Graph {

  protected Map<Integer, Vertex> vertices;

  public Graph() {
    this.vertices = new HashMap<Integer, Vertex>();
  }

  public boolean addVertex(int newVertexId) {
    return addVertex(new Vertex(newVertexId));
  }

  public boolean addVertex(Vertex newVertex) {
    if (vertices.containsKey(newVertex.getId())) {
      return false;
    }
    vertices.put(newVertex.getId(), newVertex);
    return true;
  }

  public boolean addVertex(Collection<Vertex> vertexCollection) {
    for (Vertex vertex : vertexCollection) {
      addVertex(vertex);
    }
    return true;
  }

  public abstract Vertex deleteVertex(int vertexId);

  public abstract boolean addEdge(int fromId, int toId);

  public abstract boolean addEdge(Vertex fromVertex, Vertex toVertex);

  public abstract boolean addEdge(Edge edge);

  public abstract boolean addEdge(Collection<Edge> edgeCollection);

  public abstract Edge deleteEdge(int fromId, int toId);

  public abstract Edge deleteEdge(Vertex fromVertex, Vertex toVertex);

  public abstract Edge deleteEdge(Edge edge);

  public Map<Integer, Vertex> getVertices() {
    return vertices;
  }

  public Collection<Edge> getEdges() {
    Set<Edge> edgeset = new HashSet();
    for(Integer vertexId : vertices.keySet()) {
      for (Integer edgeId: vertices.get(vertexId).getAdjEdges().keySet())
        edgeset.add(vertices.get(vertexId).getAdjEdges().get(edgeId));
    }
    return edgeset;
  }

  public boolean isEqual(Graph graph) {
    if (graph.vertices.size() != vertices.size() ) {
      return false;
    }
    if (graph.getEdges().size() != getEdges().size()) {
      return false;
    }
    for (Integer vertexId : vertices.keySet()) {
      for (Integer edgeId : vertices.get(vertexId).getAdjEdges().keySet()) {
        if (!graph.getVertices().get(vertexId).isAdjacent(edgeId)) {
          return false;
        }
      }
    }
    return true;
  }
}
