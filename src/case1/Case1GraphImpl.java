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
			System.out.println("Adjacency List of Graph ==> " + hashMap + "\n");
			
			System.out.println("Graph is Feasible ==> " + isGraphFeasible(hashMap) + "\n");
			
			System.out.println("Directed Path of Graph ==> " + getPath("A0", hashMap) + "\n");
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isGraphFeasible(HashMap<String, ArrayList<String>> hashMap) {
		boolean isGraphStronglyConnected = true;
		
		for(Entry<String, ArrayList<String>> set : hashMap.entrySet()) {
			String node = set.getKey();
		    if (hashMap.size() != DFS(node, hashMap).size()) {
				isGraphStronglyConnected = false;
				break;
			}
		}
		
		return isGraphStronglyConnected;
	}
	
	public static ArrayList<String> DFS(String startNode, HashMap<String, ArrayList<String>> hashMap) {
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<String> visitedNodes = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		
		visitedNodes.add(startNode);
		stack.push(startNode);
		
		while(!stack.isEmpty()) {
			String poppedNode = stack.pop();
			path.add(poppedNode);
			hashMap.get(poppedNode).sort(Comparator.reverseOrder());
			ArrayList<String> adjacentNodes = hashMap.get(poppedNode);
			for (String adjacentNode : adjacentNodes) {
				if(!visitedNodes.contains(adjacentNode)) {
					visitedNodes.add(adjacentNode);
					stack.push(adjacentNode);
				}
			}
		}
		
		return path;
	}


	public static ArrayList<String> getPath(String startNode, HashMap<String, ArrayList<String>> hashMap) {
		ArrayList<String> dfsPath = new ArrayList<String>();
		ArrayList<String> visitedNodes = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		
		visitedNodes.add(startNode);
		stack.push(startNode);
		
		while(!stack.isEmpty()) {
			String poppedNode = stack.pop();
			dfsPath.add(poppedNode);
			hashMap.get(poppedNode).sort(Comparator.reverseOrder());
			ArrayList<String> adjacentNodes = hashMap.get(poppedNode);
			for (String adjacentNode : adjacentNodes) {
				if(!visitedNodes.contains(adjacentNode)) {
					visitedNodes.add(adjacentNode);
					stack.push(adjacentNode);
				}
			}
		}
		
		dfsPath.add(startNode);

		ArrayList<String> finalPath = new ArrayList<String>();
		for(int i=0; i<dfsPath.size()-1; i++) {
			finalPath.add(dfsPath.get(i));
			if(dfsPath.get(i).charAt(0) == dfsPath.get(i+1).charAt(0) || dfsPath.get(i).charAt(1) == '0') {
				continue;
			}
			else {	
				finalPath.add(dfsPath.get(i).charAt(0) + "0");
			}
		}
		finalPath.add(startNode);

		return finalPath;
	}
	

}
