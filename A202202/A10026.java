package A202202;

import java.io.*;
import java.util.*;

public class A10026{
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void DFS(int x, int y, char c){
        visit[x][y] = true;
        Node n = new Node(x,y);
        for(int i = 0; i < 4; ++i){
            int tx = n.x + dx[i];
            int ty = n.y + dy[i];
            if(tx < 0 || ty < 0 || tx >= N || ty >= N || alpha1[tx][ty] != c || visit[tx][ty]) continue;
            visit[tx][ty] = true;
            DFS(tx, ty, c);
        }
    }

    private static void DFS2(int x, int y, char c){
        visit[x][y] = true;
        Node n = new Node(x,y);
        for(int i = 0; i < 4; ++i){
            int tx = n.x + dx[i];
            int ty = n.y + dy[i];
            if(tx < 0 || ty < 0 || tx >= N || ty >= N || alpha2[tx][ty] != c || visit[tx][ty]) continue;
            visit[tx][ty] = true;
            DFS2(tx, ty, c);
        }
    }


    private static int N;
    private static int cnt1, cnt2;
    private static char[][] alpha1;
    private static char[][] alpha2;
    private static boolean[][] visit;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bf.readLine());
        alpha1 = new char[N][N];
        alpha2 = new char[N][N];
        visit = new boolean[N][N];
        for(int i = 0; i < N; ++i){
            alpha1[i] = bf.readLine().toCharArray();
            for(int j = 0; j < N; ++j){
                if(alpha1[i][j] == 'R') alpha2[i][j] = 'G';
                else alpha2[i][j] = alpha1[i][j];
            }
        }

        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                if(!visit[i][j]){
                    DFS(i, j, alpha1[i][j]);
                    cnt1++;
                }
            }
        }
        sb.append(cnt1 + " ");
        cnt1 = 0;
        visit = new boolean[N][N];
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                if(!visit[i][j]){
                    DFS2(i, j, alpha2[i][j]);
                    cnt1++;
                }
            }
        }
        sb.append(cnt1);
        System.out.println(sb);

    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
}