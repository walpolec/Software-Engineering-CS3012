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
	 static Node lowestCommonAncestor(Node node, int no1, int no2)  
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
}

