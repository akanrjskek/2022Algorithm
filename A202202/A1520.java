package A202202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1520 {
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static int n,m,cnt = 0;
    private static int[][] map;
    private static int[][] dp;

    private static int DFS(int x,int y){
        if(x == n - 1 && y == m - 1){
            return 1;
        }
        if(dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 0;
        for(int i = 0; i < 4; ++i){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx < 0 || ty < 0 || tx >= n || ty >= m) continue;
            if(map[x][y] > map[tx][ty]) dp[x][y] += DFS(tx,ty);
        }
        return dp[x][y];
    }


    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0,0));

    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}