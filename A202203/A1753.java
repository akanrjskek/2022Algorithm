package A202203;
import java.io.*;
import java.util.*;

public class A1753 {
    static class Node implements Comparable<Node>{
        int v2;
        int weight;

        Node(int v2, int weight){
            this.v2 = v2;
            this.weight = weight;
        }

        public int compareTo(Node o){
            return this.weight - o.weight;
        }

    }

    private static void dijkstra(){
        flag = new boolean[V + 1];
        distance = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(flag[n.v2]) continue;
            flag[n.v2] = true;
            for (Node curnode : link[n.v2]) {
                if(distance[curnode.v2] > distance[n.v2] + curnode.weight){
                    distance[curnode.v2] = distance[n.v2] + curnode.weight;
                    pq.add(new Node(curnode.v2, distance[curnode.v2]));
                }
            }
        }
    }

    private static int V,E,start,s,e,w;
    private static ArrayList<Node> link[];
    private static int[] distance;
    private static boolean[] flag;
    private static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(bf.readLine());
        link = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            link[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            link[s].add(new Node(e,w));
        }
        dijkstra();
        for (int i = 1; i < V + 1; i++) {
            if(distance[i] != Integer.MAX_VALUE) System.out.println(distance[i]);
            else System.out.println("INF");
        }
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
