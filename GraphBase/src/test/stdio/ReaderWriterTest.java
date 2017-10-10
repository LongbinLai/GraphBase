package test.stdio;

import graph.DirectedGraph;
import graph.Edge;
import graph.Graph;
import graph.UndirectedGraph;
import graph.UndirectedGraph;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import stdio.ReaderWriter;

import static org.junit.Assert.assertEquals;

/**
 * ReaderWriter Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 29, 2017</pre>
 */
public class ReaderWriterTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  @Test
  public void testReadUndirectedGraph() {
    ReaderWriter reader = new ReaderWriter();
    Graph graph = reader.readUndirectedGraph("testGraphs/testGraph.graph");
    Graph graph1 = new UndirectedGraph();
    graph1.addVertex(1);
    graph1.addVertex(2);
    graph1.addVertex(3);
    graph1.addVertex(4);
    graph1.addEdge(1, 2);
    graph1.addEdge(2, 3);
    graph1.addEdge(3, 4);
    graph1.addEdge(4, 1);
    assertEquals(graph.equals(graph1), true);
  }

  @Test
  public void testReadDirectedGraph() {
    ReaderWriter reader = new ReaderWriter();
    Graph graph = reader.readDirectedGraph("testGraphs/testGraph.graph");
    Graph graph1 = new DirectedGraph();
    graph1.addVertex(1);
    graph1.addVertex(2);
    graph1.addVertex(3);
    graph1.addVertex(4);
    graph1.addEdge(1, 2);
    graph1.addEdge(2, 3);
    graph1.addEdge(3, 4);
    graph1.addEdge(4, 1);
    assertEquals(graph.equals(graph1), true);
    graph1.addEdge(2, 1);
    assertEquals(graph.equals(graph1), false);
  }
} 
