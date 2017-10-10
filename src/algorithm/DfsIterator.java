package algorithm;

import graph.Graph;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

public class DfsIterator implements Iterator<Integer> {

  private final Graph graph;
  private final int start;
  private Set<Integer> visited;
  private Stack<Integer> stack;
  private int count;

  public DfsIterator(Graph graph, int start) {
    this.graph = graph;
    this.start = start;
    this.visited = new HashSet<>();
    this.stack = new Stack<>();
    this.count = 0;

    if (!graph.contains(start)) {
      throw new NoSuchElementException();
    }
    this.stack.add(start);
    this.visited.add(start);
  }

  public Graph getGraph() {
    return graph;
  }

  public int getStart() {
    return start;
  }

  @Override
  public Integer next() {
    if (stack.isEmpty()) {
      Collection<Integer> ids = this.graph.getVertexIDs();
      ids.removeAll(this.visited);
      int newStart = ids.iterator().next();
      this.stack.add(newStart);
      this.visited.add(newStart);
    }

    int current = this.stack.pop();

    Collection<Integer> neighbors = this.graph.getVertex(current).getNeighbors();
    for (int n : neighbors) {
      if (!this.visited.contains(n)) {
        this.stack.push(n);
        this.visited.add(n);
      }
    }
    count++;
    return current;
  }

  @Override
  public boolean hasNext() {
    return this.count < this.graph.getNumOfVertices();
  }


}
