package stdio;

import graph.DirectedGraph;
import graph.Edge;
import graph.Graph;
import graph.UndirectedGraph;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class ReaderWriter {

  public Graph readUndirectedGraph(String fileName) {
    Graph graph = new UndirectedGraph();
    File file = new File(fileName);
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      String edgeInfo = null;
      int fromId = 0;
      int toId = 0;
      while ((edgeInfo = reader.readLine()) != null) {
        if (edgeInfo.charAt(0) == '#' || edgeInfo.isEmpty()) {
          continue;
        }
        int split = 0;
        for (split = 0; split < edgeInfo.length(); split++) {
          if (edgeInfo.charAt(split) == ',') {
            break;
          }
        }
        fromId = Integer.parseInt(edgeInfo.substring(0, split));
        toId = Integer.parseInt(edgeInfo.substring(split + 1));
        Edge edge = new Edge(fromId, toId);
        graph.addEdge(edge);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e1) {
        }
      }
    }
    return graph;
  }

  public Graph readDirectedGraph(String fileName) {
    Graph graph = new DirectedGraph();
    File file = new File(fileName);
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      String edgeInfo = null;
      int fromId = 0;
      int toId = 0;
      while ((edgeInfo = reader.readLine()) != null) {
        if (edgeInfo.charAt(0) == '#' || edgeInfo.isEmpty()) {
          continue;
        }
        int split = 0;
        for (split = 0; split < edgeInfo.length(); split++) {
          if (edgeInfo.charAt(split) == ',') {
            break;
          }
        }
        fromId = Integer.parseInt(edgeInfo.substring(0, split));
        toId = Integer.parseInt(edgeInfo.substring(split + 1));
        Edge edge = new Edge(fromId, toId);
        graph.addEdge(edge);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e1) {
        }
      }
    }
    return graph;
  }

}


