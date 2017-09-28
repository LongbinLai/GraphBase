package graph;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;


public abstract class Graph {

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
    for (Edge e : this.getEdges()) {
      this.removeEdge(e);
    }
  }

  public Collection<Edge> getEdges() {
    Set<Edge> edges = new HashSet<>();
    for (Vertex v : this.getVertices()) {
      for (Edge edge : v.getEdges()) {
        edges.add(edge);
      }
    }
    return edges;
  }

  public boolean contains(int id) {
    return this.vertices.containsKey(id);
  }

  public int getNumOfVertices() {
    return this.vertices.size();
  }

  public boolean isEmpty() {
    return this.getNumOfVertices() == 0;
  }

  public void clear() {
    for (Vertex v : this.getVertices()) {
      v.removeNeighbors();
    }
    this.vertices.clear();
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("Graph: \n");

    if (isEmpty()) {
      result.append("  Empty graph");
    } else {
      for (Vertex v : this.getVertices()) {
        result.append(v.toString());
      }
    }
    return result.toString();
  }
}
