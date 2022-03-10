package A202203;

import java.io.*;
import java.util.*;

public class A2573 {
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};

    private static int n,m, cnt = 0, answer = 0;
    private static int[][] ice; // 계산되는 빙산
    private static boolean[][] present; // 현재 빙산
    private static boolean[][] visit; // 방문 여부
    private static boolean flag;

    private static void DFS(int x, int y){
        for(int i = 0; i < 4; ++i){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx < 0 || ty < 0 || tx >= n || ty >= m) continue;
            if(!present[tx][ty] && ice[x][y] > 0) {
                ice[x][y]--;
            }
        }

        for(int i = 0; i < 4; ++i){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx < 0 || ty < 0 || tx >= n || ty >= m) continue;
            if(!visit[tx][ty] && ice[tx][ty] != 0){
                visit[tx][ty] = true;
                DFS(tx,ty);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ice = new int[n][m];
        //visit = new boolean[n][m];
        present = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            flag = false;
            cnt = 0;
            visit = new boolean[n][m];
            present = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(ice[i][j] != 0) present[i][j] = true;
                }
            }
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j){
                    if(ice[i][j] != 0 && !visit[i][j]){
                        flag = true;
                        visit[i][j] = true;
                        DFS(i,j);
                        cnt++;
                    }
                }
            }
            if(!flag) {
                answer = 0;
                break;
            }
            if(cnt > 1) break;
            answer++;
        }
        System.out.println(answer);

    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
