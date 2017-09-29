package graph;


public class Edge implements Cloneable {

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

  public void reverse() {
    int start = this.getBegin();
    int end = this.getEnd();
    this.setBegin(end);
    this.setEnd(start);
  }

  public Edge reversed() {
    Edge e = (Edge) this.clone();
    e.reverse();
    return e;
  }

  @Override
  public Object clone() {
    return new Edge(this.getBegin(), this.getEnd());
  }

  @Override
  public String toString() {
    return "(" + begin + "," + end + ")";
  }
}
