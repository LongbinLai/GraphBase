package algorithm;

import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
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
    int graphSize = graph.size();
    while (visited.size() < graphSize) {
      if (queue.isEmpty()) {
        HashMap<Integer,Vertex> map = graph.getVerticesMap();
        for (int id : map.keySet()) {
          if (!visited.contains(id)) {
            queue.addAll(graph.getVertex(id).neighbors());
            visited.add(id);
            order.add(id);
            break;
          }
        }
      }
      Integer vertexId = queue.poll();
      visited.add(vertexId);
      order.add(vertexId);
      graph.getVertex(vertexId).neighbors().forEach(id -> {
        if (!visited.contains(id) && !queue.contains(id))
          queue.add(id);
      });
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
    int graphSize = graph.size();
    while (visited.size() < graphSize) {
      if (stack.isEmpty()) {
        HashMap<Integer,Vertex> map = graph.getVerticesMap();
        for (int id : map.keySet()) {
          if (!visited.contains(id)) {
            stack.addAll(graph.getVertex(id).neighbors());
            visited.add(id);
            order.add(id);
            break;
          }
        }
      }
      int vertexId = stack.pop();
      visited.add(vertexId);
      order.add(vertexId);
      graph.getVertex(vertexId).neighbors().forEach(id -> {
        if (!visited.contains(id) && !stack.contains(id))
          stack.push(id);
      });
    }
    return order;
  }

  public List DFS(Graph graph, Vertex entryVertex) {
    return DFS(graph, entryVertex.getId());
  }
}
