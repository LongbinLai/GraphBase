package test.algorithm;

import algorithm.Traversal;
import graph.DirectedGraph;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Traversal Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 23, 2017</pre>
 */
public class TraversalTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  @Test
  public void testBFSForGraphEntryId() throws Exception {
//TODO: Test goes here...
    Traversal newSearch = new Traversal();
    DirectedGraph graph = new DirectedGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    graph.addVertex(5);
    graph.addVertex(6);
    graph.addVertex(7);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(5, 6);
    graph.addEdge(6, 7);
    graph.addEdge(1, 7);
    graph.addEdge(2, 7);
    graph.addEdge(3, 6);
    ArrayList<Integer> visitOrder = new ArrayList();
    visitOrder.add(1);
    visitOrder.add(2);
    visitOrder.add(7);
    visitOrder.add(3);
    visitOrder.add(4);
    visitOrder.add(6);
    visitOrder.add(5);
    assertEquals(visitOrder, newSearch.BFS(graph, 1));
    visitOrder.clear();
  }

  @Test
  public void testDFSForGraphEntryId() throws Exception {
//TODO: Test goes here...
    Traversal newSearch = new Traversal();
    DirectedGraph graph = new DirectedGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    graph.addVertex(5);
    graph.addVertex(6);
    graph.addVertex(7);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(5, 6);
    graph.addEdge(6, 7);
    graph.addEdge(1, 7);
    graph.addEdge(2, 7);
    graph.addEdge(3, 6);
    ArrayList<Integer> visitOrder = new ArrayList();
    visitOrder.add(1);
    visitOrder.add(7);
    visitOrder.add(2);
    visitOrder.add(3);
    visitOrder.add(6);
    visitOrder.add(4);
    visitOrder.add(5);
    newSearch.DFS(graph, 1);
    assertEquals(visitOrder, newSearch.DFS(graph, 1));
  }

} 
