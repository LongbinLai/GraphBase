package test.graph;

import static org.junit.Assert.assertEquals;

import algorithm.Traversal;
import graph.BfsIterator;
import graph.DfsIterator;
import graph.Graph;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import stdio.ReaderWriter;

/**
 * Graph Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ʮ�� 10, 2017</pre>
 */
public class GraphTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  @Test
  public void testBfsIterator() throws Exception {
//TODO: Test goes here...
    ReaderWriter reader = new ReaderWriter();
    Graph graph = reader.readUndirectedGraph("testGraphs/testCase4.graph");
    BfsIterator bIt = graph.bfsIterator();
    ArrayList<Integer> bfsOrder = new ArrayList();
    while (bIt.hasNext()) {
      bfsOrder.add(bIt.next().getId());
    }
    Traversal newTravel = new Traversal();
    ArrayList<Integer> order = (ArrayList<Integer>) newTravel.BFS(graph, 1);
    assertEquals(order.equals(bfsOrder), true);
    bIt = graph.bfsIterator(2);
    bfsOrder.clear();
    while (bIt.hasNext()) {
      bfsOrder.add(bIt.next().getId());
    }
    order = (ArrayList<Integer>) newTravel.BFS(graph,2);
    assertEquals(order.equals(bfsOrder),true);
  }

  @Test
  public void testDfsIterator() throws Exception {
//TODO: Test goes here...
    ReaderWriter reader = new ReaderWriter();
    Graph graph = reader.readUndirectedGraph("testGraphs/testCase4.graph");
    DfsIterator dIt = graph.dfsIterator();
    ArrayList<Integer> dfsOrder = new ArrayList();
    while (dIt.hasNext()) {
      dfsOrder.add(dIt.next().getId());
    }
    Traversal newTravel = new Traversal();
    ArrayList<Integer> order = (ArrayList<Integer>) newTravel.DFS(graph, 1);
    assertEquals(order.equals(dfsOrder), true);
    dIt = graph.dfsIterator(2);
    dfsOrder.clear();
    while (dIt.hasNext()) {
      dfsOrder.add(dIt.next().getId());
    }
    order = (ArrayList<Integer>) newTravel.DFS(graph,2);
    assertEquals(order.equals(dfsOrder),true);
  }

} 
