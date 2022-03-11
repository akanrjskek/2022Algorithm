package A202203;

import java.io.*;
import java.util.*;

public class A2805 {
    private static int N,M;
    private static int[] tree;

    private static boolean sum(int m){
        int s = 0;
        for (int i = 0; i < N; i++) {
            if(tree[i] > m){
                s += tree[i] - m;
                if(s >= M) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1;
        int end = 1000000000;
        while(start <= end){
            int mid = (start + end) / 2;
            if(sum(mid)){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        System.out.println(end);

    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
