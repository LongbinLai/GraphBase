package graph;

public class UnDiGraph extends Graph {

  @Override
  public void addEdge(int fromId, int toId) {
    super.addEdge(fromId, toId);
    super.addEdge(toId, fromId);
  }

  @Override
  public void addEdge(Edge edge) {
    Edge reedge = new Edge(edge.getToId(), edge.getFromId());
    super.addEdge(edge);
    super.addEdge(reedge);
  }

  @Override
  public void deleteEdge(int fromId, int toId) {
    /*super.deleteEdge(fromId,toId);
    vertices.get(toId).getAdjEdges().remove(fromId);*/
    super.deleteEdge(fromId, toId);
    super.deleteEdge(toId, fromId);
  }

  @Override
  public void deleteEdge(Vertex fromVertex, Vertex toVertex) {
    deleteEdge(fromVertex.getId(), toVertex.getId());
    /*super.deleteEdge(fromVertex,toVertex);
    super.deleteEdge(toVertex,fromVertex);*/
  }

  @Override
  public void deleteEdge(Edge edge) {
    super.deleteEdge(edge);
    vertices.get(edge.getToId()).deleteAdjEdge(edge.getFromId());
  }
}
