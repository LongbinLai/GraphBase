package test.graph;

import graph.Edge;
import org.junit.Assert;
import org.junit.Test;

/**
 * Edge Tester.
 *
 * @author <Zhengyi Yang>
 * @version 1.0
 * @since <pre>Sep 20, 2017</pre>
 */
public class EdgeTest {

  /**
   * Method: getBegin(); getEnd()
   */
  @Test
  public void testGetSetStartEnd() throws Exception {
    Edge e = new Edge(0, 1);
    Assert.assertEquals(0, e.getBegin());
    Assert.assertEquals(1, e.getEnd());
    e.setBegin(1);
    Assert.assertEquals(1, e.getBegin());
    e.setEnd(0);
    Assert.assertEquals(0, e.getEnd());
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
