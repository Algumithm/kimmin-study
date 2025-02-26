import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] ARR;
	static boolean[] VISITED;
	static int N;
	static int M;
	
	static void dfs(int length, int size, int depth, int current) {
		if(depth == M){
			for(int val:ARR) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = current; i < length; i++) {
			if(VISITED[i] == false) {
				VISITED[i] = true;
				ARR[depth] = i + 1;
				dfs(length, size, depth + 1, ARR[depth]);
				VISITED[i] = false;
			}
		}
		return;
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ARR = new int[M];
		VISITED = new boolean[N];
		
		dfs(N, M, 0, 0);
		
		br.close();
	}
}
