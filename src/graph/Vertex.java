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

  public void add_neighbor(Vertex v) {
    if (this.getId() != v.getId()) {
      this.neighbors.put(v.getId(), v);
    }
  }

  public void remove_neighbor(Vertex v) {
    this.remove_neighbor_by_id(v.getId());
  }

  public void remove_neighbor_by_id(int id) {
    this.neighbors.remove(id);
  }

  public void remove_neighbors() {
    for (int id : this.neighbors.keySet()) {
      this.remove_neighbor_by_id(id);
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
