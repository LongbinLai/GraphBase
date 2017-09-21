package algorithm;

import graph.*;
import java.util.*;

public class Traversal {

  public static List<Vertex> dfs(Vertex start) {
    List<Vertex> order = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    Stack<Vertex> s = new Stack<>();

    s.push(start);
    visited.add(start.getId());

    Vertex v;
    while (!s.empty()) {
      v = s.pop();
      order.add(v);

      for (Vertex n : v.getNeighbors()) {
        if (!visited.contains(n.getId())) {
          s.push(n);
          visited.add(n.getId());
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
    visited.add(start.getId());

    Vertex v;
    while (!q.isEmpty()) {
      v = q.removeFirst();

      order.add(v);
      for (Vertex n : v.getNeighbors()) {
        if (!visited.contains(n.getId())) {
          q.addLast(n);
          visited.add(n.getId());
        }
      }
    }
    return order;
  }
}
