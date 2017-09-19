package graph;

import java.util.*;

public class DiGraph extends Graph {

  private Map<Integer, Integer> inDegrees;

  public DiGraph() {
    this("unnamed");
  }

  public DiGraph(String name) {
    super(name);
    this.inDegrees = new HashMap<>();
  }

  @Override
  public Vertex addNode(Vertex v) {
    this.inDegrees.put(v.getId(), 0);
    return super.addNode(v);
  }

  @Override
  public void addEdge(Vertex node_u, Vertex node_v) {
    node_u.addNeighbor(node_v);
    this.inDegrees.put(node_v.getId(), this.getInDegree(node_v.getId()) + 1);
  }

  @Override
  public void removeEdge(int u, int v) {
    Vertex node_u = this.getNode(u);
    node_u.removeNeighbor(v);
    this.inDegrees.put(v, this.getInDegree(v) - 1);
  }

  @Override
  public List<Edge> getEdges() {
    List<Edge> result = new ArrayList<>();
    for (Vertex v : this.getNodes()) {
      for (Vertex u : v.getNeighbors()) {
        result.add(new Edge(v, u));
      }
    }
    return result;
  }

  public Map<Integer, Integer> getInDegrees() {
    return this.inDegrees;
  }

  public int getInDegree(int id) {
    return this.getInDegrees().get(id);
  }

  public int getInDegree(Vertex v) {
    return this.getInDegree(v.getId());
  }

  public Map<Integer, Integer> getOutDegrees() {
    return super.getDegrees();
  }

  public int getOutDegree(int id) {
    return super.getDegree(id);
  }

  public int getOutDegree(Vertex v) {
    return super.getDegree(v);
  }

  @Override
  public DiGraph copy() {
    DiGraph g = new DiGraph();
    for (Edge e : this.getEdges()) {
      g.addEdge(e);
    }
    return g;
  }

  @Override
  public boolean isDirected() {
    return true;
  }
}
