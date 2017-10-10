package graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class BfsIterator implements Iterator{
  Map<Integer,Vertex> vertices;
  Vertex vertex;
  int startId;
  private HashSet<Integer> visited;
  private LinkedList<Integer> q;
  public BfsIterator(Graph graph) {
    this.vertices = graph.getVerticesMap();
    vertex = null;
    visited = new HashSet<>();
    q = new LinkedList<>();
    startId = (Integer)Collections.min(graph.keySet());
  }
  public BfsIterator(Graph graph, int id) {
    this.vertices = graph.getVerticesMap();
    vertex = null;
    visited = new HashSet<>();
    q = new LinkedList<>();
    startId = id;
  }

  public Vertex next() {
    if (vertex == null) {
      vertex = vertices.get(startId);
      visited.add(startId);
      q.addAll(vertex.neighbors());
      return vertex;
    }
    if (q.isEmpty()) {
      if (visited.size() == vertices.size()) {
        vertex = null;
        return null;
      }
      for (int id : vertices.keySet()) {
        if (!visited.contains(id)) {
          q.addAll(vertices.get(id).neighbors());
          visited.add(id);
          return vertex = vertices.get(id);
        }
      }
    }
    vertex = vertices.get(q.pop());
    visited.add(vertex.getId());
    vertex.neighbors().forEach(id -> {
      if (!visited.contains(id) && !q.contains(id))
        q.add(id);
    });
    return vertex;
  }

  public boolean hasNext() {
    return visited.size() == vertices.size() ? false : true;
  }
}
