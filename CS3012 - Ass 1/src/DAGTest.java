import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest {

	@Test
	public void testLCA() 
	{
		
	}
	
	@Test
	public void testDAG()
	{
		DAG graph = new DAG(5);	
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		assertEquals(0, graph.indegree(0));
		assertEquals(2, graph.outdegree(0));
		assertEquals(1, graph.indegree(1));
		assertEquals(1, graph.outdegree(1));
		assertEquals(1, graph.indegree(2));
		assertEquals(2, graph.outdegree(2));
		assertEquals(2, graph.indegree(3));
		assertEquals(1, graph.outdegree(3));
		assertEquals(2, graph.indegree(4));
		assertEquals(0, graph.outdegree(4));
		assertEquals(6, graph.edges());
		assertEquals(5, graph.vertices());
		String adj = "[3, 4]";
		assertEquals(adj, graph.adj(2).toString());
	}
	
	@Test (expected=Exception.class)
	public void testValidateVertex()
	{
		DAG graph = new DAG(5);
		graph.validateVertex(-1);
	}
	
	@Test (expected=Exception.class)
	public void testValidateVertex2()
	{
		DAG graph = new DAG(5);
		graph.validateVertex(10);
	}
	
	@Test
	public void testAddEdge()
	{
		
	}

	@Test
	public void testVertices()
	{
		DAG graph = new DAG(10);
		assertEquals(10, graph.vertices());
	}
	
	@Test
	public void testEdges()
	{
		DAG graph = new DAG(10);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		assertEquals(4, graph.edges());
	}
	
	@Test
	public void testAdj()
	{
		
	}
	@Test
	public void testOutDegree()
	{
		DAG graph = new DAG(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 3);
		assertEquals(2, graph.outdegree(0));
		assertEquals(1, graph.outdegree(1));
		assertEquals(1, graph.outdegree(2));
		assertEquals(0, graph.outdegree(3));
		assertEquals(0, graph.outdegree(4));
	}
	
	@Test
	public void testInDegree()
	{
		DAG graph = new DAG(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 3);
		assertEquals(0, graph.indegree(0));
		assertEquals(1, graph.indegree(1));
		assertEquals(1, graph.indegree(2));
		assertEquals(2, graph.indegree(3));
		assertEquals(0, graph.indegree(4));
	}
	
	@Test
	public void testReverse()
	{
		
	}
	
	@Test
	public void testToString()
	{
		
	}
	
	@Test
	public void testIsDag()
	{
		
	}
	
	@Test
	public void testAcyclic()
	{
		
	}
}
