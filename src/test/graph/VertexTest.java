package test.graph;

import graph.Edge;
import graph.Vertex;
import java.util.Collection;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Vertex Tester.
 *
 * @author <Zhengyi Yang>
 * @version 1.0
 * @since <pre>Sep 19, 2017</pre>
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
    Vertex v0 = new Vertex(0);
    Assert.assertEquals(0, v0.getId());
  }

  /**
   * Method: addNeighbor(Vertex v); getNeighbors(); removeNeighbor(int id); removeNeighbor(Vertex
   * v); testRemoveNeighbors()
   */
  @Test
  public void testAddGetRemoveNeighbor() throws Exception {
    Vertex v0 = new Vertex(0);
    Vertex v1 = new Vertex(1);
    Vertex v2 = new Vertex(2);
    Vertex v3 = new Vertex(3);
    v0.addNeighbor(v1);
    v0.addNeighbor(v2);
    v0.addNeighbor(v3);
    List<Vertex> v0_adj = v0.getNeighbors();
    Assert.assertEquals(3, v0_adj.size());
    Assert.assertTrue(v0_adj.contains(v1));
    Assert.assertTrue(v0_adj.contains(v2));
    Assert.assertTrue(v0_adj.contains(v3));

    v0.removeNeighbor(1);
    v0_adj = v0.getNeighbors();
    Assert.assertEquals(2, v0_adj.size());
    Assert.assertFalse(v0_adj.contains(v1));

    v0.removeNeighbor(v2);
    v0_adj = v0.getNeighbors();
    Assert.assertEquals(1, v0_adj.size());

    v0.removeNeighbors();
    v0_adj = v0.getNeighbors();
    Assert.assertEquals(0, v0_adj.size());
  }

  /**
   * Method: getEdges()
   */
  @Test
  public void testGetEdges() throws Exception {
    Vertex v0 = new Vertex(0);
    Vertex v1 = new Vertex(1);
    Vertex v2 = new Vertex(2);
    Edge e1 =v0.addNeighbor(v1);
    Edge e2= v0.addNeighbor(v2);
    Collection<Edge> edges = v0.getEdges();
    Assert.assertEquals(2,edges.size());
    Assert.assertTrue(edges.contains(e1));
    Assert.assertTrue(edges.contains(e2));
  }


  /**
   * Method: getDegree()
   */
  @Test
  public void testGetDegree() throws Exception {
    Vertex v0 = new Vertex(0);
    Vertex v1 = new Vertex(1);
    Vertex v2 = new Vertex(2);

    Assert.assertEquals(0,v0.getDegree());
    v0.addNeighbor(v1);
    Assert.assertEquals(1,v0.getDegree());
    v0.addNeighbor(v2);
    Assert.assertEquals(2,v0.getDegree());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
//TODO: Test goes here... 
  }


} 
