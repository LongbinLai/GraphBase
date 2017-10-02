package test.graph;

import graph.DirectedGraph;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * DirectedGraph Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 26, 2017</pre>
 */
public class DirectedGraphTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  @Test
  public void testAddEdgeForFromIdToId() throws Exception {
//TODO: Test goes here...
    DirectedGraph dGraph = new DirectedGraph();
    dGraph.addVertex(1);
    dGraph.addVertex(2);
    dGraph.addVertex(3);
    dGraph.addEdge(1, 2);
    assertEquals(dGraph.getVertices().get(1).isAdjacent(2), true);
    assertEquals(dGraph.getVertices().get(2).isAdjacent(1), false);
    assertEquals(dGraph.getVertices().get(1).isAdjacent(3), false);
  }

  @Test
  public void testDeleteEdgeForFromIdToId() throws Exception {
//TODO: Test goes here...
    DirectedGraph dGraph = new DirectedGraph();
    dGraph.addVertex(1);
    dGraph.addVertex(2);
    dGraph.addVertex(3);
    dGraph.addEdge(1, 2);
    dGraph.addEdge(2, 3);
    assertEquals(dGraph.getVertices().get(1).isAdjacent(2), true);
    assertEquals(dGraph.getVertices().get(2).isAdjacent(1), false);
    assertEquals(dGraph.getVertices().get(1).isAdjacent(3), false);
    dGraph.deleteEdge(2, 1);
    assertEquals(dGraph.getVertices().get(1).isAdjacent(2), true);
    dGraph.deleteEdge(1, 2);
    assertEquals(dGraph.getVertices().get(1).isAdjacent(2), false);
  }

  @Test
  public void testIsEqual() throws Exception {
    DirectedGraph graph1 = new DirectedGraph();
    graph1.addVertex(1);
    graph1.addVertex(2);
    graph1.addVertex(3);
    DirectedGraph graph2 = new DirectedGraph();
    graph2.addVertex(1);
    graph2.addVertex(2);
    graph2.addVertex(3);
    graph1.addEdge(1,2);
    graph1.addEdge(2,3);
    graph2.addEdge(1,2);
    graph2.addEdge(2,3);
    assertEquals(graph1.isEqual(graph2),true);
    assertEquals(graph2.isEqual(graph1),true);
  }


  @Test
  public void testClone() throws Exception {
    DirectedGraph graph = new DirectedGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addEdge(1,2);
    graph.addEdge(2,3);
    DirectedGraph graphCopy = graph.clone();
    assertEquals(graph.isEqual(graphCopy),true);
  }


} 
