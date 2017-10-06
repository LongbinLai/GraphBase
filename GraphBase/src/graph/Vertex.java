package graph;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Vertex implements Cloneable {

  private int vertexId;
  private Map<Integer, Edge> adjEdges;

  public Vertex(int newVertexId) {
    this.vertexId = newVertexId;
    this.adjEdges = new HashMap<Integer, Edge>();
  }

  public int getId() {
    return vertexId;
  }

  public Edge getAdjEdge(int id) {
    return adjEdges.get(id);
  }

  public Collection<Edge> getAdjEdges() {
    return adjEdges.values();
  }

  public Collection<Integer> getNeighbors() {
    return adjEdges.keySet();
  }

  public boolean addFromAdjEdge(Edge newEdge) {
    if (newEdge.getFrom() != vertexId) {
      return false; // (represents the edge is not from the vertex)
    }
    adjEdges.put(newEdge.getTo(), newEdge);// use the tovertex'id to be the newedge's id;
    return true;// normal case
  }

  public boolean addToAdjEdge(Edge newEdge) {
    if (newEdge.getTo() != vertexId) {
      return false;//(represents the edge is not to this vertex)
    }
    adjEdges.put(newEdge.getFrom(), newEdge);
    return true;
  }

  public Edge deleteAdjEdge(int edgeId) {
    return adjEdges.remove(edgeId);
  }

  public boolean isAdjacent(int vertexId) {
    return adjEdges.containsKey(vertexId);
  }

  public void setAdjEdges(Map<Integer, Edge> adjEdges) {
    this.adjEdges = adjEdges;
  }

  @Override
  public Vertex clone() {
    Vertex cloneVertex = new Vertex(vertexId);
    HashMap<Integer, Edge> newAdjEdges = new HashMap();
    adjEdges.keySet().forEach(key -> newAdjEdges.put(key,adjEdges.get(key).clone()));
    cloneVertex.setAdjEdges(newAdjEdges);
    return cloneVertex;
  }

  @Override
  public boolean equals(Object obj) {
    Vertex vertex = (Vertex) obj;
    if (vertexId != vertex.getId()) {
      return false;
    }
    Collection<Integer> neighborIds = vertex.getNeighbors();
    if (adjEdges.size() != neighborIds.size()) {
      return false;
    }
    Set<Integer> adjKeySet = adjEdges.keySet();
    for (int id : adjKeySet) {
      if (!neighborIds.contains(id)) {
        return false;
      }
    }
    return true;
  }
}
