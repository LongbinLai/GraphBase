package Graph;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

public abstract class Graph {

  private Map<Integer, Vertex> vertices;

  public Graph() {
    this.vertices = new HashMap<>();
  }

  public Vertex getVertex(int id) {
    return this.vertices.get(id);
  }

  // get all the vertices in the graph
  public Collection<Vertex> getAllVertices() {
    return this.vertices.values();
  }

  // get all the edges in the graph
  public Set<Edge> getAllEdges() {
    Set<Edge> edges = new HashSet<>();
    for (Vertex v : this.getAllVertices()) {
      for (Edge e : v.getEdges()) {
        edges.add(e);
      }
    }
    return edges;
  }

  // add a vertex to the graph
  public Vertex addVertex(Vertex v) {
    if (!vertices.containsKey(v.getVertexId())) { // if vertex v is not in the graph, then add it.
      vertices.put(v.getVertexId(), v);
    } else {
      return this.getVertex(v.getVertexId());
    }
    return v;
  }

  public Vertex addVertex(int v) {
    return addVertex(new Vertex(v));
  }

  // add an edge to the graph
  public abstract Edge addEdge(Edge e);

  public Edge addEdge(int u, int v) {
    return this.addEdge(new Edge(u, v));
  }

  // remove an edge in the graph
  public abstract Edge rmvEdge(Edge e);

  public Edge rmvEdge(int u, int v) {
    return this.rmvEdge(new Edge(u, v));
  }

  // remove a vertex in the graph
  public void rmvVertex(Vertex v) {
    this.vertices.remove(v.getVertexId());
  }

  public void rmvVertex(int v) {
    rmvVertex(new Vertex(v));
  }

}
