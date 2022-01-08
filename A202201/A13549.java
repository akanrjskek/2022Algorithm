package A202201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A13549 {
    private static int N,K; // 수빈이의 위치, 동생의 위치
    private static int time = 0; //걸린 시간
    private static int[] location;
    private static boolean[] visit;
    private static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        location = new int[100001];
        visit = new boolean[100001];
        BFS();
    }

    private static void BFS(){
        q.add(N);
        int pre = 0;
        flag: while(!q.isEmpty()){
            pre = q.poll();
            if(pre == K) break;
            if(pre == 0){
                if(!visit[pre + 1]) {
                    q.add(pre + 1);
                    visit[pre + 1] = true;
                    location[pre + 1] = location[pre] + 1;
                }
            }
            else if(pre == 100000){
                if(!visit[pre - 1]) {
                    q.add(pre - 1);
                    visit[pre - 1] = true;
                    location[pre - 1] = location[pre] + 1;
                }
            }
            else{
                for(int i = pre * 2; i <= 100000; i *= 2){
                    location[i] = location[i/2];
                    if(!visit[i]) {
                        q.add(i);
                        visit[i] = true;
                        if(i == K) break flag;
                    }
                }
                if(!visit[pre + 1]) {
                    q.add(pre + 1);
                    visit[pre + 1] = true;
                    location[pre + 1] = location[pre] + 1;
                }
                if(!visit[pre - 1]) {
                    q.add(pre - 1);
                    visit[pre - 1] = true;
                    location[pre - 1] = location[pre] + 1;
                }

            }
        }
        System.out.println(location[pre]);
    }

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
