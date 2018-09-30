class Node
	 { 
		 int key; 
	     Node left, right; 
	 
	     public Node(int value)
	     { 
	    	 key = value; 
	         left = right = null; 
	     } 
	 } 

public class LCA
{
	static Node search(Node root, int value) 
	{ 
	    if (root==null || root.key==value) 
	    {
	        return root;
	    }
	    if (root.key > value)
	    {
	        return search(root.left, value);
	    } 
	    return search(root.right, value); 
	} 
	
	static boolean present(Node root, int value)
	{
		if (search(root, value) == null)
		{
			return false;
		}
		return true;
	}
	
	static Node lowestCommonAncestor(Node node, int no1, int no2)  
	{ 
		if (present(node, no1) & present(node, no2) == true)
		{
		if (node == null) 
		{
			return null;
		}
	    if (node.key > no1 && node.key > no2)
	    {
	        return lowestCommonAncestor(node.left, no1, no2); 
	    }
	    if (node.key < no1 && node.key < no2)
	    {
	        return lowestCommonAncestor(node.right, no1, no2); 
	    }
	    return node; 
		}
		else return null;
	} 
}

