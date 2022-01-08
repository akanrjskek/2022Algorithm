package A202201;

import java.io.*;
import java.util.*;

class tomatoNode{
    int x;
    int y;
    public tomatoNode(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class A7576 {
    private static int dx[] = {-1,0,1,0};
    private static int dy[] = {0,1,0,-1};
    private static int N,M;
    private static int[][] tomato;
    private static boolean[][] visit;
    private static Queue<tomatoNode> q;
    private static int cnt = 1;
    private static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        visit = new boolean[N][M];
        q = new LinkedList<>();
        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M ;++j) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1) {
                    q.add(new tomatoNode(i,j));
                    visit[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            tomatoNode node = q.poll();
            int x = node.x;
            int y = node.y;
            for(int i = 0; i < 4; ++i) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if(tx >= 0 && ty >= 0 && tx < N && ty < M && tomato[tx][ty] != -1 && !visit[tx][ty]) {
                    q.add(new tomatoNode(tx,ty));
                    visit[tx][ty] = true;
                    tomato[tx][ty] = tomato[x][y] + 1;
                }
            }
        }
        flag : for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                if(tomato[i][j] == 0) {
                    answer = -1;
                    break flag;
                }
                else{
                    if(tomato[i][j] > answer) answer = tomato[i][j];
                }
            }
        }
        if(answer != -1) System.out.println(answer-1);
        else System.out.println(answer);




    }

}

