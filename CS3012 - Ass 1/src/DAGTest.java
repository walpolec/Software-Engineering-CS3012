import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest {

	@Test
	public void testLCA() 
	{
		DAG graph = new DAG(10);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
		graph.addEdge(6, 9);
		graph.addEdge(5, 6);
		graph.addEdge(5, 8);
		graph.addEdge(7, 9);
		graph.addEdge(8, 9);
		assertEquals(0,graph.LCADAG(1,3));
		assertEquals(2, graph.LCADAG(7, 8));
		assertEquals(3, graph.LCADAG(3, 8));
		assertEquals(3, graph.LCADAG(3, 3));
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
	public void testExceptionConstructor()
	{
		DAG graph = new DAG(-5);	
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
		DAG graph = new DAG(5);	
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		assertEquals(6, graph.edges());
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
		DAG graph = new DAG(5);	
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		String adj0 = "[1, 2]";
		assertEquals(adj0, graph.adj(0).toString());
		String adj1 = "[3]";
		assertEquals(adj1, graph.adj(1).toString());
		String adj2 = "[3, 4]";
		assertEquals(adj2, graph.adj(2).toString());
		String adj3 = "[4]";
		assertEquals(adj3, graph.adj(3).toString());
		String adj4 = "[]";
		assertEquals(adj4, graph.adj(4).toString());
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
		DAG graph = new DAG(5);	
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		DAG graphReverse = graph.reverse();
		assertEquals(graphReverse.vertices(),graph.vertices());
		assertEquals(graphReverse.edges(),graph.edges());
		assertEquals(graphReverse.indegree(3),graph.outdegree(3));
		assertEquals(graphReverse.indegree(2),graph.outdegree(2));
		DAG emptyGraph = new DAG(25);
		DAG emptyGraphReverse = emptyGraph.reverse();
		assertEquals(emptyGraph.vertices(),emptyGraphReverse.vertices());
		assertEquals(emptyGraph.edges(),emptyGraphReverse.edges());
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
		DAG graph = new DAG(5);	
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.acyclic(0);
		assertTrue(graph.isDAG);
		DAG graph2 = new DAG(5);	
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(1, 3);
		graph2.addEdge(2, 3);
		graph2.addEdge(2, 4);
		graph2.addEdge(3, 4);
		graph2.addEdge(3, 2);
		graph2.acyclic(2);
		assertFalse(graph2.isDAG);
	}
	
	@Test
	public void testIsAcylic()
	{
		
	}
	
	@Test
	public void testBFS()
	{
		
	}
}
