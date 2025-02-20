import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int length = Integer.parseInt(st.nextToken());
			char[] pass = st.nextToken().toCharArray();
			
			int pointer = 0;
			char[] stack = new char[length];
			
			for(int i = 0; i < length; i++) {
				if(pointer == 0) {
					stack[pointer++] = pass[i];
				} else {
					if(stack[pointer-1] == pass[i]) {
						stack[--pointer] = '0';
					} else {
						stack[pointer++] = pass[i];
					}
				}
			}
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < pointer; i++) {
				System.out.print(stack[i]);
			}
			System.out.println();
		}
		br.close();
	}
}
