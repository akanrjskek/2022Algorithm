package A202203;
import java.io.*;
import java.util.*;

public class A11055 {
    private static int N;
    private static int[] nums,sums;
    private static boolean flag = false;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bf.readLine());
        nums = new int[N + 1];
        sums = new int[N + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        sums[1] = nums[1];

        for(int i = 2; i <= N; ++i){
            sums[i] = nums[i];
            for(int j = 1; j < i; ++j){
                if(nums[i] > nums[j]){
                    sums[i] = Math.max(nums[i] + sums[j], sums[i]);
                }
            }
        }

        Arrays.sort(sums);
        System.out.println(sums[N]);

    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
}
