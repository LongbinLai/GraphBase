package graph;

public class Edge implements Cloneable{

  private int fromId;
  private int toId;

  public Edge(int from, int to) {
    fromId = from;
    toId = to;
  }

  public int getToId() {
    return toId;
  }

  public int getFromId() {
    return fromId;
  }

  public Edge clone(){
    return new Edge(fromId,toId);
  }

}
