package A202202;

import java.util.*;
import java.io.*;
public class A2644 {
    private static int n, m, start, end;
    private static LinkedList<Integer> link[];
    private static boolean[] visit;
    private static int answer = Integer.MAX_VALUE;

    private static void DFS(int s, int cnt){
        for(int i = 0; i < link[s].size(); ++i){
            if(visit[link[s].get(i)]) continue;
            visit[link[s].get(i)] = true;
            if(link[s].get(i) == end){
                answer = answer > cnt ? cnt : answer;
                return;
            }
            DFS(link[s].get(i), cnt + 1);
        }
    }

    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(bf.readLine());
        visit = new boolean[n + 1];
        link = new LinkedList[n + 1];
        for (int i = 0; i <= n ; i++) {
            link[i] = new LinkedList<>();
        }

        int a,b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            link[a].add(b);
            link[b].add(a);
        }
        visit[start] = true;
        DFS(start,1);
        if(answer != Integer.MAX_VALUE) System.out.println(answer);
        else System.out.println(-1);
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;


}
