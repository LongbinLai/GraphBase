package algorithm;

import java.util.*;

import graph.*;

public class Topological {

  public List<Vertex> kahns(DiGraph g) {
    List<Vertex> order = new LinkedList<>();
    Stack<Integer> q = new Stack<>();
    DiGraph t = g.copy();

    for (Map.Entry<Integer, Integer> entry : t.getInDegrees().entrySet()) {
      if (entry.getValue() == 0) {
        q.push(entry.getKey());
      }
    }

    while (!q.isEmpty()) {
      Vertex v = t.getNode(q.pop());
      order.add(g.getNode(v.getId()));
      for (Vertex n : v.getNeighbors().toArray(new Vertex[0])) {
        t.removeEdge(v, n);
        if (t.getInDegree(n) == 0) {
          q.push(n.getId());
        }
      }
    }

    if (t.getNumOfEdges() != 0) {
      // graph contains at least one cycle
      return null;
    }

    return order;
  }

}
