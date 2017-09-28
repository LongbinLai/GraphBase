package graph;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Set;

public class Vertex {

  private int id;
  private Map<Integer, Edge> adjEdges; //the Map is indexed with the edge's destination node id


  public Vertex(int id) {
    this.id = id;
    this.adjEdges = new HashMap<>();
  }

  public Edge addEdge(Edge e) {
    int u = e.getBegin();
    int v = e.getEnd();
    if (this.getId() == u) {
      this.adjEdges.put(v, e);
    } else if (this.getId() == v) {
      this.adjEdges.put(u, e);
    } else {
      return null; //return null if fail to add
    }
    return e;
  }

  public int getId() {
    return id;
  }

  public Edge addNeighbor(int id) {
    return this.addEdge(new Edge(this.getId(), id));
  }

  public boolean isAdjTo(int id) {
    return this.adjEdges.containsKey(id);
  }

  public Collection<Edge> getEdges() {
    return this.adjEdges.values();
  }

  public Set<Integer> getNeighbors() {
    return this.adjEdges.keySet();
  }

  public Edge removeNeighbor(int id) {
    return this.adjEdges.remove(id);
  }

  public void removeNeighbors() {
    this.adjEdges.clear();
  }

  public int getDegree() {
    return adjEdges.size();
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("Node: ");
    result.append(this.getId());
    result.append("\n  - Neighbors: ");

    for (int v : this.getNeighbors()) {
      result.append(v);
      result.append(", ");
    }
    result.append("\n");
    return result.toString();
  }
}
