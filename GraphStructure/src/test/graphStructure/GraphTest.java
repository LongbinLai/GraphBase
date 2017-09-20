package test.graphStructure; 

import graphStructure.Graph;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

import static org.junit.Assert.assertEquals;

/** 
* Graph Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 20, 2017</pre> 
* @version 1.0 
*/ 
public class GraphTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 


/** 
* 
* Method: addVertex() 
* 
*/ 
@Test
public void testAddVertex() throws Exception { 
//TODO: Test goes here...
  Graph graph = new Graph();
  graph.addVertex();
  graph.addVertex();
  graph.addVertex();
  assertEquals(3,graph.getVertices().size());
  graph.addEdge(1,2);
  assertEquals(3,graph.getVertices().size());

} 

/** 
* 
* Method: deleteVertex(int deVertexId) 
* 
*/ 
@Test
public void testDeleteVertex() throws Exception { 
//TODO: Test goes here...
  Graph graph = new Graph(5);
  graph.addVertex();
  graph.addVertex();
  graph.deleteVertex(2);
  assertEquals(6,graph.getVertices().size());
  graph.deleteVertex(3);
  assertEquals(5,graph.getVertices().size());
} 

/** 
* 
* Method: addEdge(Integer fromId, Integer toId) 
* 
*/ 
@Test
public void testAddEdge() throws Exception { 
//TODO: Test goes here...
  Graph graph = new Graph(6);
  graph.addEdge(1,2);
  graph.addEdge(2,3);
  assertEquals(graph.getVertices().get(1),graph.getEdges().get(1).getFrom());
  assertEquals(graph.getVertices().get(3),graph.getEdges().get(2).getTo());
  assertEquals(2,graph.getEdges().size());
} 

/** 
* 
* Method: deleteEdge(int fromVertexId, int toVertexId) 
* 
*/ 
@Test
public void testDeleteEdge() throws Exception { 
//TODO: Test goes here...
  Graph graph = new Graph(6);
  graph.addEdge(1,2);
  graph.addEdge(2,3);
  graph.addEdge(3,4);
  graph.addEdge(2,4);
  graph.deleteEdge(2,3);
  assertEquals(3,graph.getEdges().size());
  assertEquals(false,graph.getEdges().containsKey(2));
  assertEquals(2,graph.getVertices().get(2).getAdjVertices().size());
} 

/** 
* 
* Method: printVertex(Integer k) 
* 
*/
} 
