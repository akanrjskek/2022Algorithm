package A202203;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 아직 못푼 문제
public class A1941 {
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static int cnt = 0;
    private static char[][] princess;
    private static boolean[][] visit;
    private static boolean[][] revisit;

    private static void DFS(int i, int j, int s, int y){
        if(y == 4) return;
        if(s + y == 7){
            System.out.println(i + " " + j);
            cnt++;
            return;
        }

        for(int k = 0; k < 4; ++k){
            int tx = i + dx[k];
            int ty = j + dy[k];
            if(tx < 0 || ty < 0 || tx >= 5 || ty >= 5 || visit[tx][ty]) continue;
            visit[tx][ty] = true;
            if(princess[tx][ty] == 'S') DFS(tx, ty, s + 1, y);
            else DFS(tx, ty, s, y + 1);
            visit[tx][ty] = false;
        }

    }

    public static void main(String[] args) throws Exception{
        princess = new char[5][5];

        for (int i = 0; i < 5; i++) {
            princess[i] = bf.readLine().toCharArray();
        }

        revisit = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                visit = new boolean[5][5];
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if(revisit[k][l]) visit[k][l] = true;
                    }
                }
                if(!visit[i][j]){
                    if(princess[i][j] == 'S') DFS(i,j,1,0);
                    else DFS(i,j,0,1);
                }
                revisit[i][j] = true;
            }
        }
        System.out.println(cnt);
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

}
