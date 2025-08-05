import java.util.*;
import java.io.*;

public class Main {
	static int F;
	static Map<String, String> relations;
	static Map<String, Integer> sizes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < TC; tc++) {
			relations = new HashMap<>();
			sizes = new HashMap<>();
			F = Integer.parseInt(br.readLine());
			for(int f = 0; f < F; f++) {
				String[] inputs = br.readLine().split(" ");
				if (!relations.containsKey(inputs[0])) {
					relations.put(inputs[0], inputs[0]);
					sizes.put(inputs[0], 1);
				}
				if (!relations.containsKey(inputs[1])) {
					relations.put(inputs[1], inputs[1]);
					sizes.put(inputs[1], 1);
				}
				union(inputs[0], inputs[1]);
				sb.append(sizes.get(find(inputs[0]))+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static String find(String name) {
		if (relations.containsKey(name) && !relations.get(name).equals(name)) {
			relations.put(name, find(relations.get(name)));
		}
		return relations.get(name);
	}
	
	public static void union(String f1, String f2) {
		f1 = find(f1);
		f2 = find(f2);
        if (f1.equals(f2)) return;
		relations.put(f2, f1);
		sizes.put(f1, sizes.get(f1)+sizes.get(f2));
	}

}
