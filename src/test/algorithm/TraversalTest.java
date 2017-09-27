package test.algorithm;

import algorithm.Traversal;
import graph.DirectedGraph;
import graph.UndirectedGraph;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Traversal Tester.
 *
 * @author <Zhengyi Yang>
 * @version 1.0
 * @since <pre>Sep 22, 2017</pre>
 */
public class TraversalTest {

  UndirectedGraph g;
  DirectedGraph dg;
  Traversal traversal;

  @Before
  public void before() throws Exception {
    traversal = new Traversal();

    g = new UndirectedGraph();
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(1, 4);
    g.addEdge(2, 4);

    dg = new DirectedGraph();
    dg.addEdge(0, 1);
    dg.addEdge(0, 2);
    dg.addEdge(1, 3);
    dg.addEdge(1, 4);
    dg.addEdge(2, 4);
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: dfs(AbstractGraph dg, int start)
   */
  @Test
  public void testDfs() throws Exception {
    List<Integer> order = traversal.dfs(dg, 0);
    Assert.assertTrue(order.equals(Arrays.asList(0, 2, 4, 1, 3)));
    order = traversal.dfs(g, 0);
    Assert.assertTrue(order.equals(Arrays.asList(0, 2, 4, 1, 3)));
  }

  /**
   * Method: bfs(AbstractGraph dg, int start)
   */
  @Test
  public void testBfs() throws Exception {
    List<Integer> order = traversal.bfs(dg, 0);
    Assert.assertTrue(order.equals(Arrays.asList(0, 1, 2, 3, 4)));
    order = traversal.bfs(g, 0);
    Assert.assertTrue(order.equals(Arrays.asList(0, 1, 2, 3, 4)));
  }

}
