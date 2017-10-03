package graph;

public class Edge implements Cloneable {

  private int fromId;
  private int toId;

  public Edge(int from, int to) {
    fromId = from;
    toId = to;
  }

  public int getTo() {
    return toId;
  }

  public int getFrom() {
    return fromId;
  }

  @Override
  public Edge clone() {
    return new Edge(fromId, toId);
  }

}
