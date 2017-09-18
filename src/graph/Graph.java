package graph;

import java.util.*;

public class Graph {

  private Map<Integer, Vertex> vertices;
  private String name;

  public Graph() {
    this("unnamed");
  }

  public Graph(String name) {
    this.vertices = new HashMap<>();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Vertex getNode(int id) {
    return this.vertices.get(id);
  }

  public Set<Integer> nodesID() {
    return vertices.keySet();
  }

  public Collection<Vertex> nodes() {
    return vertices.values();
  }

  public Vertex addNode(Vertex v) {
    this.vertices.put(v.getId(), v);
    return v;
  }

  public Vertex addNode(int id) {
    Vertex node = new Vertex(id);
    return this.addNode(node);
  }

  public Vertex addNode() {
    if (this.isEmpty()) {
      return this.addNode(0);
    }
    int max_id = Collections.max(this.vertices.keySet());
    return this.addNode(max_id + 1);
  }

  public void removeNode(int id) {
    for (Vertex v : this.nodes()) {
      v.removeNeighbor(id);
    }
    this.vertices.remove(id);
  }

  public void removeNode(Vertex v) {
    this.removeNode(v.getId());
  }

  public void addEdge(Vertex node_u, Vertex node_v) {
    node_u.addNeighbor(node_v);
    node_v.addNeighbor(node_u);
  }

  public void addEdge(int u, int v) {
    Vertex node_u = this.vertices.get(u);
    Vertex node_v = this.vertices.get(v);
    if (node_u == null) {
      node_u = this.addNode(u);
    }
    if (node_v == null) {
      node_v = this.addNode(v);
    }
    this.addEdge(node_u, node_v);
  }

  public void addEdge(Edge e) {
    this.addEdge(e.getStart(), e.getEnd());
  }

  public void removeEdge(int u, int v) {
    Vertex node_u = this.getNode(u);
    Vertex node_v = this.getNode(v);
    node_u.removeNeighbor(v);
    node_v.removeNeighbor(u);
  }

  public void removeEdge(Vertex node_u, Vertex node_v) {
    this.removeEdge(node_u.getId(), node_v.getId());
  }

  public void removeEdge(Edge e) {
    this.removeEdge(e.getStart().getId(), e.getEnd().getId());
  }

  public List<Edge> edges() {
    List<Edge> result = new ArrayList<>();
    for (Vertex v : this.nodes()) {
      for (Vertex u : v.getNeighbors()) {
        if (v.getId() < u.getId()) {
          result.add(new Edge(v, u));
        }
      }
    }
    return result;
  }

  public Map<Integer, Integer> degrees() {
    Map<Integer, Integer> result = new HashMap<>();
    for (Vertex n : this.vertices.values()) {
      result.put(n.getId(), n.degree());
    }
    return result;
  }

  public int size() {
    return this.vertices.size();
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public void empty() {
    for (Vertex n : this.vertices.values()) {
      n.removeNeighbors();
    }
    this.vertices.clear();
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("Graph: ");
    result.append(this.getName());
    result.append("\n");

    if (isEmpty()) {
      result.append("  Empty graph");
    } else {
      for (Vertex v : this.nodes()) {
        result.append(v.toString());
      }
    }
    return result.toString();
  }
}