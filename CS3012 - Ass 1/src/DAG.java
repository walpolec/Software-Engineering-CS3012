import java.util.ArrayList;

public class DAG 
{
	private final int vertices;           
    private int edges;                 
    private ArrayList<Integer>[] adjacencyList;    
    private int[] indegree;
	
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
}
