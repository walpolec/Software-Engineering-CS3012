import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG 
{
	private final int vertices;           
    private int edges;                 
    private ArrayList<Integer>[] adjacencyList;    
    private int[] indegree;
    public boolean[] marked;
    public boolean[] stack;
    public boolean isDAG;
	
    public DAG(int numVertices) 
    {
    	if (numVertices < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.vertices = numVertices;
		this.edges = 0;
		indegree = new int[numVertices];
		adjacencyList = (ArrayList<Integer>[]) new ArrayList[numVertices];
		for (int v = 0; v < numVertices; v++)
		{
			adjacencyList[v] = new ArrayList<Integer>();
		}
		marked = new boolean[numVertices];
		stack = new boolean[numVertices];
		isDAG = true;
    }
    
    public void validateVertex(int vertex)
    {
		if (vertex < 0 || vertex >= vertices)
			throw new IllegalArgumentException("vertex " + vertex + " is not between 0 and " + (vertices-1));

	}
    
    public void addEdge(int v, int w)
    {
		validateVertex(v);
		validateVertex(w);
		adjacencyList[v].add(w);
		indegree[w]++;
		edges++;
	}
    
    public int vertices()
    {
		return vertices;
	}
    
    public int edges() 
    {
		return edges;
	}

    public Iterable<Integer> adj(int vertex)
    {
		validateVertex(vertex);
		return adjacencyList[vertex];
	}
    
    public int outdegree(int vertex)
    {
        validateVertex(vertex);
        return adjacencyList[vertex].size();
    }
    
    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }
    
    public DAG reverse()
    {
        DAG reverse = new DAG(vertices);
        for (int v = 0; v < vertices; v++)
        {
            for (int w : adj(v))
            {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
    
    public String toString() 
    {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges " + System.getProperty("line.separator"));
        for (int v = 0; v < vertices; v++)
        {
            s.append(String.format("%d: ", v));
            for (int w : adjacencyList[v])
            {
                s.append(String.format("%d ", w));
            }
            s.append(System.getProperty("line.separator"));
        }
        return s.toString();
    }
    
    public boolean isDag()
	{
		return isDAG;	
	}
    
    public void acyclic(int v)
	{
		stack[v] =true; 
		marked[v] = true;
		for (int w : adj(v))
		{
			if(!marked[w]) 
			{
				acyclic(w);
			}
			else if (stack[w])
			{
				isDAG = false;
				return;
			}
		}
		stack[v] = false;
	}
    
    public void isAcyclic()
	{
		for(int i=0; i<vertices()&& isDAG; i++)
		{
			stack = new boolean[vertices];
			marked= new boolean[vertices];
			acyclic(i);
		}
	}
    
    public ArrayList<Integer> BFS(int s)
	{
		ArrayList<Integer> order = new ArrayList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[vertices]; 
		visited[s] = true;
		queue.add(s);
		while(queue.size() != 0)
		{
			s = queue.poll(); 
			order.add(s);
			Iterator<Integer> i = adjacencyList[s].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		return order;
	}
    
    public int LCADAG(int v, int w)
	{
		isAcyclic();
		if(!isDAG)
		{
			return -1;
		}
		validateVertex(v);
		validateVertex(w);
		if(edges==0)
		{
			return -1;
		}
		DAG  reversed = this.reverse();
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();      
		ArrayList<Integer> arrayv = reversed.BFS(v);
		ArrayList<Integer> arrayw = reversed.BFS(w);
		boolean haveLCA =false;
		for(int i = 0; i< arrayv.size(); i++)
		{
			for(int t = 0; t< arrayw.size(); t++)
			{		
				if(arrayv.get(i) == arrayw.get(t))
				{ 
					commonAncestors.add(arrayv.get(i));	
					haveLCA = true;
				}
			}
		}
		if(haveLCA)
			return commonAncestors.get(0);
		else
			return -1;
	}
}
