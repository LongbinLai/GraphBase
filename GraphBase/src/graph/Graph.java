package graph;

import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;

public abstract class Graph {

  protected Map<Integer, Vertex> vertices;

  public Graph() {
    this.vertices = new HashMap<Integer, Vertex>();
  }

  public void addVertex(int newVertexId) {
    Vertex newVertex = new Vertex(newVertexId);
    vertices.put(newVertex.getId(), newVertex);
  }

  public void addVertex(Vertex newVertex) {
    if (vertices.keySet().contains(newVertex.getId())) {
      System.out.println("The vertex has already been exsited");
    }
  }

  public void deleteVertex(int vertexId) {
    if (!vertices.containsKey(vertexId)) {
      throw new NoSuchElementException("The vertex id is not existed");
    }
    vertices.remove(vertexId);
    for (Integer key : vertices.keySet()) {
      if (vertices.get(key).getAdjEdges().keySet().contains(vertexId)) {
        vertices.get(key).getAdjEdges().remove(vertexId);
      }
    }
  }

  public void deleteVertex(Vertex vertex) {
    deleteVertex(vertex.getId());
  }

  public void addEdge(int fromId, int toId) {
    if (fromId == toId) {
      System.out.println("Loop is not allowed");
      return;
    }
    if (!vertices.containsKey(fromId)) {
      addVertex(fromId);
    }
    if (!vertices.containsKey(toId)) {
      addVertex(toId);
    }
    if (!this.vertices.get(fromId).isAdjacent(toId)) {
      Edge newEdge = new Edge(fromId, toId);
      this.vertices.get(fromId).addAdjEdge(newEdge);
    }
  }

  public void addEdge(Vertex fromVertex, Vertex toVertex) {
    if (fromVertex.getId() == toVertex.getId()) {
      System.out.println("Loop is not allowed");
      return;
    }
    if (!vertices.containsKey(fromVertex.getId())) {
      vertices.put(fromVertex.getId(), fromVertex);
    }
    if (!vertices.containsKey(toVertex.getId())) {
      vertices.put(toVertex.getId(), toVertex);
    }
    if (!fromVertex.getAdjEdges().containsKey(toVertex.getId())) {
      Edge newEdge = new Edge(fromVertex.getId(), toVertex.getId());
      fromVertex.addAdjEdge(newEdge);
    }
  }

  public void addEdge(Edge edge) {
    Vertex fromVertex;
    Vertex toVertex;
    if (!vertices.keySet().contains(edge.getFromId())) {
      fromVertex = new Vertex(edge.getFromId());
    } else {
      fromVertex = vertices.get(edge.getFromId());
    }
    if (!vertices.keySet().contains(edge.getToId())) {
      toVertex = new Vertex(edge.getToId());
    } else {
      toVertex = vertices.get(edge.getToId());
    }
    addEdge(fromVertex, toVertex);
  }

  public void deleteEdge(int fromId, int toId) {
    if (!vertices.get(fromId).getAdjEdges().keySet().contains(toId)) {
      throw new NoSuchElementException("The edge is not existed");
    }
    vertices.get(fromId).getAdjEdges().remove(toId);
  }

  public void deleteEdge(Vertex fromVertex, Vertex toVertex) {
    deleteEdge(fromVertex.getId(), toVertex.getId());
  }

  public void deleteEdge(Edge edge) {
    if (!vertices.keySet().contains(edge.getFromId())) {
      throw new NoSuchElementException("The edge is not existed");
    }
    if (!vertices.keySet().contains(edge.getToId())) {
      throw new NoSuchElementException("The edge is not existed");
    }
    vertices.get(edge.getFromId()).deleteAdjEdge(edge.getToId());
  }

  public Map<Integer, Vertex> getVertices() {
    return vertices;
  }
}
