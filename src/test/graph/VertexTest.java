package test.graph;

import graph.Edge;
import graph.Vertex;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Vertex Tester.
 *
 * @author <Zhengyi Yang>
 * @version 1.0
 * @since <pre>Sep 26, 2017</pre>
 */
public class VertexTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getId()
   */
  @Test
  public void testGetId() throws Exception {
    Vertex v = new Vertex(0);
    Assert.assertEquals(0, v.getId());
  }

  /**
   * Method: addNeighbor(int id); addNeighbor(Vertex v); getNeighbors()
   */
  @Test
  public void testAddGetNeighbor() throws Exception {
    Vertex v = new Vertex(0);
    v.addNeighbor(1);
    v.addNeighbor(new Vertex(2));
    Set<Integer> neighbors = v.getNeighbors();
    Assert.assertEquals(2, neighbors.size());
    Assert.assertTrue(neighbors.containsAll(Arrays.asList(1, 2)));
  }


  /**
   * Method: isAdjTo(int id); isAdjTo(Vertex v)
   */
  @Test
  public void testIsAdjTo() throws Exception {
    Vertex v = new Vertex(0);
    Vertex v1 = new Vertex(1);
    v.addNeighbor(v1);
    v.addNeighbor(2);
    Assert.assertTrue(v.isAdjTo(v1));
    Assert.assertTrue(v.isAdjTo(2));
    Assert.assertFalse(v.isAdjTo(3));
    Assert.assertFalse(v.isAdjTo(new Vertex(4)));
  }


  /**
   * Method: addEdge(Edge e); getEdges()
   */
  @Test
  public void testAddGetEdges() throws Exception {
    Vertex v = new Vertex(0);
    Edge e = new Edge(0, 1);
    Edge e1 = v.addEdge(e);
    Assert.assertEquals(e, e1);
    Edge e2 = v.addEdge(new Edge(2, 0));
    Collection<Edge> edges = v.getEdges();
    Assert.assertEquals(2, edges.size());
    Assert.assertTrue(edges.containsAll(Arrays.asList(e1, e2)));
    Assert.assertNull(v.addEdge(new Edge(3, 4)));
  }

  /**
   * Method: removeNeighbor(int id); removeNeighbor(Vertex v); removeNeighbors()
   */
  @Test
  public void testRemoveNeighbor() throws Exception {
    Vertex v = new Vertex(0);
    Vertex v1 = new Vertex(1);
    v.addNeighbor(v1);
    v.addNeighbor(2);
    v.addNeighbor(3);
    v.addNeighbor(4);
    v.removeNeighbor(v1);
    Assert.assertEquals(3, v.getNeighbors().size());
    Assert.assertFalse(v.getNeighbors().contains(1));
    v.removeNeighbor(2);
    Assert.assertEquals(2, v.getNeighbors().size());
    Assert.assertFalse(v.getNeighbors().contains(2));
    v.removeNeighbors();
    Assert.assertEquals(0, v.getNeighbors().size());

    Assert.assertNull(v.removeNeighbor(1));
  }

  /**
   * Method: getDegree()
   */
  @Test
  public void testGetDegree() throws Exception {
    Vertex v = new Vertex(0);
    Assert.assertEquals(0, v.getDegree());
    v.addNeighbor(1);
    Assert.assertEquals(1, v.getDegree());
    v.addNeighbor(2);
    Assert.assertEquals(2, v.getDegree());
    v.removeNeighbor(1);
    Assert.assertEquals(1, v.getDegree());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
//TODO: Test goes here... 
  }


} 
