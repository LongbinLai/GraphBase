package graphStructure;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Vertex {

  private Integer vertexId;
  private Map adjVertices;
  public Map adjEdges;

  public Vertex() {
    this.vertexId = new Integer(0);
    this.adjVertices = new HashMap<Integer, Vertex>();
    this.adjEdges = new HashMap<Integer, Edge>();
  }

  public Vertex(Integer newVertexId) {
    this.vertexId = newVertexId;
    this.adjVertices = new HashMap<Integer, Vertex>();
    this.adjEdges = new HashMap<Integer, Edge>();
  }

  public boolean isAdjacent(Integer vid) {
    return adjVertices.containsKey(vid);
  }

  public Integer getId() {
    return vertexId;
  }

  public Map getAdjVertices() {
    return adjVertices;
  }

  public Map getAdgEdges() {
    return adjEdges;
  }

  public void setId(Integer newSetId) {
    vertexId = newSetId;
  }

  public void addAdjVertex(Vertex newAdj) {
    adjVertices.put(newAdj.getId(), newAdj);
  }

  public void deleteAdjVertex(Integer deVertexId) {
    if (!adjVertices.containsKey(deVertexId)) {
      throw new NullPointerException("The vertex is not in adjVertices");
    }
    adjVertices.remove(deVertexId);
  }

  public void deleteAdjEdge(Integer deEdgeId) {
    if (!adjEdges.containsKey(deEdgeId)) {
      throw new NullPointerException("The edge is not in adjEdges");
    }
    adjEdges.remove(deEdgeId);
  }

  public void addAdjEdge(Edge newAdjEdge) {
    adjEdges.put(newAdjEdge.getEdgeId(), newAdjEdge);
  }

  /*---------------------------------------------------------*/
  public void print() {
    Set set = adjVertices.keySet();
    Iterator<Integer> itv = set.iterator();
    while (itv.hasNext()) {
      Integer i = itv.next();
      System.out.println(adjVertices.get(i));
    }
  }

/*----------------------------------------------------------*/
}
