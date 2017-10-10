package graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class DfsIterator implements Iterator {
  Map<Integer,Vertex> vertices;
  Vertex vertex;
  int startId;
  private HashSet<Integer> visited;
  private Stack<Integer> s;
  public DfsIterator(Graph graph) {
    this.vertices = graph.getVerticesMap();
    vertex = null;
    visited = new HashSet<>();
    s = new Stack<>();
    startId = (Integer) Collections.min(graph.keySet());
  }
  public DfsIterator(Graph graph, int id) {
    this.vertices = graph.getVerticesMap();
    vertex = null;
    visited = new HashSet<>();
    s = new Stack<>();
    startId = id;
  }

  public Vertex next() {
    if (vertex == null) {
      vertex = vertices.get(startId);
      visited.add(startId);
      s.addAll(vertex.neighbors());
      return vertex;
    }
    if (s.isEmpty()) {
      if (visited.size() == vertices.size()) {
        vertex = null;
        return null;
      }
      for (int id : vertices.keySet()) {
        if (!visited.contains(id)) {
          s.addAll(vertices.get(id).neighbors());
          visited.add(id);
          return vertex = vertices.get(id);
        }
      }
    }
    vertex = vertices.get(s.pop());
    visited.add(vertex.getId());
    vertex.neighbors().forEach(id -> {
      if (!visited.contains(id) && !s.contains(id))
        s.push(id);
    });
    return vertex;
  }

  public boolean hasNext() {
    return visited.size() == vertices.size() ? false : true;
  }
}
