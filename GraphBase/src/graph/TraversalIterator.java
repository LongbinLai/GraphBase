package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class TraversalIterator implements Iterator {

  private Graph graph;
  private Vertex vertex;
  private HashSet<Integer> unvisited;
  private LinkedList<Integer> qOrS;

  private int type; //0 represents BFS, 1 represents DFS
  private int startId;

  public TraversalIterator(Graph graph, int type, int startId) {
    this.graph = graph;
    this.vertex = null;
    this.type = type;
    this.startId = startId;
    unvisited = new HashSet<>(graph.keySet());
    qOrS = new LinkedList<>();
  }

  public Vertex next() {
    if (vertex == null) {
      vertex = graph.getVertex(startId);
    } else if (qOrS.isEmpty()) {
      if (unvisited.size() == 0) {
        vertex = null;
        return vertex;
      }
      vertex = graph.getVertex(unvisited.iterator().next());
    } else {
      vertex = graph.getVertex(qOrS.pop());
    }
    unvisited.remove(vertex.getId());
    offer(qOrS,vertex.getId());
    return vertex;
  }

  public boolean hasNext() {
    return unvisited.size() == 0 ? false : true;
  }

  public void offer(LinkedList<Integer> l, int vertexId) {
    if (type == 0) {
      graph.getVertex(vertexId).neighbors().forEach(id -> {
        if (unvisited.contains(id) && !qOrS.contains(id)) {
          l.add(id);
        }
      });
    }
    if (type == 1) {
      graph.getVertex(vertexId).neighbors().forEach(id -> {
        if (unvisited.contains(id) && !qOrS.contains(id)) {
          l.push(id);
        }
      });
    }
  }

}
