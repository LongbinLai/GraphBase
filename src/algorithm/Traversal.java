package algorithm;

import graph.Graph;
import java.util.Collection;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public class Traversal {

  public static List<Integer> dfs(Graph g, int start) {
    if (!g.contains(start)) {
      return null;
    }

    List<Integer> order = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> s = new Stack<>();

    s.push(start);
    visited.add(start);

    int v;
    while (!s.empty()) {
      v = s.pop();
      order.add(v);

      Collection<Integer> neighbors = g.getVertex(v).getNeighbors();
      for (int n : neighbors) {
        if (!visited.contains(n)) {
          s.push(n);
          visited.add(n);
        }
      }
    }
    return order;
  }

  public static List<Integer> bfs(Graph g, int start) {
    if (!g.contains(start)) {
      return null;
    }

    List<Integer> order = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();

    q.add(start);
    visited.add(start);

    int v;
    while (!q.isEmpty()) {
      v = q.poll();
      order.add(v);

      Collection<Integer> neighbors = g.getVertex(v).getNeighbors();
      for (int n : neighbors) {
        if (!visited.contains(n)) {
          q.add(n);
          visited.add(n);
        }
      }
    }
    return order;
  }
}
