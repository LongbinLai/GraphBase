package graph;

import java.util.Collection;
import java.lang.Cloneable;

public class DirectedGraph extends Graph implements Cloneable{

  public Vertex deleteVertex(int vertexIndex) {
    Vertex deletedVertex = vertices.remove(vertexIndex);
    if (deletedVertex != null) {
      for (Integer key : vertices.keySet()) {
        vertices.get(key).deleteAdjEdge(vertexIndex);
      }
    }
    return deletedVertex;
  }

  public Vertex deleteVertex(Vertex vertex)  {
    return deleteVertex(vertex.getId());
  }

  public boolean addEdge(int fromId, int toId) {
    Edge newEdge = new Edge(fromId,toId);
    return addEdge(newEdge);
  }

  public boolean addEdge(Vertex fromVertex, Vertex toVertex) {
    return addEdge(fromVertex.getId(), toVertex.getId());
  }

  public boolean addEdge(Edge edge) {
    //return addEdge(edge.getFromId(), edge.getToId());
    int fromId = edge.getFromId();
    int toId = edge.getToId();
    addVertex(fromId);
    addVertex(toId);
    if (this.vertices.get(fromId).isAdjacent(toId)) {
      return false;// 0 represents the edge is not existed , otherwise return 1;
    }
    this.vertices.get(fromId).addFromAdjEdge(edge);
    return true;

  }

  public boolean addEdge(Collection<Edge> edgeCollection) {
    for (Edge edge : edgeCollection) {
      if ( !addEdge(edge) ) {
        return false;
      }
    }
    return true;
  }

  public Edge deleteEdge(int fromId, int toId) {
    return vertices.get(fromId).deleteAdjEdge(toId);
  }

  public Edge deleteEdge(Vertex fromVertex, Vertex toVertedx) {
    return deleteEdge(fromVertex.getId(), toVertedx.getId());
  }

  public Edge deleteEdge(Edge edge) {
    return deleteEdge(edge.getFromId(), edge.getToId());
  }

  public DirectedGraph clone() {
    Collection<Edge> edgeCollection = getEdges();
    DirectedGraph newGraph = new DirectedGraph();
    for (Integer vertexId : vertices.keySet()) {
      newGraph.addVertex(vertexId);
    }
    for (Edge edge : edgeCollection) {
      newGraph.addEdge(edge.getFromId(),edge.getToId());
    }
    return newGraph;
  }

}

