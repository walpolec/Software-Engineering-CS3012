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
		
	}
	
	@Test
	public void testValidateVertex()
	{
		
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
		
	}
	
	@Test
	public void testInDegree()
	{
		
	}
	
	@Test
	public void testReverse()
	{
		
	}
	
	@Test
	public void testToString()
	{
		
	}
}
