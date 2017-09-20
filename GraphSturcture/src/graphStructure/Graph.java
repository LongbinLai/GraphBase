package graphStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph {

  private Map<Integer, Vertex> vertices;
  private Map<Integer, Edge> edges;
  private Queue<Integer> unusedVertexId;// to store the id which is not used,"for example ,when a vertex is deleted"
  private Queue<Integer> unusedEdgeId;//similar to unusedVertexId

  private int maxVertexId;
  private int maxEdgeId;

  public enum TYPE {
    DIRECTED, UNDIRECTED
  }

  private TYPE type;/*This is to implicit that weather the graph is undirected or directed,
  ,in this version all the graph is treated as undiregted graph*/

  public Graph() {
    this.vertices = new HashMap<Integer, Vertex>();
    this.edges = new HashMap<Integer, Edge>();
    this.unusedVertexId = new LinkedList<Integer>();
    this.unusedEdgeId = new LinkedList<Integer>();
    this.maxVertexId = 0;
    this.maxEdgeId = 0;
    this.type = TYPE.UNDIRECTED;
  }

  public Graph(Integer graphSize) {
    this();
    for (int i = 1; i < graphSize + 1; i++) {
      this.addVertex();
    }
  }

  public Map<Integer, Vertex> getVertices() {
    return vertices;
  }

  public Map<Integer, Edge> getEdges() {
    return edges;
  }

  private int firstVertexIdUnused() {
    int unusedId;
    if (unusedVertexId.size() != 0) {
      unusedId = unusedVertexId.poll();
    } else {
      maxVertexId++;
      unusedId = maxVertexId;
    }
    return unusedId;
  }

  private int firstEdgeIdUnused() {
    int unusedId;
    if (unusedEdgeId.size() != 0) {
      unusedId = unusedEdgeId.poll();
    } else {
      maxEdgeId++;
      unusedId = maxEdgeId;
    }
    return unusedId;
  }

  public void addVertex() {
    Integer newVertexId = new Integer(firstVertexIdUnused());
    Vertex newVertex = new Vertex(newVertexId);
    vertices.put(newVertex.getId(), newVertex);
  }

  public void deleteVertex(int deVertexId) {
    if (!vertices.containsKey(deVertexId)) {
      throw new NullPointerException("The vertex id is not existed");
    }

    /** *The foreach loop traverse all the edges connected with the deleted vertex,and delete the deleted vertex's Id from all of its
     adjacent vertices,and delete all edges connectting the deleted vertices and its adjacent vetices(These edges will be removed not only
     from the HashMap "edges" ,but also be removed from the deleted vertex's adjacent vertices's HashMap"adjEdges")* **/
    for (Object key : vertices.get(deVertexId).getAdgEdges().keySet()) {
      Integer adjVerId =
          edges.get(key).getFrom().getId().intValue() == deVertexId ? edges.get(key).getTo().getId()
              : edges.get(key).getFrom()
                  .getId();//to determine wether the adjVertex is the FromVertex of The edge or the ToVertex of the edge.
      vertices.get(adjVerId).deleteAdjVertex(deVertexId);//
      vertices.get(adjVerId).deleteAdjEdge(Integer.parseInt(key.toString()));
      edges.remove(key);
      unusedEdgeId.add(Integer.parseInt(key.toString()));
    }
    vertices.remove(deVertexId);
    unusedVertexId.add(deVertexId);
  }

  public void addEdge(Integer fromId, Integer toId) {
    if (fromId == toId) {
      System.out.println("Loop is not allowed");
      return;
    }
    if (!vertices.containsKey(fromId)) {
      System.out.println("The fromVertex is not existed");
    }
    if (!vertices.containsKey(toId)) {
      System.out.println("The toVertex is not existed");
    }
    if (!this.vertices.get(fromId).isAdjacent(toId)) {
      this.vertices.get(fromId).addAdjVertex(vertices.get(toId));
    }
    if (!this.vertices.get(toId).isAdjacent(fromId)) {
      this.vertices.get(toId).addAdjVertex(vertices.get(fromId));
    }
    Integer newEdgeId = new Integer(firstEdgeIdUnused());
    Edge newEdge = new Edge(newEdgeId, vertices.get(fromId), vertices.get(toId));
    edges.put(newEdgeId, newEdge);
    vertices.get(fromId).addAdjEdge(newEdge);
    vertices.get(toId).addAdjEdge(newEdge);
  }

  private void deleteEdge(Integer deEdgeId) {
    if (!edges.containsKey(deEdgeId)) {
      throw new NullPointerException("The edge id is not existed");
    }
    Integer fromVertexId = edges.get(deEdgeId).getFrom().getId();
    Integer toVertexId = edges.get(deEdgeId).getTo().getId();
    vertices.get(fromVertexId).deleteAdjVertex(toVertexId);
    vertices.get(toVertexId).deleteAdjVertex(fromVertexId);
    vertices.get(fromVertexId).deleteAdjEdge(deEdgeId);
    vertices.get(toVertexId).deleteAdjEdge(deEdgeId);
    edges.remove(deEdgeId);
    unusedEdgeId.add(deEdgeId);
  }

  public void deleteEdge(int fromVertexId, int toVertexId) {
    if (!vertices.containsKey(fromVertexId)) {
      throw new NullPointerException("The FromVertex is not existed");
    }
    if (!vertices.containsKey(toVertexId)) {
      throw new NullPointerException("The ToVertex is not existed");
    }
    for (Integer key : edges.keySet()) {
      if (key == 5) {
        Integer i = 1;
      }
      if (edges.get(key).getFrom().getId().intValue() == fromVertexId
          && edges.get(key).getTo().getId().intValue() == toVertexId) {
        deleteEdge(key);
        unusedEdgeId.add(key);
        return;
      }
      if (edges.get(key).getFrom().getId().intValue() == toVertexId &&
          edges.get(key).getTo().getId().intValue() == fromVertexId) {
        deleteEdge(key);
        unusedEdgeId.add(key);
        return;
      }
    }
    throw new NullPointerException("The edge is not existed");
  }

  private void addVertex(Vertex newVertex) {
    Integer newId = firstVertexIdUnused();
    newVertex.setId(newId);
    vertices.put(newId, newVertex);
  }

  private void addEdge(Vertex fromVertex, Vertex toVertex) {
    if (!vertices.containsKey(fromVertex.getId())) {
      System.out.println("fromvertex is not exited.");
    }
    if (!vertices.containsKey(toVertex.getId())) {
      System.out.println("tovertex is not existed.");
    }
    addEdge(fromVertex.getId(), toVertex.getId());
  }

  /*------------------------------------------------------*/
  public void printVertex(Integer k) {
    System.out.println("the" + k.toString() + "th vertex");
    vertices.get(k).print();
  }

  public void printAllVertex() {
    for (int i = 0; i < vertices.size(); i++) {
      printVertex(i);
    }
  }
}
