package test.util;

import graph.DirectedGraph;
import graph.UndirectedGraph;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import util.GraphReader;

/**
 * GraphReader Tester.
 *
 * @author <Zhengyi Yang>
 * @version 1.0
 * @since <pre>Sep 29, 2017</pre>
 */
public class GraphReaderTest {

  String testGraph1, testGraph2;

  @Before
  public void before() throws Exception {
    testGraph1 = this.getClass().getClassLoader().getResource("test1").getPath();
    testGraph2 = this.getClass().getClassLoader().getResource("test3").getPath();
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getSep()
   */
  @Test
  public void testGetSetSep() throws Exception {
    GraphReader reader = new GraphReader(",");
    Assert.assertEquals(reader.getSep(), ",");
    reader.setSep(" ");
    Assert.assertEquals(reader.getSep(), " ");
  }

  /**
   * Method: readDirectedGraph(String filename)
   */
  @Test
  public void testReadDirectedGraph() throws Exception {
    DirectedGraph test1 = new GraphReader(",").readDirectedGraph(testGraph1);
    DirectedGraph test2 = new GraphReader(" ").readDirectedGraph(testGraph2);

    DirectedGraph g = new DirectedGraph();
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(1, 4);
    g.addEdge(2, 4);

    Assert.assertEquals(test1, g);
    Assert.assertEquals(test2, g);
  }

  /**
   * Method: readUndirectedGraph(String filename)
   */
  @Test
  public void testReadUndirectedGraph() throws Exception {
    UndirectedGraph test1 = new GraphReader(",").readUndirectedGraph(testGraph1);
    UndirectedGraph test2 = new GraphReader(" ").readUndirectedGraph(testGraph2);

    UndirectedGraph g = new UndirectedGraph();
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(1, 4);
    g.addEdge(2, 4);

    Assert.assertEquals(test1, g);
    Assert.assertEquals(test2, g);
  }

}
