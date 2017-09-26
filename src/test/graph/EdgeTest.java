package test.graph;

import graph.Edge;
import graph.Vertex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Edge Tester.
 *
 * @author <Zhengyi Yang>
 * @version 1.0
 * @since <pre>Sep 20, 2017</pre>
 */
public class EdgeTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getStart(); getEnd()
   */
  @Test
  public void testGetSetStartEnd() throws Exception {
    Edge e = new Edge(0, 1);
    Assert.assertEquals(0, e.getStart());
    Assert.assertEquals(1, e.getEnd());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    Edge e = new Edge(0, 1);
    Assert.assertEquals("(0,1)", e.toString());
  }


} 
