package A202203;

import java.io.*;
import java.util.*;

public class A1922 {

    static class Node implements Comparable<Node> {
        int v1;
        int v2;
        int weight;

        Node(int v1, int v2, int weight){
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }

    private static void init(){
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
    }

    private static int find(int v){
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }

    private static void Union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(x < y){
            parent[y] = x;
        }
        else{
            parent[x] = y;
        }
    }

    private static void Kruskal(){
        while(!pq.isEmpty()){
            if(cnt == N - 1) break;
            Node n = pq.poll();
            if(find(n.v1) == find(n.v2)) continue;
            Union(n.v1, n.v2);
            answer += n.weight;
            cnt++;

        }
    }

    private static int N,M,s,e,w;
    private static PriorityQueue<Node> pq = new PriorityQueue<>();
    private static int[] parent;
    private static int cnt = 0;
    private static int answer = 0;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            pq.add(new Node(s,e,w));
        }
        init();
        Kruskal();
        System.out.println(answer);
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
