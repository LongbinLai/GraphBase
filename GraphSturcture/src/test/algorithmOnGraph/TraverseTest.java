package test.algorithmOnGraph;

import algorithmOnGraph.Traverse;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import graphStructure.Graph;

import java.util.ArrayList;

/**
 * Traverse Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 20, 2017</pre>
 */
public class TraverseTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: Traverse()
   */
  @Test
  public void testTraverse() throws Exception {
//TODO: Test goes here...

  }

  /**
   * Method: BFS(Graph g, int entryId)
   */
  @Test
  public void testBFS() throws Exception {
//TODO: Test goes here...

    Graph graph = new Graph(7);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(5, 6);
    graph.addEdge(6, 7);
    graph.addEdge(7, 1);
    graph.addEdge(2, 7);
    graph.addEdge(3, 6);
    Traverse newTraverse = new Traverse();
    newTraverse.BFS(graph, 1);
    ArrayList visitOrderTest = new ArrayList<Integer>();
    visitOrderTest.add(1);
    visitOrderTest.add(2);
    visitOrderTest.add(7);
    visitOrderTest.add(3);
    visitOrderTest.add(6);
    visitOrderTest.add(4);
    visitOrderTest.add(5);
    assertEquals(visitOrderTest, newTraverse.BFS(graph, 1));
    visitOrderTest.clear();
    visitOrderTest.add(2);
    visitOrderTest.add(1);
    visitOrderTest.add(3);
    visitOrderTest.add(7);
    visitOrderTest.add(4);
    visitOrderTest.add(6);
    visitOrderTest.add(5);
    assertEquals(visitOrderTest, newTraverse.BFS(graph, 2));
  }

  /**
   * Method: DFS(Graph g, int entryId)
   */
  @Test
  public void testDFS() throws Exception {
//TODO: Test goes here...
    Graph graph = new Graph(7);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(5, 6);
    graph.addEdge(6, 7);
    graph.addEdge(7, 1);
    graph.addEdge(2, 7);
    graph.addEdge(3, 6);
    Traverse newTraverse = new Traverse();
    ArrayList visitOrderTest = new ArrayList<Integer>();
    visitOrderTest.add(1);
    visitOrderTest.add(7);
    visitOrderTest.add(6);
    visitOrderTest.add(5);
    visitOrderTest.add(4);
    visitOrderTest.add(3);
    visitOrderTest.add(2);
    assertEquals(visitOrderTest, newTraverse.DFS(graph, 1));
    visitOrderTest.clear();
    visitOrderTest.add(2);
    visitOrderTest.add(7);
    visitOrderTest.add(6);
    visitOrderTest.add(5);
    visitOrderTest.add(4);
    visitOrderTest.add(3);
    visitOrderTest.add(1);
    assertEquals(visitOrderTest, newTraverse.DFS(graph, 2));
  }

/**
 *
 * Method: init()
 *
 */


} 
