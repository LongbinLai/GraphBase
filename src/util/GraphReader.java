package util;

import graph.DirectedGraph;
import graph.Edge;
import graph.UndirectedGraph;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphReader {

  private String sep;  // edges format "src sep dst"

  public GraphReader(String sep) {
    this.sep = sep;
  }

  public String getSep() {
    return sep;
  }

  public void setSep(String sep) {
    this.sep = sep;
  }

  public DirectedGraph readDirectedGraph(String filename) {
    DirectedGraph g = new DirectedGraph();
    for (Edge e : this.readEdges(filename)) {
      g.addEdge(e);
    }
    return g;
  }

  public UndirectedGraph readUndirectedGraph(String filename) {
    UndirectedGraph g = new UndirectedGraph();
    for (Edge e : this.readEdges(filename)) {
      g.addEdge(e);
    }
    return g;
  }

  private List<Edge> readEdges(String filename) {
    List<Edge> edges = new LinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (!line.startsWith("#")) {
          String[] parts = line.split(this.getSep(), 2);
          int begin = Integer.parseInt(parts[0]);
          int end = Integer.parseInt(parts[1]);
          edges.add(new Edge(begin, end));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return edges;
  }

}
