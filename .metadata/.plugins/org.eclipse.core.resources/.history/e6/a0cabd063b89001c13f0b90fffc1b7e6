package case1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FeasibleGraphOrientation {
	
	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(new FileInputStream("Input"));
			HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
			
			while(sc.hasNext()) {
				String line = sc.nextLine();
				String[] arr = line.split(":");
				String node = arr[0].trim();
				String[] edges = arr[1].trim().split(" ");
				
				for(int i=0; i<edges.length; i++) {
					if(hashMap.get(node) == null) {
						hashMap.put(node, new ArrayList<String>());	
					}
					hashMap.get(node).add(edges[i]);
				}
			}
			
			hashMap.forEach((k, v) -> System.out.println(k + " : "+ v));
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
