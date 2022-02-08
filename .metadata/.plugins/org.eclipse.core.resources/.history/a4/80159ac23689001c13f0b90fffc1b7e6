package Case1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class GraphImpl {
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "D");
		graph.addEdge("C", "E");
		graph.addEdge("D", "F");
		graph.addEdge("E", "F");
		
		System.out.println("BFS ===> ");
		graph.BFS("A");
		
		System.out.println("DFS ===> ");
		graph.DFS("A");
	}
	
}

class Graph {
	
	private HashMap<String, ArrayList<String>> hashMap;
	
	public Graph() {
		hashMap = new HashMap<String, ArrayList<String>>();
	}
	
	public void addEdge(String startNode, String endNode) {
		if(hashMap.get(startNode) == null) {
			hashMap.put(startNode, new ArrayList<String>());	
		}
		hashMap.get(startNode).add(endNode);
		
		if(hashMap.get(endNode) == null) {
			hashMap.put(endNode, new ArrayList<String>());	
		}
		hashMap.get(endNode).add(startNode);
	}
	
	public void BFS(String startNode) {
		ArrayList<String> visitedNodes = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();
		
		visitedNodes.add(startNode);
		queue.add(startNode);
		
		while(!queue.isEmpty()) {
			String dequeuedNode = queue.poll();
			System.out.println(dequeuedNode);
			for (String adjacentNode : hashMap.get(dequeuedNode)) {
				if(!visitedNodes.contains(adjacentNode)) {
					visitedNodes.add(adjacentNode);
					queue.add(adjacentNode);
				}
			}
		}
	}
	
	public void DFS(String startNode) {
		ArrayList<String> visitedNodes = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		
		visitedNodes.add(startNode);
		stack.push(startNode);
		
		while(!stack.isEmpty()) {
			String poppedNode = stack.pop();
			System.out.println(poppedNode);
			for (String adjacentNode : hashMap.get(poppedNode)) {
				if(!visitedNodes.contains(adjacentNode)) {
					visitedNodes.add(adjacentNode);
					stack.push(adjacentNode);
				}
			}
		}
	}
	
}
