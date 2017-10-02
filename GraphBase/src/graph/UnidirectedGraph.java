package graph;
import java.lang.Cloneable;
import java.util.Collection;

public class UnidirectedGraph extends Graph implements Cloneable{

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

  public boolean addEdge(int fromId, int toId) {
    Edge newEdge = new Edge(fromId, toId);
    return addEdge(newEdge);
  }

  public boolean addEdge(Vertex fromVertex, Vertex toVertex) {
    return addEdge(fromVertex.getId(), toVertex.getId());
  }

  public boolean addEdge(Edge edge) {
    addVertex(edge.getFromId());
    addVertex(edge.getToId());
    if (vertices.get(edge.getFromId()).isAdjacent(edge.getToId())) {
      return false;//represents the edge has already existed.
    }
    vertices.get(edge.getFromId()).addFromAdjEdge(edge);
    vertices.get(edge.getToId()).addToAdjEdge(edge);
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
    return deleteEdge(edge.getFromId(), edge.getToId());
  }

  public UnidirectedGraph clone() {
    Collection<Edge> edgeCollection = getEdges();
    UnidirectedGraph newGraph = new UnidirectedGraph();
    for (Integer vertexId : vertices.keySet()) {
      newGraph.addVertex(vertexId);
    }
    for (Edge edge : edgeCollection) {
      newGraph.addEdge(edge.getFromId(),edge.getToId());
    }
    return newGraph;
  }
}
