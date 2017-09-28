package test.graph;

import graph.Edge;
import graph.Vertex;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * Vertex Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 22, 2017</pre>
 */
public class VertexTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: addAdjEdge(Edge newEdge)
   */
  @Test
  public void testAddAdjEdge() throws Exception {
//TODO: Test goes here...
    Vertex vertexOne = new Vertex(1);
    Vertex vertexTwo = new Vertex(2);
    Edge edge = new Edge(1, 2);
    vertexOne.addFromAdjEdge(edge);
    assertEquals(vertexOne.getAdjEdges().get(2).equals(edge), true);
  }

  /**
   * Method: deleteAdjEdge(Integer edgeId)
   */
  @Test
  public void testDeleteAdjEdge() throws Exception {
//TODO: Test goes here...
    Vertex vertexOne = new Vertex(1);
    Vertex vertexTwo = new Vertex(2);
    Edge edge = new Edge(1, 2);
    Edge dedge = new Edge(2, 1);
    vertexOne.addFromAdjEdge(edge);
    vertexTwo.addFromAdjEdge(dedge);
    assertEquals(vertexOne.getAdjEdges().get(2).equals(edge), true);
    assertEquals(vertexTwo.getAdjEdges().get(1).equals(dedge), true);
    vertexOne.deleteAdjEdge(2);
    assertEquals(vertexOne.getAdjEdges().size(), 0);
  }

  /**
   * Method: isAdjacent(int vertexId)
   */
  @Test
  public void testIsAdjacent() throws Exception {
//TODO: Test goes here...
    Vertex vertexOne = new Vertex(1);
    Vertex vertexTwo = new Vertex(2);
    Edge edge = new Edge(1, 2);
    vertexOne.addFromAdjEdge(edge);
    vertexTwo.addFromAdjEdge(edge);
    assertEquals(vertexOne.isAdjacent(2), true);
    assertEquals(vertexTwo.isAdjacent(1), false);
  }


} 
