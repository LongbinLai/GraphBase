package graph;

import java.util.*;

public class Vertex {

  private int id;
  private Map<Integer, Vertex> neighbors;


  public Vertex(int id) {
    this.id = id;
    this.neighbors = new HashMap<>();
  }

  public int getId() {
    return id;
  }

  public Collection<Vertex> getNeighbors() {
    return neighbors.values();
  }

  public void addNeighbor(Vertex v) {
    if (this.getId() != v.getId()) {
      this.neighbors.put(v.getId(), v);
    }
  }

  public void removeNeighbor(Vertex v) {
    this.removeNeighbor(v.getId());
  }

  public void removeNeighbor(int id) {
    this.neighbors.remove(id);
  }

  public void removeNeighbors() {
    for (int id : this.neighbors.keySet()) {
      this.removeNeighbor(id);
    }
  }

  public int degree() {
    return neighbors.size();
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
