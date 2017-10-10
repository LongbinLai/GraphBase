package test.graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import graph.Graph;
import graph.DirectedGraph;
import graph.UndirectedGraph;
import graph.BfsIterator;
import stdio.ReaderWriter;
import algorithm.Traversal;

/**
 * BfsIterator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ʮ�� 10, 2017</pre>
 */
public class BfsIteratorTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: next()
   */
  @Test
  public void testNext() throws Exception {
//TODO: Test goes here...
    ReaderWriter reader = new ReaderWriter();
    Graph graph = reader.readUndirectedGraph("testGraphs/testCase4.graph");
    BfsIterator bIt = new BfsIterator(graph);
    ArrayList<Integer> bfsOrder = new ArrayList();
    while (bIt.hasNext()) {
      bfsOrder.add(bIt.next().getId());
    }
    Traversal newTravel = new Traversal();
    ArrayList<Integer> order = (ArrayList<Integer>) newTravel.BFS(graph, 1);
    assertEquals(order.equals(bfsOrder), true);
  }

} 
