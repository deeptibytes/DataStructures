package graphs;

import java.util.Iterator;
import java.util.LinkedList;



public class SimpleGraph {

	private int vertices;
	LinkedList<Integer> adj_List[]; //this is array of Linkedlist<Integer>
	//int chars[]
	
	
	public SimpleGraph(int v) {
		this.vertices = v;
		adj_List = new LinkedList[v];//initialize array
		//chars = new Char[6]
		for(int i =0; i < adj_List.length; i++) {
			adj_List[i] = new LinkedList<Integer>();			
		}
	}
	
	private void addEdge(int source, int destination) {
		adj_List[source].add(destination);
		/*
		 * if the graph is bi-directional, either do below. Or add another edge reversing the source and destination
		 *
		 */
		 adj_List[destination].add(source);
	}
	
	
	/*
	 * DFS is adding adj nodes to the front of stack. This means, keep visiting nodes in last in first out manner
	 * Example of bidirectional graph
	 *                     Deepti(0) -- Anjali-1, Arya- 2
		 *                 Anjali (1) -- Deepti- 0, Stuti-3, Sheela-4
		 *                 Arya(2) -- Deepti- 0, Kamya- 5, Sheela-4
		 *                 Stuti(3) -- ANjali-1
		 *                 Sheela(4) -- Anjali-1, Arya-2, Kamya-5
		 *                 Kamya (5)-- Arya-2, Sheela-4
	 *  
	 *  BFS will start with Deepti-0 -->Anjali-1 -- Arya-2 -- Stuti-3 -- Sheela-4 -- Kamya-5
	 *  DFS will start with Deepti-0 --> Anjali-1 --Stuti-3 -->Sheela-4 --Arya-2 --Kamya-5
	 *                 
*            
*      
	 */
	private void performDFS(int node){//we can pass any node to start DFS
		boolean visited[] = new boolean[vertices];//this will hold boolean values for each vertex in graph. If visited, then true, else false
		System.out.println("---- DFS----");
		performDFS(node, visited);
		
	}
	
	private void performDFS(int node, boolean visited[]){
		
		visited[node] = true;
		System.out.println(node +",");
		//get adjacent nodes list
		LinkedList<Integer> list = adj_List[node];
		//iterate the nodes list
		Iterator<Integer> i = list.listIterator();
		while(i.hasNext()) {
			int nde = i.next();
			//check if that node is already visited or not			
			if(! visited[nde]) {//if it returns true, means nde is already visited
			performDFS(nde, visited);
		  }
		}
		
	}	
	/*
	 * BFS is adding adj nodes to the Queue (queue grows towards back while stack grows on the front)
	 * . This means, keep visiting nodes in first in first out manner
	 * Example of bidirectional graph
	 *                  Deepti(0) -- Anjali-1, Arya- 2
		 *                 Anjali (1) -- Deepti- 0, Stuti-3, Sheela-4
		 *                 Arya(2) -- Deepti- 0, Kamya- 5, Sheela-4
		 *                 Stuti(3) -- ANjali-1
		 *                 Sheela(4) -- Anjali-1, Arya-2, Kamya-5
		 *                 Kamya (5)-- Arya-2, Sheela-4
	 *               
	 *  BFS will start with Deepti-0 -->Anjali-1 -- Arya-2 -- Stuti-3 -- Sheela-4 -- Kamya-5
	 *  DFS will start with Deepti-0 --> Anjali-1 --Stuti-3 -->Sheela-4 --Arya-2 --Kamya-5
	 *                 
     *            
     *      
	 */
	//BFS 
	private void performBFS(int node){	
		boolean visited[] = new boolean[vertices];
		LinkedList<Integer> queue = new LinkedList();
		System.out.println("---- BFS----");
		queue.add(node);
		
		
		while(! queue.isEmpty()) {
			int nd = queue.poll();
			visited[nd] = true;
			System.out.println(nd +",");
			//Get the list of adjacent nodes 
			Iterator<Integer> i = adj_List[nd].listIterator();
			while(i.hasNext()) {
				int nde = i.next();
				//check if that node is already visited or not			
				if(! visited[nde] && ! queue.contains(nde)) {//if it returns true, means nde is already visited
				  queue.add(nde);
			  }
		}
		
		
	}
}	
	
	
	public static void main(String[] args) {
		SimpleGraph graph = new SimpleGraph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		
		graph.addEdge(1, 0);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		
		graph.addEdge(2, 0);//if addEdge method handling bidirection nature, this can be skipped
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		
		graph.addEdge(3, 1);
		
		graph.addEdge(4, 1);
		graph.addEdge(4, 2);
		graph.addEdge(4, 5);
		
		graph.addEdge(5, 2);
		graph.addEdge(5, 4);
		
		
		/*                 Deepti(0) -- Anjali-1, Arya- 2
		 *                 Anjali (1) -- Deepti- 0, Stuti-3, Sheela-4
		 *                 Arya(2) -- Deepti- 0, Kamya- 5, Sheela-4
		 *                 Stuti(3) -- ANjali-1
		 *                 Sheela(4) -- Anjali-1, Arya-2, Kamya-5
		 *                 Kamya (5)-- Arya-2, Sheela-4*/
		graph.performDFS(0);
		graph.performBFS(0);
		
	}

}
