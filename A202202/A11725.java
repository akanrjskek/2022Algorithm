package A202202;
<<<<<<< HEAD

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class A11725 {
    private static int N;
    private static LinkedList<Integer> node[];
    private static boolean[] visit;
    private static int[] parent;

    private static void DFS(int n){

        for(int i = 0; i < node[n].size(); ++i){
            if(visit[node[n].get(i)]) continue;
            visit[node[n].get(i)] = true;
            parent[node[n].get(i)] = n;
            DFS(node[n].get(i));
        }
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bf.readLine());
        node = new LinkedList[N + 1];
        for(int i = 1; i < N + 1; ++i){
            node[i] = new LinkedList<>();
        }

        parent = new int[N + 1];
        visit = new boolean[N + 1];

        int n1,n2;
        for(int i = 0; i <N - 1; ++i){
            st = new StringTokenizer(bf.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            node[n1].add(n2);
            node[n2].add(n1);
        }
        visit[1] = true;
        DFS(1);
        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }


    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
=======
public class A11725 {
>>>>>>> 2b0bf38 (mac)
}
