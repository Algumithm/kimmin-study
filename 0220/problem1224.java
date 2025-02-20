import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{			
			int length = Integer.parseInt(br.readLine());
			
			int pointer = 0;
			char[] stack = new char[length];
			
			char[] midCase = br.readLine().toCharArray();
			
			int endPointer = 0;
			char[] endCase = new char[length];
			
			// 후위 표기법 변환
			for(int i = 0; i < length; i++) {
				char mid = midCase[i];
				
				if(mid < '0') {
					if(mid == '(') {
						stack[pointer++] = mid;
					} else if(mid == ')') {
						while(true) {
							if(pointer > 0 && stack[--pointer] == '(') {
								stack[pointer] = '0';
								break;
							} else {
								endCase[endPointer++] = stack[pointer];
								stack[pointer] = '0';
							}
						}
					} else if(mid == '*') {
						while(true) {
							if(pointer > 0 && stack[pointer-1] == '*') {
								endCase[endPointer++] = stack[--pointer];
								stack[pointer] = '0';
							} else {
								stack[pointer++] = mid;
								break;
							}
						}
					} else if(mid == '+') {
						while(true) {
							if((pointer > 0 && stack[pointer-1] == '(') || pointer == 0) {
								stack[pointer++] = mid;
								break;
							} else {
								endCase[endPointer++] = stack[--pointer];
								stack[pointer] = '0';
							}
						}
					}
				} else {
					endCase[endPointer++] = mid;
				}
			}
			while(pointer-- > 0) {
				endCase[endPointer++] = stack[pointer];
				stack[pointer] = '0';
			}
			
			// 스택 초기화
			pointer = 0;
			int[] intStack = new int[endPointer];
			
			// 후위 표기법 연산
			for(int i = 0; i < endPointer; i++) {
				char end = endCase[i];
				
				if(end < '0') {
					int x = intStack[--pointer];
					stack[pointer] = '0';
					int y = intStack[--pointer];
					stack[pointer] = '0';
					
					if(end == '+') {
						intStack[pointer++] = x + y;
					} else if(end == '*')
						intStack[pointer++] = x * y;
				} else {
					intStack[pointer++] = end - '0';
				}
			}
			
//			// 확인용 출력
//			for(int i = 0; i < length; i++) {
//				System.out.print(midCase[i]);
//			}			
//			System.out.println();
//			
//			for(int i = 0; i < endPointer; i++) {
//				System.out.print(endCase[i]);
//			}
//			System.out.println();
			
			int result = intStack[0];
			
			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}
}
