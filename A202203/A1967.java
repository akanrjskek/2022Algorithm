package A202203;

import java.io.*;
import java.util.*;

public class A1967 {

    static class Node{
        int v2;
        int weight;

        Node(int v2, int weight){
            this.v2 = v2;
            this.weight = weight;
        }
    }

    private static void DFS(int parent, int w){
        if(w > answer){
            answer = w;
            node = parent;
        }
        for (int i = 0; i < link[parent].size(); i++) {
            if(visit[link[parent].get(i).v2]) continue;
            visit[link[parent].get(i).v2] = true;
            DFS(link[parent].get(i).v2, w + link[parent].get(i).weight);
        }
    }

    private static int n,p,c,w,answer = 0,node;
    private static LinkedList<Node>[] link;
    private static int[][] cost; // 노드간 비용
    private static boolean[] visit;
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(bf.readLine());
        link = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) { // linkedlist 초기화
            link[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) { // input
            st = new StringTokenizer(bf.readLine());
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            link[p].add(new Node(c, w));
            link[c].add(new Node(p, w));
        }
        visit = new boolean[n + 1];
        visit[n - 1] = true;
        DFS(n - 1,0);
        visit = new boolean[n + 1];
        visit[node] = true;
        DFS(node,0);

        System.out.println(answer);
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
