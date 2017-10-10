package graph;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;


public abstract class Graph implements Cloneable {

  private Map<Integer, Vertex> vertices;

  public Graph() {
    this.vertices = new HashMap<>();
  }

  public Vertex getVertex(int id) {
    return this.vertices.get(id);
  }

  public Collection<Vertex> getVertices() {
    return vertices.values();
  }

  public Collection<Integer> getVertexIDs() {
    return new HashSet<>(vertices.keySet()); // return a copy of the keys
  }

  public Vertex addVertex(Vertex v) {
    if (this.contains(v.getId())) {
      return this.getVertex(v.getId()); // return the existing vertex if the id already exists
    }
    this.vertices.put(v.getId(), v);
    return v;
  }

  public Vertex addVertex(int id) {
    return this.addVertex(new Vertex(id));
  }

  public Vertex removeVertex(int id) {
    return this.vertices.remove(id);
  }

  public abstract Edge addEdge(Edge e);

  public Edge addEdge(int u, int v) {
    return this.addEdge(new Edge(u, v));
  }

  public abstract Edge removeEdge(Edge e);

  public Edge removeEdge(int u, int v) {
    return this.removeEdge(new Edge(u, v));
  }

  public void removeEdges() {
    this.getEdges().forEach(e -> this.removeEdge(e));
  }

  public Collection<Edge> getEdges() {
    Set<Edge> edges = new HashSet<>();
    this.getVertices().forEach(v -> v.getEdges().forEach(e -> edges.add(e)));
    return edges;
  }

  public boolean contains(int id) {
    // test if the graph contains Vertex(id)
    return this.vertices.containsKey(id);
  }

  public int getNumOfVertices() {
    return this.vertices.size();
  }

  public boolean isEmpty() {
    return this.getNumOfVertices() == 0;
  }

  public void clear() {
    this.getVertices().forEach(v -> v.removeNeighbors());
    this.vertices.clear();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    Graph g = (Graph) o;
    if (g.getNumOfVertices() != this.getNumOfVertices()) {
      return false;
    }

    Collection<Vertex> vertices = this.getVertices();
    for (Vertex u : vertices) {
      if (!(g.contains(u.getId()) && g.getVertex(u.getId()).equals(u))) {
        return false;
      }
    }

    return true;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("(").append(this.getClass().getSimpleName()).append(")");

    if (isEmpty()) {
      result.append(" Empty graph");
    } else {
      this.getVertices().forEach(v -> result.append("|").append(v));
    }
    return result.toString();
  }
}
