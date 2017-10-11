package algorithm;

import graph.Graph;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class TraversalIterator implements Iterator<Integer> {

  private final Graph graph;
  private final int start;
  private Collection<Integer> unvisited;
  private Collection<Integer> queue;
  private boolean isBFS;
  private int count;

  public TraversalIterator(Graph graph, int start, String method) {

    method = method.toLowerCase();
    boolean isBFS;
    if (method.equals("bfs")) {
      isBFS = true;
    } else if (method.equals("dfs")) {
      isBFS = false;
    } else {
      throw new IllegalArgumentException("Unknown method: " + method);
    }

    if (!graph.contains(start)) {
      throw new NoSuchElementException();
    }

    this.graph = graph;
    this.start = start;
    this.unvisited = graph.getVertexIDs();
    this.isBFS = isBFS;
    this.count = 0;

    if (isBFS) {
      this.queue = new LinkedList<>();
      add(start);
    } else {
      this.queue = new Stack<>();
      push(start);
    }

    this.unvisited.remove(start);
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
      int newStart = this.unvisited.iterator().next();
      if (isBFS) {
        add(newStart);
      } else {
        push(newStart);
      }
      this.unvisited.remove(newStart);
    }

    int current = isBFS ? poll() : pop();

    Collection<Integer> neighbors = this.graph.getVertex(current).getNeighbors();
    for (int n : neighbors) {
      if (this.unvisited.contains(n)) {
        if (isBFS) {
          add(n);
        } else {
          push(n);
        }
        this.unvisited.remove(n);
      }
    }
    count++;
    return current;
  }

  @Override
  public boolean hasNext() {
    return this.count < this.graph.getNumOfVertices();
  }

  private void push(int i) {
    Stack<Integer> stack = (Stack<Integer>) this.queue;
    stack.push(i);
  }

  private int pop() {
    Stack<Integer> stack = (Stack<Integer>) this.queue;
    return stack.pop();
  }

  private void add(int i) {
    Queue<Integer> queue = (Queue<Integer>) this.queue;
    queue.add(i);
  }

  private int poll() {
    Queue<Integer> queue = (Queue<Integer>) this.queue;
    return queue.poll();
  }

}
