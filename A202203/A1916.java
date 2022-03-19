package A202203;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class A1916 {

    static class Node implements Comparable<Node>{
        int v2;
        int weight;

        Node(int v2, int weight){
            this.v2 = v2;
            this.weight = weight;
        }

        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }

    private static void dijkstra(){
        visit = new boolean[N + 1];
        distance = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node curnode = pq.poll();
            if(visit[curnode.v2]) continue;
            visit[curnode.v2] = true;
            for(Node n : link[curnode.v2]){
                if(distance[n.v2] > distance[curnode.v2] + n.weight){
                    distance[n.v2] = distance[curnode.v2] + n.weight;
                    pq.add(new Node(n.v2,distance[n.v2]));
                }
            }
        }
    }

    private static int N,M,s,e,w,start,end;
    private static boolean[] visit;
    private static int[] distance;
    private static ArrayList<Node> link[];
    private static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        link = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            link[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            link[s].add(new Node(e, w));
            //link[e].add(new Node(s, w));
        }
        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra();
        System.out.println(distance[end]);


    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
