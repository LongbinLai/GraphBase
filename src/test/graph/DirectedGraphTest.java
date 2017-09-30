package test.graph;

import graph.DirectedGraph;
import graph.Edge;
import graph.Vertex;
import java.util.Collection;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import util.GraphReader;

/**
 * DirectedGraph Tester.
 *
 * @author <Zhengyi Yang>
 * @version 1.0
 * @since <pre>Sep 26, 2017</pre>
 */
public class DirectedGraphTest {

  String testGraph;

  @Before
  public void before() throws Exception {
    testGraph = this.getClass().getClassLoader().getResource("test1").getPath();
  }

  @Test
  public void testAddGetRemoveNode() throws Exception {
    DirectedGraph g = new DirectedGraph();
    Vertex v0 = new Vertex(0);
    Assert.assertEquals(v0, g.addVertex(v0));
    Assert.assertEquals(v0, g.addVertex(0));
    Vertex v1 = g.addVertex(1);
    Collection<Vertex> nodes = g.getVertices();
    Assert.assertEquals(2, nodes.size());
    Assert.assertTrue(nodes.containsAll(Arrays.asList(v0, v1)));

    Vertex v = g.removeVertex(0);
    Assert.assertEquals(v0, v);
    Assert.assertEquals(1, nodes.size());
    Assert.assertFalse(nodes.contains(v0));
    g.removeVertex(1);
    Assert.assertEquals(0, nodes.size());
  }

  @Test
  public void testAddGetRemoveEdge() throws Exception {
    DirectedGraph g = new DirectedGraph();
    Edge e = new Edge(0, 1);
    Edge e01 = g.addEdge(e);
    Assert.assertEquals(e, e01);
    Assert.assertTrue(g.getVertex(0).isAdjTo(1));
    Assert.assertFalse(g.getVertex(1).isAdjTo(0));

    Edge e12 = g.addEdge(1, 2);
    Collection<Edge> edges = g.getEdges();
    Assert.assertEquals(2, edges.size());
    Assert.assertTrue(edges.containsAll(Arrays.asList(e01, e12)));
    Assert.assertEquals(e01, g.removeEdge(0, 1));
    edges = g.getEdges();
    Assert.assertEquals(1, edges.size());
    Assert.assertFalse(edges.contains(e01));

    g.addEdge(0, 1);
    g.removeEdges();
    Assert.assertEquals(0, g.getEdges().size());

    Assert.assertNull(g.removeEdge(0, 1));
  }

  @Test
  public void testEquals() throws Exception {
    DirectedGraph g1 = new GraphReader(",").readDirectedGraph(testGraph);
    DirectedGraph g2 = new GraphReader(",").readDirectedGraph(testGraph);

    String testGraph2 = this.getClass().getClassLoader().getResource("test2").getPath();
    DirectedGraph g3 = new GraphReader(",").readDirectedGraph(testGraph2);
    Assert.assertEquals(g1, g2);
    Assert.assertNotEquals(g2, g3);
  }

  @Test
  public void testClone() throws Exception {
    DirectedGraph g = new GraphReader(",").readDirectedGraph(testGraph);
    Assert.assertEquals(g, g.clone());
  }

} 
