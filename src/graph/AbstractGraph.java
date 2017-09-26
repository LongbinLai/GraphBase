package graph;

import java.util.*;


public abstract class AbstractGraph {

  private Map<Integer, Vertex> vertices;

  public AbstractGraph() {
    this.vertices = new HashMap<>();
  }

  public Vertex getNode(int id) {
    return this.vertices.get(id);
  }

  public Set<Integer> getNodesID() {
    return vertices.keySet();
  }

  public Collection<Vertex> getNodes() {
    return vertices.values();
  }

  public Vertex addNode(Vertex v) {
    if (this.contains(v)) {
      return this.getNode(v.getId());
    }
    this.vertices.put(v.getId(), v);
    return v;
  }

  public Vertex addNode(int id) {
    return this.addNode(new Vertex(id));
  }

  public Vertex addNode() {
    if (this.isEmpty()) {
      return this.addNode(0);
    }
    int maxId = Collections.max(this.vertices.keySet());
    return this.addNode(maxId + 1);
  }

  public Vertex removeNode(int id) {
    return this.vertices.remove(id);
  }

  public Vertex removeNode(Vertex v) {
    return this.removeNode(v.getId());
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

  public Set<Edge> getEdges() {
    Set<Edge> edges = new HashSet<>();
    for (Vertex v : this.getNodes()) {
      for (Edge edge : v.getEdges()) {
        edges.add(edge);
      }
    }
    return edges;
  }

  public boolean contains(int id) {
    return this.vertices.containsKey(id);
  }

  public boolean contains(Vertex v) {
    return this.contains(v.getId());
  }

  public int size() {
    return this.vertices.size();
  }

  public int getNumOfEdges() {
    return this.getEdges().size();
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public void clear() {
    for (Vertex v : this.getNodes()) {
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
      for (Vertex v : this.getNodes()) {
        result.append(v.toString());
      }
    }
    return result.toString();
  }
}
