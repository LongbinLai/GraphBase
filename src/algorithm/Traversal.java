package algorithm;

import graph.*;
import java.util.*;

public class Traversal {

  public static List<Integer> dfs(AbstractGraph g) {
    int start = g.getNodesID().iterator().next();
    return dfs(g, start);
  }

  public static List<Integer> dfs(AbstractGraph g, int start) {
    List<Integer> order = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> s = new Stack<>();

    s.push(start);
    visited.add(start);

    int v;
    while (!s.empty()) {
      v = s.pop();
      order.add(v);

      for (int n : g.getNode(v).getNeighbors()) {
        if (!visited.contains(n)) {
          s.push(n);
          visited.add(n);
        }
      }
    }
    return order;
  }

  public static List<Integer> bfs(AbstractGraph g) {
    int start = g.getNodesID().iterator().next();
    return bfs(g, start);
  }

  public static List<Integer> bfs(AbstractGraph g, int start) {
    List<Integer> order = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    LinkedList<Integer> q = new LinkedList<>();

    q.addLast(start);
    visited.add(start);

    int v;
    while (!q.isEmpty()) {
      v = q.removeFirst();
      order.add(v);

      for (int n : g.getNode(v).getNeighbors()) {
        if (!visited.contains(n)) {
          q.addLast(n);
          visited.add(n);
        }
      }
    }
    return order;
  }
}
