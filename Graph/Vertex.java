package Graph;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class Vertex {
  private int vertexId;
  private Map<Integer, Edge> arrEdges;

  // constructor of Vertex. In this code, we use array of edges to represent the graph.
  public Vertex(int id) {
    this.vertexId = id;
    this.arrEdges = new HashMap<Integer, Edge>();
  }

  // get parameters of Vertex
  public int getVertexId() {
    return this.vertexId;
  }

  // add edge e in the graph.
  public Edge addEdge(Edge e) {
    int start = e.getStart();
    int end = e.getEnd();
    if (start == this.vertexId && !arrEdges.containsValue(e)) {
      this.arrEdges.put(end, e);
    } else if (end == this.vertexId && !arrEdges.containsValue(e)) {
      this.arrEdges.put(start, e);
    } else {
      return null; // return null if adding edge fails
    }
    return e;
  }

  // remove edge in the graph.
  public Edge rmvEdge(Edge e) {
    int start = e.getStart();
    int end = e.getEnd();
    if (start == this.vertexId) {
      this.arrEdges.remove(end);
    } else if (end == this.vertexId) {
      this.arrEdges.remove(start);
    } else {
      return null; // return null if removing fails
    }
    return e;
  }

  // if this vertex is adjacent to vertex id
  public boolean isAdjacentTo(int id) {
    return this.arrEdges.containsKey(id);
  }

  // get all adjacent vertices with respect to this vertex
  public Collection<Integer> getNeighbours() {
    return this.arrEdges.keySet();
  }

  // get all edges related to this vertex
  public Collection<Edge> getEdges() {
    return this.arrEdges.values();
  }

}
