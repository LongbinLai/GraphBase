package test.graphStructure;

import graphStructure.Graph;
import graphStructure.Vertex;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * Vertex Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 20, 2017</pre>
 */
public class VertexTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: isAdjacent(Integer vid)
   */
  @Test
  public void testIsAdjacent() throws Exception {
//TODO: Test goes here...
    Graph graph = new Graph(3);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    Vertex testVertex = graph.getVertices().get(1);
    assertEquals(true, testVertex.isAdjacent(2));
    assertEquals(false, testVertex.isAdjacent(3));
  }

  /**
   * Method: setId(Integer newSetId)
   */
  @Test
  public void testSetId() throws Exception {
//TODO: Test goes here...
    Vertex testVertex = new Vertex();
    testVertex.setId(2);
    assertEquals(true, 2 == testVertex.getId().intValue());
    testVertex.setId(3);
    assertEquals(false, 2 == testVertex.getId().intValue());
    assertEquals(true, 3 == testVertex.getId().intValue());
  }

  /**
   * Method: addAdjVertex(Vertex newAdj)
   */
  @Test
  public void testAddAdjVertex() throws Exception {
//TODO: Test goes here...
    Vertex testVertexOne = new Vertex();
    testVertexOne.setId(1);
    Vertex textVertexTwo = new Vertex();
    textVertexTwo.setId(2);
    Vertex textVertexThr = new Vertex();
    textVertexThr.setId(3);
    testVertexOne.addAdjVertex(textVertexTwo);
    testVertexOne.addAdjVertex(textVertexThr);
    assertEquals(true, testVertexOne.isAdjacent(2));
    assertEquals(false, textVertexTwo.isAdjacent(1));
    assertEquals(true, testVertexOne.isAdjacent(3));
    textVertexTwo.addAdjVertex(testVertexOne);
    assertEquals(true, textVertexTwo.isAdjacent(1));
  }

  /**
   * Method: deleteAdjVertex(Integer deVertexId)
   */
  @Test
  public void testDeleteAdjVertex() throws Exception {
//TODO: Test goes here...
    Vertex testVertexOne = new Vertex();
    testVertexOne.setId(1);
    Vertex textVertexTwo = new Vertex();
    textVertexTwo.setId(2);
    Vertex textVertexThr = new Vertex();
    textVertexThr.setId(3);
    testVertexOne.addAdjVertex(textVertexTwo);
    testVertexOne.addAdjVertex(textVertexThr);
    assertEquals(true, testVertexOne.isAdjacent(2));
    testVertexOne.deleteAdjVertex(2);
    assertEquals(false, testVertexOne.isAdjacent(2));
  }

  /**
   * Method: deleteAdjEdge(Integer deEdgeId)
   */
  @Test
  public void testDeleteAdjEdge() throws Exception {
//TODO: Test goes here...
 /*This can be tested in the Graph.deleteEdge*/
  }

  /**
   * Method: addAdjEdge(Edge newAdjEdge)
   */
  @Test
  public void testAddAdjEdge() throws Exception {
//TODO: Test goes here...
   /*This can be tested in the Graph.addEdge*/

  }
}
