package test.stdio; 

import graph.Edge;
import graph.Graph;
import graph.UnidirectedGraph;
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
* @since <pre>���� 29, 2017</pre> 
* @version 1.0 
*/ 
public class ReaderWriterTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: read(String fileName) 
* 
*/ 
@Test
public void testRead() throws Exception { 
//TODO: Test goes here...
  ReaderWriter reader = new ReaderWriter();
  Collection<Edge> edges = reader.read("testGraphs/testGraph.graph");
  Collection<Edge> eds = reader.read("testGraphs/testCase3.graph");
  Graph graph2 = new UnidirectedGraph();
  graph2.addEdge(eds);
  Graph graph = new UnidirectedGraph();
  graph.addEdge(edges);
  Graph graph1 = new UnidirectedGraph();
  graph1.addVertex(1);
  graph1.addVertex(2);
  graph1.addVertex(3);
  graph1.addVertex(4);
  graph1.addEdge(1,2);
  graph1.addEdge(2,3);
  graph1.addEdge(3,4);
  graph1.addEdge(4,1);
  assertEquals(graph.isEqual(graph1),true); ;

}



} 
