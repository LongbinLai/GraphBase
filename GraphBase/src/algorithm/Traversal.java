package algorithm;

import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Traversal {

  public List<Integer> BFS(Graph graph, Integer entryId) {
    Set<Integer> visited = new HashSet<Integer>();
    Queue<Integer> queue = new LinkedList<Integer>();
    List<Integer> order = new ArrayList<>();
    if (!graph.contains(entryId)) {
      throw new NoSuchElementException("The entry vertex is not existed");
    }
    queue.add(entryId);
    while (!queue.isEmpty()) {
      Integer vertexId = queue.poll();
      visited.add(vertexId);
      order.add(vertexId);
      Collection<Integer> adjEdges = graph.getVertex(vertexId).getNeighbors();
      for (int id : adjEdges) {
        if (!visited.contains(id)) {
          visited.add(id);
          queue.add(id);
        }
      }
    }
    return order;
  }

  public List<Integer> BFS(Graph graph, Vertex entryVertex) {
    return BFS(graph, entryVertex.getId());
  }

  public List DFS(Graph graph, Integer entryId) {
    Set<Integer> visited = new HashSet<Integer>();
    Stack<Integer> stack = new Stack<>();
    List<Integer> order = new ArrayList<>();
    if (!graph.contains(entryId)) {
      throw new NoSuchElementException("The entry vertex is not existed");
    }
    stack.push(entryId);
    while (!stack.empty()) {
      int vertexId = stack.pop();
      visited.add(vertexId);
      order.add(vertexId);
      Collection<Integer> neighbors = graph.getVertex(vertexId).getNeighbors();
      for (int id : neighbors) {
        if (!visited.contains(id)) {
          if (!stack.contains(id)) {
            stack.push(id);
          }
        }
      }
    }
    return order;
  }

  public List DFS(Graph graph, Vertex entryVertex) {
    return DFS(graph, entryVertex.getId());
  }
}
