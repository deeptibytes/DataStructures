package graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.softwaretestinghelp.com/java-graph-tutorial/
below is for directed graph using ArrayList as Adj List
 */


/*
 * Inner classes 	
 */
	class Node{
		int data;
		int weight;
		
		public Node(int data, int weight) {
			this.data = data;
			this.weight = weight;
		}
	}
	
	class Edge{
		int src;
		int des;
		int weight;
		
		public Edge(int src, int des, int weight) {
			this.src = src;
			this.des = des;
			this.weight = weight;
		}
	
	}
	/*
	 * Inner classes End	
	 */
	
public class Graph {


	
	 /*
     * 
     * Each Node is connected to other nodes via edges
     * List of adjacent nodes  for each node creates GRAPH
     * GRaph is a master List of list of adjacent nodes (adjacency List)
     * Looking at adjacent list, we figure out which nodes are connected to which node
     * 
     */
	
	/*
	 * Member variable
	 */
	List<List<Node>>	adj_list = new ArrayList<List<Node>>();
	
	/*
	 * Constructor
	 */
	public Graph(List<Edge> edges) {
	
	/*
	 * initialize lists of adj_list	object.
	 */
	int size = 	edges.size();
    while( size > 0) {
    	   adj_list.add(new ArrayList<Node>());
    	   size--;
    }
    
    /*
     * Populate each list of adj_list
     */

    for(Edge edge: edges) {
      	adj_list.get(edge.src).add(new Node(edge.des, edge.weight));
    }
	
    
	}
	
	private void addEdge(Edge edge) {
		if(adj_list.get(edge.src) == null) {
			//means vertex does not exist in adj_list
			 adj_list.add(new ArrayList<Node>());
		}
			
		adj_list.get(edge.src).add(new Node(edge.des, edge.weight));
		
	}
	
	
	
	
	void printGraph(){
		
		for(int i =0; i< adj_list.size(); i++) {
			System.out.println("NodeList for "+i );
			
			for(Node node: adj_list.get(i)) {
				System.out.println(i +"-----> "+ "data "+node.data +", weight "+node.weight);
				
				
			}
		}
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		List<Edge> edgeList = new ArrayList<Edge>();
		
		edgeList.add(new Edge(0, 1, 2));
		edgeList.add(new Edge(1, 2, 4));
		edgeList.add(new Edge(2, 0, 5));
		edgeList.add(new Edge(2, 1, 4));
		edgeList.add(new Edge(3, 2, 3));
		edgeList.add(new Edge(4, 5, 1));
		edgeList.add(new Edge(5, 4, 3));
		
		
		
		Graph graph = new Graph(edgeList);
		graph.printGraph();
		
		
		
		

	}

}
