import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test
	public void testEmpty()
	{
		Node testNode = null;
		assertNull(LCA.lowestCommonAncestor(testNode, 1, 2));
	}
	
	@Test
	public void testOneNode()
	{
		Node testNode = new Node(1);
		assertEquals(testNode.key, LCA.lowestCommonAncestor(testNode, 1, 2).key);
	}
	
	@Test
	public void testMultipleNodes()
	{
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(12);
		root.right.left = new Node(11);
		root.right.right = new Node(15);
		root.right.right.left = new Node(14);
		assertEquals(12, LCA.lowestCommonAncestor(root, 11, 14).key);
	}
	
	@Test
	public void testSameValue()
	{
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(12);
		root.right.left = new Node(11);
		root.right.right = new Node(15);
		root.right.right.left = new Node(14);
		assertEquals(15, LCA.lowestCommonAncestor(root, 15, 15).key);
	}
	
	@Test
	public void testWhenAncestorOfOther()
	{
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(12);
		root.right.left = new Node(11);
		root.right.right = new Node(15);
		root.right.right.left = new Node(14);
		assertEquals(15, LCA.lowestCommonAncestor(root, 15, 14).key);
	}
}
