package algorithm;

import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Traversal {

  public ArrayList<Integer> BFS(Graph graph, Integer entryId) {
    Set<Integer> visitMark = new HashSet<Integer>();
    Queue<Integer> visitQueue = new LinkedList<Integer>();
    Map<Integer, Vertex> vertices = graph.getVertices();
    ArrayList<Integer> visitOrder = new ArrayList<>();
    if (!vertices.containsKey(entryId)) {
      throw new NoSuchElementException("The entry vertex is not existed");
    }
    visitQueue.add(entryId);
    while (!visitQueue.isEmpty()) {
      Integer vertexId = visitQueue.poll();
      visitMark.add(vertexId);
      visitOrder.add(vertexId);
      for (Object key : vertices.get(vertexId).getAdjEdges().keySet()) {
        Integer adjId = Integer.parseInt(key.toString());
        if (!visitMark.contains(adjId)) {
          visitMark.add(adjId);
          visitQueue.add(adjId);
        }
      }
    }
    return visitOrder;
  }

  public ArrayList<Integer> BFS(Graph graph, Vertex entryVertex) {
    return BFS(graph, entryVertex.getId());
  }

  public ArrayList DFS(Graph graph, Integer entryId) {
    Set<Integer> visitMark = new HashSet<Integer>();
    Stack<Integer> visitStack = new Stack<>();
    Map<Integer, Vertex> vertices = graph.getVertices();
    ArrayList<Integer> visitOrder = new ArrayList<>();
    if (!vertices.keySet().contains(entryId)) {
      throw new NoSuchElementException("The entry vertex is not existed");
    }
    visitStack.push(entryId);
    while (!visitStack.empty()) {
      Integer vertexId = visitStack.pop();
      visitMark.add(vertexId);
      visitOrder.add(vertexId);
      for (Object key : vertices.get(vertexId).getAdjEdges().keySet()) {
        Integer id = Integer.parseInt(key.toString());
        if (!visitMark.contains(id)) {
          if (!visitStack.contains(id)) {
            visitStack.push(id);
          }
        }
      }
    }
    return visitOrder;
  }

  public ArrayList DFS(Graph graph, Vertex entryVertex) {
    return DFS(graph, entryVertex.getId());
  }
}
