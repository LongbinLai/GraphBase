package algorithm;

import graph.Graph;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

public class BfsIterator implements Iterator<Integer> {

  private final Graph graph;
  private final int start;
  private Set<Integer> visited;
  private Queue<Integer> queue;
  private int count;

  public BfsIterator(Graph graph, int start) {
    this.graph = graph;
    this.start = start;
    this.visited = new HashSet<>();
    this.queue = new LinkedList<>();
    this.count = 0;

    if (!graph.contains(start)) {
      throw new NoSuchElementException();
    }
    this.queue.add(start);
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
    if (queue.isEmpty()) {
      Collection<Integer> ids = this.graph.getVertexIDs();
      ids.removeAll(this.visited);
      int newStart = ids.iterator().next();
      this.queue.add(newStart);
      this.visited.add(newStart);
    }

    int current = this.queue.poll();

    Collection<Integer> neighbors = this.graph.getVertex(current).getNeighbors();
    for (int n : neighbors) {
      if (!this.visited.contains(n)) {
        this.queue.add(n);
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
