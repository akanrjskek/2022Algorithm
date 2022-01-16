package A202201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class A2178 {
    static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static int N,M;
    private static int[][] maze;
    private static boolean[][] visit;
    private static int cnt = 0;
    private static Queue<Node> q = new LinkedList<>();

    private static void BFS(){
        q.add(new Node(0,0,1));
        visit[0][0] = true;
        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.x == N - 1 && n.y == M - 1){
                cnt = n.cnt;
                return;
            }
            for(int i = 0; i < 4; ++i) {
                int tx = n.x + dx[i];
                int ty = n.y + dy[i];
                if(tx < 0 || ty < 0 || tx >= N || ty >= M || maze[tx][ty] == 0 || visit[tx][ty]) continue;
                q.add(new Node(tx,ty,n.cnt + 1));
                visit[tx][ty] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; ++i){
            char[] c = bf.readLine().toCharArray();
            for(int j = 0; j < M; ++j){
                maze[i][j] = c[j] - '0';
            }
        }

        BFS();
        System.out.println(cnt);
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}