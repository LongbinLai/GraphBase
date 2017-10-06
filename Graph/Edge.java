package Graph;

public class Edge {

  private int start;
  private int end;
  private float weight;

  // Edge Constructors for unweighted graph and weighted graph
  public Edge(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public Edge(int start, int end, float weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }
   
  //get parameters of the edge
  public int getStart() {
    return this.start;
  }

  public int getEnd() {
    return this.end;
  }
  
  public float getWeight() {
    return this.weight;
  } 

}
