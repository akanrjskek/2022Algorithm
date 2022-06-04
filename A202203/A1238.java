package A202203;

import java.io.*;
import java.util.*;

public class A1238 {

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

    private static int N,M,X,s,e,w;
    private static boolean[] visit;
    private static int[] distance;
    private static PriorityQueue<Node> pq;
    private static ArrayList<Node> link[];
    private static int[] answer;
    private static void dijkstra(int start){
        pq = new PriorityQueue<>();
        visit = new boolean[N + 1];
        distance = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(visit[n.v2]) continue;
            visit[n.v2] = true;
            for (Node curnode : link[n.v2]) {
                if(distance[curnode.v2] > distance[n.v2] + curnode.weight){
                    distance[curnode.v2] = distance[n.v2] + curnode.weight;
                    pq.add(new Node(curnode.v2,distance[curnode.v2]));
                }
            }
        }
        if(start == X){
            for (int i = 1; i < N + 1; i++) {
                answer[i] += distance[i];
            }
        }
        else{
            answer[start] += distance[X];
        }

    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        distance = new int[N + 1];
        link = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            link[i] = new ArrayList<>();
        }
        answer = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            link[s].add(new Node(e,w));
        }
        for (int i = 1; i < N + 1; i++) {
            dijkstra(i);
        }
        Arrays.sort(answer);
        System.out.println(answer[N]);

    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
