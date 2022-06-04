import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static class Node implements Comparable<Node>{
        int person;
        int value;
        public Node(int person, int value){
            this.person = person;
            this.value = value;
        }
        public int compareTo(Node n){
            return n.value - this.value;
        }
    }
    private static int N,M;
    private static LinkedList<Node> rate[];
    private static Node[] rank;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rate = new LinkedList[N + 1];
        rank = new Node[N + 1];
        for (int i = 0; i < N + 1; i++) {
            rank[i] = new Node(i, 0);
        }
        for(int i = 1; i < N + 1; ++i){
            rate[i] = new LinkedList<>();
        }
        int t,s;
        for(int i = 0; i < M; ++i){
            st = new StringTokenizer(bf.readLine());
            t = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            rate[s].add(new Node(t, 1));
        }
        for(int i = 1; i < N + 1; ++i){
            for(int j = 0; j < rate[i].size(); ++j){
                rank[rate[i].get(j).person] = new Node(rate[i].get(j).person, rate[i].get(j).value + 1);
            }
        }
        Arrays.sort(rank, Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            System.out.print(rank[i].person + " ");
        }

    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}