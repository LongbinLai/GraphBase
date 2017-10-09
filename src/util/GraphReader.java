package util;

import graph.DirectedGraph;
import graph.Edge;
import graph.UndirectedGraph;
import java.util.IllegalFormatException;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphReader {

  private String splitter;  // edges format "src splitter dst"

  public GraphReader(String splitter) {
    this.splitter = splitter;
  }

  public String getSplitter() {
    return splitter;
  }

  public void setSplitter(String splitter) {
    this.splitter = splitter;
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

  private List<Edge> readEdges(String filename) throws IllegalArgumentException {
    List<Edge> edges = new LinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (!line.startsWith("#")) {
          String[] parts = line.split(this.getSplitter());

          if (parts.length != 2) {
            throw new IllegalArgumentException("Incorrect format for " + line);
          }

          try {
            int begin = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            edges.add(new Edge(begin, end));
          } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Incorrect format for " + line);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return edges;
  }

}
