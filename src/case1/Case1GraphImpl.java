package case1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class Case1GraphImpl {
	
	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(new FileInputStream("InputMap1"));
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
			System.out.println("HashMap of Graph ==> " + hashMap);
			
			System.out.println("isGraphStronglyConnected ==> " + isGraphFeasible(hashMap));
			
			System.out.println("Directed Path of Graph ==> " + DFS("A", hashMap));
			
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
			for (String adjacentNode : hashMap.get(poppedNode)) {
				if(!visitedNodes.contains(adjacentNode)) {
					visitedNodes.add(adjacentNode);
					stack.push(adjacentNode);
				}
			}
		}
		return path;
	}
	

}
