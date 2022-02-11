package A202202;

import java.io.*;
import java.util.*;

public class A1987 {

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
    private static int R,C;
    private static char[][] alpha;
    private static boolean[][] visit;
    private static int[] a;
    private static int max = -100000000;

    private static void DFS(int x, int y, int cnt){

        for(int i = 0; i < 4; ++i){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx < 0 || ty < 0 || tx >= R || ty >= C || a[alpha[tx][ty] - 65] == 1) continue;
            a[alpha[tx][ty] - 65] = 1;
            DFS(tx,ty,cnt + 1);
            a[alpha[tx][ty] - 65] = 0;
        }
        max = max < cnt ? cnt : max;




    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = new char[R][C];
        a = new int[26];
        for(int i = 0; i < R; ++i) {
            alpha[i] = bf.readLine().toCharArray();
        }
        a[alpha[0][0] - 65] = 1;
        DFS(0,0, 1);
        System.out.println(max);
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
