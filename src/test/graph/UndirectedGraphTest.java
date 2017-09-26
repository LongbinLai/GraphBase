package test.graph;

import graph.UndirectedGraph;
import graph.Edge;
import graph.Vertex;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * UndirectedGraph Tester.
 *
 * @author <Zhengyi Yang>
 * @version 1.0
 * @since <pre>Sep 26, 2017</pre>
 */
public class UndirectedGraphTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  @Test
  public void testAddGetRemoveNode() throws Exception {
    UndirectedGraph g = new UndirectedGraph();
    Vertex v0 = new Vertex(0);
    Assert.assertEquals(v0, g.addNode(v0));
    Assert.assertEquals(v0, g.addNode(0));
    Vertex v1 = g.addNode(1);
    Collection<Vertex> nodes = g.getNodes();
    Assert.assertEquals(2, nodes.size());
    Assert.assertTrue(nodes.containsAll(Arrays.asList(v0, v1)));

    Vertex v = g.removeNode(0);
    Assert.assertEquals(v0, v);
    Assert.assertEquals(1, nodes.size());
    Assert.assertFalse(nodes.contains(v0));
    g.removeNode(v1);
    Assert.assertEquals(0, nodes.size());
  }

  @Test
  public void testAddGetRemoveEdge() throws Exception {
    UndirectedGraph g = new UndirectedGraph();
    Edge e = new Edge(0, 1);
    Edge e01 = g.addEdge(e);
    Assert.assertEquals(e, e01);
    Assert.assertTrue(g.getNode(0).isAdjTo(1));
    Assert.assertTrue(g.getNode(1).isAdjTo(0));

    Edge e12 = g.addEdge(1, 2);
    Set<Edge> edges = g.getEdges();
    Assert.assertEquals(2, edges.size());
    Assert.assertTrue(edges.containsAll(Arrays.asList(e01, e12)));

    Assert.assertEquals(e01, g.removeEdge(0, 1));
    edges = g.getEdges();
    Assert.assertEquals(1, edges.size());
    Assert.assertFalse(edges.contains(e01));

    g.addEdge(0, 1);
    g.removeEdges();
    Assert.assertEquals(0, g.getNumOfEdges());

    Assert.assertNull(g.removeEdge(0, 1));
  }
} 
