import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] DOUBLECHECK;
	
	static void findParent(Node[] node, int index) {
		if(index == 0) return;
		DOUBLECHECK[index]++;
		findParent(node, node[index].parent);
	}
	
	static int howManySons(Node[] node, int index) {
		if(node[index].left == 0 && node[index].right == 0) return 1;
		else if(node[index].right == 0) return howManySons(node, node[index].left) + 1;
		else return howManySons(node, node[index].left) + howManySons(node, node[index].right) + 1;
	}
	
	static int getDepth(Node[] node, int index) {
	    int depth = 0;
	    while (index != 0) {
	        depth++;
	        index = node[index].parent;
	    }
	    return depth;
	}
	
	static class Node{
		int parent;
		int left;
		int right;
		
		Node() {
			this.left = 0;
			this.right = 0;
		}
		
		void set(int n) {
			if(this.left == 0) this.left = n;
			else this.right = n;
		}
		
		void setParent(int n) {
			this.parent = n;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int nodeSize = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			Node[] node = new Node[nodeSize+1];
			DOUBLECHECK = new int[nodeSize+1];
			
			for(int i = 1; i <= nodeSize; i++) {
				node[i] = new Node();
				DOUBLECHECK[i] = 0;
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= length; i++) {
				int index = Integer.parseInt(st.nextToken());
				int target = Integer.parseInt(st.nextToken());
				node[index].set(target);
				node[target].setParent(index);				
			}
			
			findParent(node, first);
			findParent(node, second);
			
			int parent = Integer.MIN_VALUE;
			int maxDepth = Integer.MIN_VALUE;
			
			for (int i = 1; i <= nodeSize; i++) {
			    if (DOUBLECHECK[i] == 2) {
			        int depth = getDepth(node, i);
			        if (depth > maxDepth) {
			            maxDepth = depth;
			            parent = i;
			        }
			    }
			}
			
			int sons = howManySons(node, parent);
			
			System.out.println("#" + test_case + " " + parent + " " + sons);
		}
		br.close();
	}
}
