package A202201;
import java.io.*;
import java.util.*;

public class A2606 {
    private static int N,M,cnt = 0;
    private static LinkedList<Integer> link[];
    private static Queue<Integer> q = new LinkedList<>();
    private static boolean[] visit;

    private static void BFS(){
        q.add(1);
        visit[1] = true;
        while(!q.isEmpty()){
            int n = q.poll();
            for(int i = 0; i < link[n].size(); ++i){
                if(!visit[link[n].get(i)]){
                    q.add(link[n].get(i));
                    visit[link[n].get(i)] = true;
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        link = new LinkedList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            link[i] = new LinkedList<>();
        }
        visit = new boolean[N + 1];
        int x,y;
        for(int i = 0; i < M; ++i){
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            link[x].add(y);
            link[y].add(x);
        }
        BFS();
        System.out.println(cnt);
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
