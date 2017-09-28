package graph;

public class Edge {

  private int begin;
  private int end;

  public Edge(int begin, int end) {
    this.begin = begin;
    this.end = end;
  }

  public int getBegin() {
    return begin;
  }

  public void setBegin(int begin) {
    this.begin = begin;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public Edge copy() {
    return new Edge(this.getBegin(), this.getEnd());
  }

  public void reverse() {
    int start = this.getBegin();
    int end = this.getEnd();
    this.setBegin(end);
    this.setEnd(start);
  }

  public Edge reversed() {
    Edge e = this.copy();
    e.reverse();
    return e;
  }

  @Override
  public String toString() {
    return "(" + begin + "," + end + ")";
  }
}
