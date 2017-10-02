package graph;

import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Vertex implements Cloneable{

  private int vertexId;
  private Map<Integer, Edge> adjEdges;

  public Vertex(int newVertexId) {
    this.vertexId = newVertexId;
    this.adjEdges = new HashMap<Integer, Edge>();
  }

  public int getId() {
    return vertexId;
  }

  public Map<Integer, Edge> getAdjEdges() {
    return adjEdges;
  }

  public boolean addFromAdjEdge(Edge newEdge) {
    if (newEdge.getFromId() != vertexId) {
      return false; // (represents the edge is not from the vertex)
    }
    adjEdges.put(newEdge.getToId(), newEdge);// use the tovertex'id to be the newedge's id;
    return true;// normal case
  }

  public boolean addToAdjEdge(Edge newEdge) {
    if (newEdge.getToId() != vertexId) {
      return false;//(represents the edge is not to this vertex)
    }
    adjEdges.put(newEdge.getFromId(), newEdge);
    return true;
  }

  public Edge deleteAdjEdge(Integer edgeId) {
    return adjEdges.remove(edgeId);
  }

  public boolean isAdjacent(int vertexId) {
    Integer id = new Integer(vertexId);
    return adjEdges.keySet().contains(id);
  }

  public void setAdjEdges(Map<Integer, Edge> adjEdges) {
    this.adjEdges = adjEdges;
  }

  public Vertex clone() {
    Vertex cloneVertex = new Vertex(vertexId);
    HashMap<Integer,Edge> newAdjEdges = new HashMap();
    for (Integer edgeId : adjEdges.keySet()) {
      newAdjEdges.put(edgeId,adjEdges.get(edgeId).clone());
    }
    cloneVertex.setAdjEdges(newAdjEdges);
    return cloneVertex;
  }

  boolean isEqual(Vertex vertex) {
    if (vertexId != vertex.getId()) {
      return false;
    }
    if (adjEdges.size() != vertex.getAdjEdges().size()) {
      return false;
    }
    for (Integer id : adjEdges.keySet()) {
      if (!vertex.getAdjEdges().keySet().contains(id)) {
        return false;
      }
    }
    return true;
  }
}
