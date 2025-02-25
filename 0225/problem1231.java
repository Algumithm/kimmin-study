import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static String STRING;
	
	static void findChar(Node[] node, int index) {
		if(node[index].left != 0) findChar(node, node[index].left);
		STRING = STRING + node[index].charL;
		if(node[index].right != 0) findChar(node, node[index].right);
	}
	
	static class Node{
		int index;
		String charL;
		int left;
		int right;
		
		Node(int index, String charL, int left, int right){
			this.index = index;
			this.charL = charL;
			this.left = left;
			this.right = right;
		}
		Node(int index, String charL, int left){
			this.index = index;
			this.charL = charL;
			this.left = left;
		}
		Node(int index, String charL){
			this.index = index;
			this.charL = charL;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			STRING = "";
			int length = Integer.parseInt(br.readLine());
			
			Node[] node = new Node[length+1];
			
			for(int i = 1; i <= length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int tokenLength = st.countTokens();
				
				if(tokenLength == 4) {
					node[i] = new Node(
						Integer.parseInt(st.nextToken()),
						st.nextToken(),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
				} else if(tokenLength == 3) {
					node[i] = new Node(
						Integer.parseInt(st.nextToken()),
						st.nextToken(),
						Integer.parseInt(st.nextToken()));
				} else if(tokenLength == 2) {
					node[i] = new Node(
						Integer.parseInt(st.nextToken()),
						st.nextToken());
				}
			}
			
			findChar(node, 1);
			
			System.out.println("#" + test_case + " " + STRING);
		}
		br.close();
	}
}
