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
		assertEquals(testNode.key, LCA.lowestCommonAncestor(testNode, 1, 1).key);
	}
	
	@Test
	public void test10Nodes()
	{
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(25);
		root.right.left = new Node(22);
		root.right.right = new Node(29);
		root.left.right = new Node(12);
		root.left.left = new Node(8);
		root.left.left.left = new Node(4);
		root.left.left.right = new Node(9);
		root.left.right.right = new Node(16);
		assertEquals(20, LCA.lowestCommonAncestor(root, 4, 29).key);
	}
	
	@Test
	public void test20Nodes()
	{
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(25);
		root.right.left = new Node(22);
		root.right.right = new Node(29);
		root.left.right = new Node(12);
		root.left.left = new Node(8);
		root.left.left.left = new Node(4);
		root.left.left.right = new Node(9);
		root.left.right.right = new Node(16);
		root.left.right.left = new Node(11);
		root.right.left.left = new Node(21);
		root.right.left.right = new Node(24);
		root.right.left.right.left = new Node(23);
		root.right.right.left = new Node(27);
		root.right.right.right = new Node(33);
		root.left.left.left.left = new Node(2);
		root.left.left.left.right = new Node(6);
		root.left.left.left.right.right = new Node(7);
		root.left.right.right.right = new Node(18);
		assertEquals(10, LCA.lowestCommonAncestor(root, 2, 16).key);
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
	
	@Test
	public void testForNonExistingNodes()
	{
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(12);
		root.right.left = new Node(11);
		root.right.right = new Node(15);
		root.right.right.left = new Node(14);
		assertNull(LCA.lowestCommonAncestor(root, 5, 7));
	}
}
