package A202201;

import java.io.*;
import java.util.*;

public class A1012 {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static int T,M,N,K,cnt = 0;
    private static int[][] cabbage;
    private static boolean[][] visit;
    private static Queue<Node> q = new LinkedList<>();

    private static void BFS(int x, int y){
        q.add(new Node(x,y));
        visit[x][y] = true;
        while(!q.isEmpty()){
            Node n = q.poll();
            int tx,ty;
            for(int i = 0; i < 4; ++i){
                tx = n.x + dx[i];
                ty = n.y + dy[i];
                if(tx < 0 || ty < 0 || tx >= N || ty >= M || cabbage[tx][ty] == 0 || visit[tx][ty]) continue;
                q.add(new Node(tx,ty));
                visit[tx][ty] = true;
            }
        }
    }

    private static void DFS(int x, int y){
        for(int i = 0; i < 4; ++i){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx < 0 || ty < 0 || tx >= N || ty >= M || cabbage[tx][ty] == 0 || visit[tx][ty]) continue;
            visit[tx][ty] = true;
            DFS(tx,ty);
        }
    }

    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cabbage = new int[N][M];
            visit = new boolean[N][M];
            int x,y;
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(bf.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                cabbage[y][x] = 1;
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(cabbage[j][k] == 1 && !visit[j][k]){
                        //BFS(j,k);
                        visit[j][k] = true;
                        DFS(j,k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
