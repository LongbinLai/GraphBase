package graph;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Set;

public class Vertex implements Cloneable {

  private int id;
  private Map<Integer, Edge> adjEdges; //the Map is indexed with the edge's destination node id


  public Vertex(int id) {
    this.id = id;
    this.adjEdges = new HashMap<>();
  }

  public int getId() {
    return id;
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

  public Edge addNeighbor(int id) {
    return this.addEdge(new Edge(this.getId(), id));
  }

  public boolean isAdjTo(int id) {
    return this.adjEdges.containsKey(id);
  }

  public boolean hasEdge(Edge e) {
    int u = e.getBegin();
    int v = e.getEnd();
    int adj;
    if (this.getId() == u) {
      adj = v;
    } else if (this.getId() == v) {
      adj = u;
    } else {
      return false;
    }

    return (this.isAdjTo(adj) && this.getEdge(adj).equals(e));
  }

  public Edge getEdge(int id) {
    return this.adjEdges.get(id);
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    Vertex v = (Vertex) o;

    if (id != v.id) {
      return false;
    }

    if (v.getDegree() != this.getDegree()) {
      return false;
    }

    Collection<Edge> edges = this.getEdges();
    for (Edge e : edges) {
      if (!v.hasEdge(e)) {
        return false;
      }
    }

    return true;
  }

  @Override
  public Object clone() {
    // make a deep copy of the Vertex object
    Vertex v = new Vertex(this.getId());
    for (Edge e : this.getEdges()) {
      v.addEdge((Edge) e.clone());
    }
    return v;
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
