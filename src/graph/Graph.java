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

  public Vertex get_node(int id) {
    return this.vertices.get(id);
  }

  public Set<Integer> node_ids() {
    return vertices.keySet();
  }

  public Collection<Vertex> nodes() {
    return vertices.values();
  }

  public Vertex add_node(Vertex v) {
    this.vertices.put(v.getId(), v);
    return v;
  }

  public Vertex add_node(int id) {
    Vertex node = new Vertex(id);
    return this.add_node(node);
  }

  public Vertex add_node() {
    if (this.is_empty()) {
      return this.add_node(0);
    }
    int max_id = Collections.max(this.vertices.keySet());
    return this.add_node(max_id + 1);
  }

  public void remove_node(int id) {
    for (Vertex v : this.nodes()) {
      v.remove_neighbor(id);
    }
    this.vertices.remove(id);
  }

  public void remove_node(Vertex v) {
    this.remove_node(v.getId());
  }

  public void add_edge(Vertex node_u, Vertex node_v) {
    node_u.add_neighbor(node_v);
    node_v.add_neighbor(node_u);
  }

  public void add_edge(int u, int v) {
    Vertex node_u = this.vertices.get(u);
    Vertex node_v = this.vertices.get(v);
    if (node_u == null) {
      node_u = this.add_node(u);
    }
    if (node_v == null) {
      node_v = this.add_node(v);
    }
    this.add_edge(node_u, node_v);
  }

  public void add_edge(Edge e) {
    this.add_edge(e.getStart(), e.getEnd());
  }

  public void remove_edge(int u, int v) {
    Vertex node_u = this.vertices.get(u);
    Vertex node_v = this.vertices.get(v);
    node_u.remove_neighbor(v);
    node_v.remove_neighbor(u);
  }

  public void remove_edge(Vertex node_u, Vertex node_v) {
    this.remove_edge(node_u.getId(), node_v.getId());
  }

  public void remove_edge(Edge e) {
    this.remove_edge(e.getStart().getId(), e.getEnd().getId());
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

  public boolean is_empty() {
    return this.size() == 0;
  }

  public void empty() {
    for (Vertex n : this.vertices.values()) {
      n.remove_neighbors();
    }
    this.vertices.clear();
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("Graph: ");
    result.append(this.getName());
    result.append("\n");

    if (is_empty()) {
      result.append("  Empty graph");
    } else {
      for (Vertex v : this.nodes()) {
        result.append(v.toString());
      }
    }
    return result.toString();
  }
}