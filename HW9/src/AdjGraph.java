//a simple implementation of Graph using adjacency list
//C343 2016

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;


public class AdjGraph implements Graph {
	private boolean digraph;
	private int totalNode;
	private Vector<String> nodeList;
	private int totalEdge;
	private Vector<LinkedList<Integer>>  adjList; //Adjacency list
	private Vector<Boolean> visited;
	private Vector<Integer> nodeEnum; //list of nodes pre visit
	public AdjGraph() {
		init();
	}
	public AdjGraph(boolean ifdigraph) {
		init();
		digraph =ifdigraph;
	}
	public void init() {
		nodeList = new Vector<String>(); 
		adjList = new Vector<LinkedList<Integer>>(); 
		visited = new Vector<Boolean>();
		nodeEnum = new Vector<Integer>();
		totalNode = totalEdge = 0;
		digraph = false;
	}
	//set vertices
	public void setVertex(String[] nodes) {
		for(int i = 0; i < nodes.length; i ++) {
			nodeList.add(nodes[i]);
			adjList.add(new LinkedList<Integer>());
			visited.add(false);
			totalNode ++;
		}
	}
	//add a vertex
	public void addVertex(String label) {
		nodeList.add(label);
		adjList.add(new LinkedList<Integer>());
	}
	public int getNode(String node) {
		for(int i = 0; i < nodeList.size(); i ++) {
			if(nodeList.elementAt(i).equals(node)) return i;
		}
		return -1;
	}
	//return the number of vertices
	public int length() {
		return nodeList.size();
	}
	//add edge from v1 to v2
	public void setEdge(int v1, int v2, int weight) {
		LinkedList<Integer> tmp = adjList.elementAt(v1);
		if(adjList.elementAt(v1).contains(v2) == false) {
			tmp.add(v2);
			adjList.set(v1,  tmp);
			totalEdge ++;
		}
	}
	public void setEdge(String v1, String v2, int weight) {
		if((getNode(v1) != -1) && (getNode(v2) != -1)) {
			//add edge from v1 to v2
			setEdge(getNode(v1), getNode(v2), weight);
			//for digraph, add edge from v2 to v1 as well
			if(digraph == false) setEdge(getNode(v2), getNode(v1), weight);
		}
	}

	//it is important to keep track if a vertex is visited or not (for traversal)
	public void setVisited(int v) {
		visited.set(v, true);
		nodeEnum.add(v);
	}
	public boolean ifVisited(int v) {
		return visited.get(v);
	}
	public void clearWalk() {
		//clean up before traverse
		nodeEnum.clear();
		for(int i = 0; i < nodeList.size(); i ++) visited.set(i, false);
	}
	public void walk(String method) {
		clearWalk();
		//traverse the graph 
		for(int i = 0; i < nodeList.size(); i ++) {
			if(ifVisited(i) == false) {
				if(method.equals("BFS")) BFS(i); //i as the start node
				else if(method.equals("DFS")) DFS(i); //i as the start node
				else {
					System.out.println("unrecognized traversal order: " + method);
					System.exit(0);
				}
			}
		}
		System.out.println(method + ":");
		displayEnum();
	}
	public void DFS(int v) {
		setVisited(v);
		LinkedList<Integer> neighbors = adjList.elementAt(v);
		for(int i = 0; i < neighbors.size(); i ++) {
			int v1 = neighbors.get(i);
			if(ifVisited(v1) == false) DFS(v1); 
		}
	}
	public void BFS(int s) {
		ArrayList<Integer> toVisit = new ArrayList<Integer>();
		toVisit.add(s);
		while(toVisit.size() > 0) {
			int v = toVisit.remove(0); //first-in, first-visit
			setVisited(v);
			LinkedList<Integer> neighbors = adjList.elementAt(v);
			for(int i = 0; i < neighbors.size(); i ++) {
				int v1 = neighbors.get(i);
				if((ifVisited(v1) == false) && (toVisit.contains(v1) == false)) {
					toVisit.add(v1);
				}
			}
		}
	}
	public void display() {
		System.out.println("total nodes: " + totalNode);
		System.out.println("total edges: " + totalEdge);
	}
	public void displayEnum() {
		for(int i = 0; i < nodeEnum.size(); i ++) {
			System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
		}
		System.out.println();
	}
	
	
	
	//topological sort using queue -- to be implemented
	public void topSort() {

		ArrayList<AdjGraph> L = new ArrayList<AdjGraph>(); //<- a list that will contain sorted vertices
		
		int[] C = new int[adjList.size()]; //<- a list contains indegrees for each of the vertices
		
		for (int i=0; i< adjList.size(); i++){
			C[i] = adjList.get(i).size();
		}
		
		ArrayList<AdjGraph> Q = new ArrayList<AdjGraph>(); //<- a queue that contains eligible vertices (vertices that have no incoming edges)
		
		while (Q.size() > 0){
			AdjGraph u = Q.get(0);
			Q.remove(0);
			L.add(u);
			for (int i = 0; i< u.adjList.size(); i++){
				C[i] = C[i] -1;
				if (C[i] == 0){
				Q.add(u.adjList.get(i));
				}
		}
		if(L.size() == totalNode){// L contains all the vertices ){
			System.out.println(L.toString());
		}
		else{
			System.out.println("solution not found");
		}
	}
}
}