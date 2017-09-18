package graph;

import java.util.*;

public class DiGraph extends Graph {

  @Override
  public void addEdge(Vertex node_u, Vertex node_v) {
    node_u.addNeighbor(node_v);
  }

  @Override
  public void removeEdge(int u, int v) {
    Vertex node_u = this.getNode(u);
    node_u.removeNeighbor(v);
  }

  @Override
  public List<Edge> edges() {
    List<Edge> result = new ArrayList<>();
    for (Vertex v : this.nodes()) {
      for (Vertex u : v.getNeighbors()) {
        result.add(new Edge(v, u));
      }
    }
    return result;
  }

  public Map<Integer, Integer> inDegrees() {
    Map<Integer, Integer> result = new HashMap<>();
    for (int id : super.nodesID()){
      result.put(id,0);
    }
    for (Vertex v : super.nodes()) {
      for (Vertex n : v.getNeighbors()) {
        result.put(n.getId(), result.get(n.getId()) + 1);
      }
    }
    return result;
  }

  public Map<Integer, Integer> outDegrees() {
    return super.degrees();
  }
}
