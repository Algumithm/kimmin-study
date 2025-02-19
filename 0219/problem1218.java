import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		char[][] text = {
			{'(', ')'},
			{'{', '}'},
			{'[', ']'},
			{'<', '>'}
		};

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = Integer.parseInt(br.readLine());
			
			int able = 1;
			
			char[] st = br.readLine().toCharArray();
			
			char[] stack = new char[size];
			int pointer = 0;
			
			for(int i = 0; i < size; i++) {
				char temp = st[i];
				if(
					temp == text[0][0] ||
					temp == text[1][0] ||
					temp == text[2][0] ||
					temp == text[3][0]
				) { stack[pointer++] = temp; }
				else if(temp == text[0][1]) {
					if(pointer > 0 && stack[pointer - 1] == text[0][0]) {
						stack[pointer--] = '0';
					} else {
						able = 0;
						break;
					}
				}
				else if(temp == text[1][1]) {
					if(pointer > 0 && stack[pointer - 1] == text[1][0]) {
						stack[pointer--] = '0';
					} else {
						able = 0;
						break;
					}
				}
				else if(temp == text[2][1]) {
					if(pointer > 0 && stack[pointer - 1] == text[2][0]) {
						stack[pointer--] = '0';
					} else {
						able = 0;
						break;
					}
				}
				else if(temp == text[3][1]) {
					if(pointer > 0 && stack[pointer - 1] == text[3][0]) {
						stack[pointer--] = '0';
					} else {
						able = 0;
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + able);
		}
		br.close();
	}
}
