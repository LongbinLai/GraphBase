package test.algorithm;

import algorithm.DfsIterator;
import graph.DirectedGraph;
import graph.Graph;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 * DfsIterator Tester.
 *
 * @author <Zhengyi Yang>
 * @version 1.0
 * @since <pre>Oct 10, 2017</pre>
 */
public class DfsIteratorTest {

  private DfsIterator dfsIterator;

  @Before
  public void before() throws Exception {
    Graph graph = new DirectedGraph();
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 4);
    graph.addEdge(5, 6);
    graph.addEdge(7, 5);

    dfsIterator = new DfsIterator(graph, 0);
  }

  /**
   * Method: next()
   */
  @Test
  public void testNext() throws Exception {
    List<Integer> order = new LinkedList<>();
    dfsIterator.forEachRemaining(order::add);
    Assert.assertEquals(order, Arrays.asList(0, 2, 4, 1, 3, 5, 6, 7));
  }

} 
