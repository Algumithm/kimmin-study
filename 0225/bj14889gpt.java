import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int SIZE;
    static int[][] POTENTIAL;
    static boolean[] TEAM;  // 어떤 사람이 스타트 팀인지 여부 저장
    static int RESULT;

    static void makeTeam(int index, int count) {
        if (count == SIZE / 2) {  // N/2명을 고르면 비교 시작
            RESULT = Math.min(RESULT, teamPotential());
            return;
        }

        for (int i = index; i < SIZE; i++) {
            TEAM[i] = true;
            makeTeam(i + 1, count + 1);
            TEAM[i] = false;
        }
    }

    static int teamPotential() {
        int start = 0, link = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = i + 1; j < SIZE; j++) {
                if (TEAM[i] && TEAM[j]) {
                    start += POTENTIAL[i][j] + POTENTIAL[j][i];
                } else if (!TEAM[i] && !TEAM[j]) {
                    link += POTENTIAL[i][j] + POTENTIAL[j][i];
                }
            }
        }

        return Math.abs(start - link);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine());

        POTENTIAL = new int[SIZE][SIZE];
        TEAM = new boolean[SIZE];
        RESULT = Integer.MAX_VALUE;

        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                POTENTIAL[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeTeam(0, 0);

        System.out.println(RESULT);

        br.close();
    }
}
