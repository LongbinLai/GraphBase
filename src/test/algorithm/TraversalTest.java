package test.algorithm;

import algorithm.Traversal;
import graph.Graph;
import graph.Vertex;
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

  Graph g;
  Vertex v0, v1, v2, v3, v4;
  Traversal traversal;

  @Before
  public void before() throws Exception {
    traversal = new Traversal();

    v0 = new Vertex(0);
    v1 = new Vertex(1);
    v2 = new Vertex(2);
    v3 = new Vertex(3);
    v4 = new Vertex(4);

    g = new Graph();
    g.addNode(v0);
    g.addNode(v1);
    g.addNode(v2);
    g.addNode(v3);
    g.addNode(v4);
    g.addEdge(v0, v1);
    g.addEdge(v0, v2);
    g.addEdge(v1, v3);
    g.addEdge(v1, v4);
    g.addEdge(v2, v4);
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: dfs(Vertex start)
   */
  @Test
  public void testDfs() throws Exception {
    List<Vertex> order = traversal.dfs(v0);
    Assert.assertTrue(order.equals(Arrays.asList(v0, v2, v4, v1, v3)));
  }

  /**
   * Method: bfs(Vertex start)
   */
  @Test
  public void testBfs() throws Exception {
    List<Vertex> order = traversal.bfs(v0);
    Assert.assertTrue(order.equals(Arrays.asList(v0, v1, v2, v3, v4)));
  }


} 
