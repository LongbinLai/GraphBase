package algorithm;

import java.util.*;

import graph.*;

public class Traversal {

  public static List<Vertex> dfs(Vertex start) {
    List<Vertex> order = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    Stack<Vertex> s = new Stack<>();

    s.push(start);

    Vertex v;
    while (!s.empty()) {
      v = s.pop();
      visited.add(v.getId());
      order.add(v);
      for (Vertex n : v.getNeighbors()) {
        if (!visited.contains(n.getId())) {
          s.push(n);
        }
      }
    }
    return order;
  }

  public static List<Vertex> bfs(Vertex start) {
    List<Vertex> order = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    LinkedList<Vertex> q = new LinkedList<>();

    q.addLast(start);

    Vertex v;
    while (!q.isEmpty()) {
      v = q.removeFirst();
      visited.add(v.getId());
      order.add(v);
      for (Vertex n : v.getNeighbors()) {
        if (!visited.contains(n.getId())) {
          q.addLast(n);
        }
      }
    }
    return order;
  }
}
