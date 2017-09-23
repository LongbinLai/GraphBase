package graph;

import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Vertex {

  private int vertexId;
  private Map<Integer, Edge> adjEdges;

  public Vertex(int newVertexId) {
    this.vertexId = newVertexId;
    this.adjEdges = new HashMap<Integer, Edge>();
  }

  public int getId() {
    return vertexId;
  }

  public Map getAdjEdges() {
    return adjEdges;
  }

  public void addAdjEdge(Edge newEdge) {
    if (newEdge.getFromId() != vertexId) {
      throw new VerifyError("The edge is not from this vertex");
    }
    adjEdges.put(newEdge.getToId(), newEdge);// use the tovertex'id to be the newedge's id;
  }

  public void deleteAdjEdge(Integer edgeId) {
    if (!adjEdges.containsKey(edgeId)) {
      throw new NoSuchElementException("The edge is not in adjEdges");
    }
    adjEdges.remove(edgeId);
  }

  public boolean isAdjacent(int vertexId) {
    Integer id = new Integer(vertexId);
    return adjEdges.keySet().contains(id);
  }
}
