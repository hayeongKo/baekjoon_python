import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Map<String, Node> nodes;
	static class Node {
		String value;
		Node left, right;
		Node(String value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		Node(String value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nodes = new HashMap<>();
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String value = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			if (!nodes.containsKey(value)) {
				nodes.put(value, new Node(value));
			}
			
			if (!left.contains(".") && !nodes.containsKey(left)) {
				nodes.put(left, new Node(left));
				nodes.get(value).left = nodes.get(left);
			}
			
			if (!right.contains(".") && !nodes.containsKey(right)) {
				nodes.put(right, new Node(right));
				nodes.get(value).right = nodes.get(right);
			}	
		}
		
		preOrder(nodes.get("A"));
		System.out.println();
		inOrder(nodes.get("A"));
		System.out.println();
		postOrder(nodes.get("A"));
	}
	
	public static void preOrder(Node node) {
		System.out.print(node.value);
		if (node.left != null) preOrder(node.left);
		if (node.right != null) preOrder(node.right);
	}
	
	public static void inOrder(Node node) {
		if (node.left != null) inOrder(node.left);
		System.out.print(node.value);
		if (node.right != null) inOrder(node.right);
	}
	public static void postOrder(Node node) {
		if (node.left != null) postOrder(node.left);
		if (node.right != null) postOrder(node.right);
		System.out.print(node.value);
	}

}
