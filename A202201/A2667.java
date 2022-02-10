package A202201;

import java.io.*;
import java.util.*;

public class A2667 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void BFS(int x, int y){
        temp_cnt = 0;
        visit[x][y] = true;
        q.add(new Node(x,y));
        while(!q.isEmpty()){
            Node N = q.poll();
            temp_cnt++;
            for(int i = 0; i < 4; ++i){
                int tx = N.x + dx[i];
                int ty = N.y + dy[i];
                if(tx < 0 || ty < 0  || tx >= n || ty >= n || visit[tx][ty] || apt[tx][ty] == 0) continue;
                q.add(new Node(tx,ty));
                visit[tx][ty] = true;
            }
        }
        pq.add(temp_cnt);

    }
    private static int n;
    private static int cnt = 0;
    private static int temp_cnt= 0;
    private static int[][] apt;
    private static boolean[][] visit;
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static Queue<Node> q = new LinkedList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(bf.readLine());
        apt = new int[n][n];
        visit = new boolean[n][n];
        for(int i = 0; i < n; ++i){
            String s = bf.readLine();
            char[] c = s.toCharArray();
            for(int j = 0; j < n; ++j){
                apt[i][j] = c[j] - '0';
            }
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(!visit[i][j] && apt[i][j] == 1){
                    BFS(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
