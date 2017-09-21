package graph;

import java.util.*;

public class Vertex {

  private int id;
  private Map<Integer, Edge> edges;


  public Vertex(int id) {
    this.id = id;
    this.edges = new HashMap<>();
  }

  public int getId() {
    return id;
  }

  public Edge addNeighbor(Vertex v) {
    if (this.getId() != v.getId()) {
      Edge e = new Edge(this, v);
      this.edges.put(v.getId(), e);
      return e;
    }
    return null;
  }

  public Collection<Edge> getEdges() {
    return this.edges.values();
  }

  public List<Vertex> getNeighbors() {
    List<Vertex> neighbors = new LinkedList<>();
    for (Edge e : this.getEdges()) {
      neighbors.add(e.getEnd());
    }
    return neighbors;
  }

  public void removeNeighbor(int id) {
    this.edges.remove(id);
  }

  public void removeNeighbor(Vertex v) {
    this.removeNeighbor(v.getId());
  }

  public void removeNeighbors() {
    for (int id : this.edges.keySet()) {
      this.removeNeighbor(id);
    }
  }

  public int getDegree() {
    return edges.size();
  }


  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("Node: ");
    result.append(this.getId());
    result.append("\n  - Neighbors: ");

    for (Vertex v : this.getNeighbors()) {
      result.append(v.getId());
      result.append(", ");
    }
    result.append("\n");
    return result.toString();
  }
}
