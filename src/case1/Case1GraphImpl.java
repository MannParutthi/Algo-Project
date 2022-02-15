package case1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class Case1GraphImpl {
	
	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(new FileInputStream("InputMap2"));
			HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
			
			while(sc.hasNext()) {
				String line = sc.nextLine();
				String[] arr = line.split(":");
				String node = arr[0].trim();
				String[] edges = arr[1].trim().split(" ");
				
				if(hashMap.get(node) == null) {
					hashMap.put(node, new ArrayList<String>());	
				}
				
				for(int i=0; i<edges.length; i++) {
					hashMap.get(node).add(edges[i]);
				}
			}
			System.out.println("Adjacency List of Graph ==> " + hashMap);
			
			System.out.println("Graph is Feasible ==> " + isGraphFeasible(hashMap));
			
			System.out.println("Directed Path of Graph ==> " + DFS("A", hashMap, true));
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isGraphFeasible(HashMap<String, ArrayList<String>> hashMap) {
		boolean isGraphStronglyConnected = true;
		
		for(Entry<String, ArrayList<String>> set : hashMap.entrySet()) {
			String node = set.getKey();
		    if (hashMap.size() != DFS(node, hashMap, false).size()) {
				isGraphStronglyConnected = false;
				break;
			}
		}
		
		return isGraphStronglyConnected;
	}
	
	public static ArrayList<String> DFS(String startNode, HashMap<String, ArrayList<String>> hashMap, boolean pathway) {
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<String> visitedNodes = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		
		visitedNodes.add(startNode);
		stack.push(startNode);
		
		while(!stack.isEmpty()) {
			String poppedNode = stack.pop();
			path.add(poppedNode);
			System.out.println("poppedNode ==> "+ poppedNode);
			System.out.println("hashMap.get(poppedNode) ==> " + hashMap.get(poppedNode));
			hashMap.get(poppedNode).sort(Comparator.reverseOrder());
			ArrayList<String> adjacentNodes = hashMap.get(poppedNode);
			for (String adjacentNode : adjacentNodes ) {
				if(!visitedNodes.contains(adjacentNode)) {
					visitedNodes.add(adjacentNode);
					stack.push(adjacentNode);
				}
			}
		}
		
		if(pathway) {
			path.add(startNode);
		}
		
		return path;
	}
	

}
