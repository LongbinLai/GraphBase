package test.graph;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import sun.misc.ASCIICaseInsensitiveComparator;

/**
 * Graph Tester.
 *
 * @author <Zhengyi Yang>
 * @version 1.0
 * @since <pre>Sep 20, 2017</pre>
 */
public class GraphTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: setName(String name); getName()
   */
  @Test
  public void testGetSetName() throws Exception {
    Graph g = new Graph();
    String name = "Test Graph";
    g.setName(name);
    Assert.assertEquals(name, g.getName());
  }

  /**
   * Method: addNode(int id); addNode(Vertex v); addNode(); getNode(int id); getNodes();
   * getNodesID()
   */
  @Test
  public void testAddGetNode() throws Exception {
    Graph g = new Graph();
    Vertex v0 = g.addNode();
    Vertex v1 = g.addNode(1);
    Vertex v2 = g.addNode(new Vertex(2));
    Vertex v3 = g.addNode();
    Assert.assertEquals(v0, g.getNode(0));
    Assert.assertNull(g.getNode(9));

    Collection<Vertex> nodes = g.getNodes();
    Assert.assertEquals(4, nodes.size());
    Assert.assertTrue(nodes.contains(v0));
    Assert.assertTrue(nodes.contains(v1));
    Assert.assertTrue(nodes.contains(v2));
    Assert.assertTrue(nodes.contains(v3));

    Set<Integer> nodesID = g.getNodesID();
    Assert.assertEquals(4, nodesID.size());
    Assert.assertTrue(nodesID.contains(0));
    Assert.assertTrue(nodesID.contains(1));
    Assert.assertTrue(nodesID.contains(2));
    Assert.assertTrue(nodesID.contains(3));
  }

  /**
   * Method: addEdge(Vertex node_u, Vertex node_v);addEdge(int u, int v),getEdges()
   */
  @Test
  public void testAddGetEdge() throws Exception {
    Graph g = new Graph();
    Vertex v0 = g.addNode();
    Vertex v1 = g.addNode();
    Edge e01 = g.addEdge(v0, v1);
    Edge e23 = g.addEdge(2, 3);
    Edge e03 = g.addEdge(0, 3);

    Collection<Edge> edges = g.getEdges();
    Assert.assertEquals(3, edges.size());
    Assert.assertTrue(edges.contains(e01));
    Assert.assertTrue(edges.contains(e23));
    Assert.assertTrue(edges.contains(e03));
  }


  /**
   * Method: getNumOfEdges()
   */
  @Test
  public void testGetNumOfEdges() throws Exception {
    Graph g = new Graph();
    g.addEdge(0, 1);
    Assert.assertEquals(1, g.getNumOfEdges());
    g.addEdge(1, 2);
    Assert.assertEquals(2, g.getNumOfEdges());
  }

  /**
   * Method: removeEdge(int u, int v); removeEdge(Vertex node_u, Vertex node_v),removeEdge(Edge e)
   */
  @Test
  public void testRemoveEdge() throws Exception {
    Graph g = new Graph();
    Vertex v0 = g.addNode();
    Vertex v1 = g.addNode();
    Edge e01 = g.addEdge(v0, v1);
    g.addEdge(0, 2);
    g.removeEdge(v0, v1);
    Assert.assertEquals(g.getNumOfEdges(), 1);
    Assert.assertFalse(g.getEdges().contains(e01));
    g.removeEdge(0, 2);
    Assert.assertEquals(g.getNumOfEdges(), 0);
  }

  /**
   * Method: getDegree(int id); getDegree(Vertex v); getDegrees()
   */
  @Test
  public void testGetDegree() throws Exception {
    Graph g = new Graph();
    Vertex v0 = g.addNode();
    g.addNode();
    g.addNode();
    g.addEdge(0, 1);
    Assert.assertEquals(1, g.getDegree(v0));
    Assert.assertEquals(1, g.getDegree(1));
    Assert.assertEquals(0, (int) g.getDegrees().get(2));
  }

  /**
   * Method: removeNode(int id); removeNode(Vertex v)
   */
  @Test
  public void testRemoveNode() throws Exception {
    Graph g = new Graph();
    Vertex v0 = g.addNode();
    g.addEdge(0, 1);

    g.removeNode(v0);
    Assert.assertNull(g.getNode(0));
    Assert.assertEquals(0, g.getDegree(1));
    g.removeNode(1);
    Assert.assertEquals(0, g.getNumOfEdges());
  }

  /**
   * Method: size()
   */
  @Test
  public void testSize() throws Exception {
    Graph g = new Graph();
    g.addNode();
    Assert.assertEquals(1, g.size());
    g.addNode();
    Assert.assertEquals(2, g.size());
    g.removeNode(0);
    Assert.assertEquals(1, g.size());
  }


  /**
   * Method: isEmpty()
   */
  @Test
  public void testIsEmpty() throws Exception {
    Graph g = new Graph();
    Assert.assertTrue(g.isEmpty());
    g.addEdge(0, 1);
    Assert.assertFalse(g.isEmpty());
  }

  /**
   * Method: empty()
   */
  @Test
  public void testEmpty() throws Exception {
    Graph g = new Graph();
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.empty();
    Assert.assertTrue(g.isEmpty());
  }

  /**
   * Method: isDirected()
   */
  @Test
  public void testIsDirected() throws Exception {
    Graph g = new Graph();
    Assert.assertFalse(g.isDirected());
  }

  /**
   * Method: copy()
   */
  @Test
  public void testCopy() throws Exception {
    Graph g = new Graph();
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    Graph g_copy = g.copy();
    Assert.assertEquals(g.size(), g_copy.size());
    Assert.assertEquals(g.getNumOfEdges(), g_copy.getNumOfEdges());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    Graph g = new Graph("g");
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addNode();

    String g_actual_str = g.toString();
    String g_expected_str = "Graph: g\n"
        + "Node: 0\n"
        + "  - Neighbors: 1, 2, \n"
        + "Node: 1\n"
        + "  - Neighbors: 0, \n"
        + "Node: 2\n"
        + "  - Neighbors: 0, \n"
        + "Node: 3\n"
        + "  - Neighbors: \n";

    Assert.assertEquals(g_expected_str, g_actual_str);
  }

} 
