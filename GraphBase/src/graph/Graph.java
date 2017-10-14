package graph;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;

public abstract class Graph implements Iterable{

  protected HashMap<Integer, Vertex> vertices;

  public Graph() {
    this.vertices = new HashMap<Integer, Vertex>();
  }

  public boolean addVertex(int newVertexId) {
    return addVertex(new Vertex(newVertexId));
  }

  public boolean addVertex(Vertex newVertex) {
    if (vertices.containsKey(newVertex.getId())) {
      return false;
    }
    vertices.put(newVertex.getId(), newVertex);
    return true;
  }

  public boolean addVertex(Collection<Vertex> vertexCollection) {
    for (Vertex vertex : vertexCollection) {
      addVertex(vertex);
    }
    return true;
  }

  public abstract Vertex deleteVertex(int vertexId);

  public abstract boolean addEdge(int fromId, int toId);

  public abstract boolean addEdge(Vertex fromVertex, Vertex toVertex);

  public abstract boolean addEdge(Edge edge);

  public abstract boolean addEdge(Collection<Edge> edgeCollection);

  public abstract Edge deleteEdge(int fromId, int toId);

  public abstract Edge deleteEdge(Vertex fromVertex, Vertex toVertex);

  public abstract Edge deleteEdge(Edge edge);

  public boolean contains(int id) {
    return vertices.containsKey(id);
  }

  public Vertex getVertex(int id) {
    return vertices.get(id);
  }

  public Collection<Vertex> getVertices() {
    return vertices.values();
  }

  public HashMap<Integer, Vertex> getVerticesMap() {
    return vertices;
  }

  public Collection<Edge> getEdges() {
    Set<Edge> edgeset = new HashSet();
    vertices.values().forEach(v -> v.getAdjEdges().forEach(e -> edgeset.add(e)));
    return edgeset;
  }

  public int size() {
    return vertices.size();
  }

  public Set keySet() {
    return vertices.keySet();
  }

  public TraversalIterator bfsIterator() {
    int startId = (int)keySet().iterator().next();
    return new TraversalIterator(this,0,startId);
  }

  public TraversalIterator bfsIterator(int id) {
    return new TraversalIterator(this,0,id);
  }

  public TraversalIterator dfsIterator() {
    int startId = (int)keySet().iterator().next();
    return new TraversalIterator(this,1,startId);
  }

  public TraversalIterator dfsIterator(int id) {
    return new TraversalIterator(this,1,id);
  }

  public TraversalIterator iterator() {
    return bfsIterator();
  }

  @Override
  public boolean equals(Object obj) {
    Graph graph = (Graph) obj;
    if (graph.vertices.size() != vertices.size()) {
      return false;
    }
    Collection<Vertex> vertexCollection = graph.getVertices();
    for (Vertex v : vertexCollection) {
      if (!contains(v.getId())) {
        return false;
      }
      if (!v.equals(vertices.get(v.getId()))) {
        return false;
      }
    }
    return true;
  }
}
