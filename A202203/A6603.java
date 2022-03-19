package A202203;

import java.io.*;
import java.util.*;

public class A6603 {
    private static int n;
    private static int[] nums;
    private static int[] lotto;

    private static void combination(int index, int cnt){
        if(cnt == 6){
            for (int i = 0; i < 6; i++) {
                sb.append(lotto[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < n; i++) {
            lotto[cnt] = nums[i];
            combination(i + 1, cnt + 1);
        }
    }

    public static void main(String[] args) throws Exception{
        while(true){
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            nums = new int[n];
            lotto = new int[6];
            for(int i = 0; i < n; ++i){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            combination(0,0);
            sb.append("\n");
        }
        System.out.println(sb);

    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
}
