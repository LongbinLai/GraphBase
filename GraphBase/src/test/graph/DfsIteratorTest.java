package test.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;

import graph.DfsIterator;
import graph.Graph;
import algorithm.Traversal;
import stdio.ReaderWriter;

/**
 * DfsIterator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ʮ�� 10, 2017</pre>
 */
public class DfsIteratorTest {

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
    DfsIterator dIt = new DfsIterator(graph);
    ArrayList<Integer> dfsOrder = new ArrayList();
    while (dIt.hasNext()) {
      dfsOrder.add(dIt.next().getId());
    }
    Traversal newTravel = new Traversal();
    ArrayList<Integer> order = (ArrayList<Integer>) newTravel.DFS(graph, 1);
    assertEquals(order.equals(dfsOrder), true);
  }


} 
