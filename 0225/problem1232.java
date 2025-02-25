import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static double calc(Node[] node, int index) {
		double left = 0;
		double right = 0;
		char charL = '0';

		if(node[index].left != 0) left = calc(node, node[index].left);
		if(node[index].right != 0) right = calc(node, node[index].right);
		
		if(node[index].charL != '0') {
			charL = node[index].charL;
			if(charL == '+') return left + right;
			else if(charL == '-') return left - right;
			else if(charL == '*') return left * right;
			else return left / right;
		} else return node[index].number;
	}
	
	static class Node{
		int index;
		char charL;
		int left;
		int right;
		int number;
		
		Node(int index, char charL, int left, int right){
			this.index = index;
			this.charL = charL;
			this.left = left;
			this.right = right;
		}
		Node(int index, int number){
			this.index = index;
			this.number = number;
			this.charL = '0';
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int length = Integer.parseInt(br.readLine());
			
			Node[] node = new Node[length+1];
			
			for(int i = 1; i <= length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int tokenLength = st.countTokens();
				
				if(tokenLength == 4) {
					node[i] = new Node(
						Integer.parseInt(st.nextToken()),
						st.nextToken().charAt(0),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
				}else if(tokenLength == 2) {
					node[i] = new Node(
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
				}
			}
			
			int result = (int) calc(node, 1);
			
			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}
}
