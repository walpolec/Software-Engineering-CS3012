import java.util.ArrayList;

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
    }
    
    private void validateVertex(int vertex)
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
        for (int v = 0; v < vertices; v++) {
            for (int w : adj(v)) {
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
    
    private void acyclic(int v)
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
		isDAG = true;
	}
}
