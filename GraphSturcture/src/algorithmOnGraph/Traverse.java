package algorithmOnGraph;

import graphStructure.Graph;
import graphStructure.Vertex;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.ArrayList;

public class Traverse {

  private Map<Integer, Vertex> graphVertices;
  private LinkedList<Integer> visitQueue;

  public Traverse() {
    this.graphVertices = new HashMap<>();
    this.visitQueue = new LinkedList<Integer>();
  }

  private void init() {
    graphVertices = new HashMap<>();
    visitQueue = new LinkedList<>();
  }

  public ArrayList BFS(Graph g, int entryId) {
    init();
    ArrayList visitOrder = new ArrayList<Integer>();
    graphVertices = g.getVertices();
    Hashtable<Integer, Boolean> visitMark = new Hashtable<Integer, Boolean>();
    for (Integer key : graphVertices.keySet()) {
      visitMark.put(key, false);
    }
    visitQueue.add(entryId);
    while (!visitQueue.isEmpty()) {
      Integer visitId = visitQueue.poll();
      visitMark.put(visitId, true);
      visitOrder.add(visitId);
      Map<Integer, Vertex> adjVertices = new HashMap<Integer, Vertex>();
      adjVertices = graphVertices.get(visitId).getAdjVertices();
      for (Integer key : adjVertices.keySet()) {
        if (!visitMark.get(key)) {
          if (!visitQueue.contains(key)) {
            visitQueue.add(key);
          }
        }
      }
    }
    return visitOrder;
  }

  public ArrayList DFS(Graph g, int entryId) {
    init();
    graphVertices = g.getVertices();
    ArrayList visitOrder = new ArrayList<Integer>();
    Hashtable<Integer, Boolean> visitMark = new Hashtable<Integer, Boolean>();
    for (Integer key : graphVertices.keySet()) {
      visitMark.put(key, false);
    }
    Map<Integer, Vertex> adjVertices = new HashMap<Integer, Vertex>();
    visitQueue.add(entryId);
    while (!visitQueue.isEmpty()) {
      Integer visitId = visitQueue.pop();
      visitMark.put(visitId, true);
      visitOrder.add(visitId);
      adjVertices = graphVertices.get(visitId).getAdjVertices();
      for (Integer key : adjVertices.keySet()) {
        if (!visitMark.get(key)) {
          if (!visitQueue.contains(key)) {
            visitQueue.push(key);
          }
        }
      }
    }
    return visitOrder;
  }
}
