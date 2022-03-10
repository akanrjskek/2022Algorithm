package A202203;

import java.io.*;
import java.util.*;

public class A1707 {
    private static int K,V,E,v1,v2;
    private static LinkedList<Integer> link[];
    private static int[] visit;
    private static Queue<Integer> q  = new LinkedList<>();

    private static void BFS(){
        q = new LinkedList<>();
        for(int i=1; i< V+1; i++) {
            if(visit[i]==0) {
                visit[i] =1;
                q.add(i);
            }

            while(!q.isEmpty()) {
                int pos = q.poll();

                for(int next : link[pos]) {
                    if(visit[next] == visit[pos]) {
                        System.out.println("NO");
                        return;
                    }

                    if(visit[next] ==0) {
                        q.add(next);

                        if(visit[pos]==1) {
                            visit[next] =2;
                        }else {
                            visit[next] =1;
                        }
                    }
                }
            }
        }

        System.out.println("YES");
    }

    public static void main(String[] args) throws Exception{
        K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visit = new int[V + 1];
            link = new LinkedList[V + 1];
            for (int j = 1; j < V + 1; j++) {
                link[j] = new LinkedList<>();
            }
            for(int k = 0; k < E; ++k){
                st = new StringTokenizer(bf.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                link[v1].add(v2);
                link[v2].add(v1);
            }
            BFS();
        }
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
