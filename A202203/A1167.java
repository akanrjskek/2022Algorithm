package A202203;

import java.io.*;
import java.util.*;

public class A1167 {

    static class Node{
        int v2;
        int weight;

        Node(int v2, int weight){
            this.v2 = v2;
            this.weight = weight;
        }
    }

    private static int V, vertex, e,w,longest_vertex,max_weight = 0;
    private static ArrayList<Node> link[];
    private static boolean[] visit;

    private static void DFS(int v, int sum){
        if(max_weight < sum){
            max_weight = sum;
            longest_vertex = v;
        }

        for (Node n : link[v]) {
            if(visit[n.v2]) continue;
            visit[n.v2] = true;
            DFS(n.v2, sum + n.weight);
        }
    }

    public static void main(String[] args) throws Exception{
        V = Integer.parseInt(bf.readLine());
        link = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            link[i] = new ArrayList<>();
        }
        visit = new boolean[V + 1];
        for(int i = 0; i < V; ++i){
            st = new StringTokenizer(bf.readLine());
            vertex = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                w = Integer.parseInt(st.nextToken());
                link[vertex].add(new Node(e,w));
            }
        }
        visit[1] = true;
        DFS(1,0);
        visit = new boolean[V + 1];
        visit[longest_vertex] = true;
        max_weight = 0;
        DFS(longest_vertex, 0);
        System.out.println(max_weight);
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
