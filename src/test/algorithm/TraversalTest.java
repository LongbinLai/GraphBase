package test.algorithm;

import algorithm.Traversal;
import graph.DirectedGraph;
import graph.UndirectedGraph;
import java.util.List;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import util.GraphReader;

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

    GraphReader reader = new GraphReader(",");
    String testGraph = this.getClass().getClassLoader().getResource("test1").getPath();

    g = reader.readUndirectedGraph(testGraph);
    dg = reader.readDirectedGraph(testGraph);
  }

  /**
   * Method: dfs(Graph dg, int start)
   */
  @Test
  public void testDfs() throws Exception {
    List<Integer> order = traversal.dfs(dg, 0);
    Assert.assertEquals(order, Arrays.asList(0, 2, 4, 1, 3));

    order = traversal.dfs(g, 0);
    Assert.assertEquals(order, Arrays.asList(0, 2, 4, 1, 3));
  }

  /**
   * Method: bfs(Graph dg, int start)
   */
  @Test
  public void testBfs() throws Exception {
    List<Integer> order = traversal.bfs(dg, 0);
    Assert.assertEquals(order, Arrays.asList(0, 1, 2, 3, 4));

    order = traversal.bfs(g, 0);
    Assert.assertEquals(order, Arrays.asList(0, 1, 2, 3, 4));
  }

}
