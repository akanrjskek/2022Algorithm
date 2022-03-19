package A202203;

import java.io.*;
import java.util.*;

public class A9012 {
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(bf.readLine());
        int cnt = 0;
        for (int i = 0; i < T; i++) {
            cnt = 0;
            char[] ch;
            ch = bf.readLine().toCharArray();
            int j;
            if (ch[0] == ')') {
                sb.append("NO\n");
            }
            else{
                for (j = 0; j < ch.length; j++) {
                    if (ch[j] == '(') {
                        cnt++;
                    } else {
                        cnt--;
                    }
                    if (cnt < 0) {
                        sb.append("NO\n");
                        break;
                    }
                }
                if (j == ch.length) {
                    if (cnt == 0) sb.append("YES\n");
                    else sb.append("NO\n");
                }
            }


        }
        System.out.println(sb);
    }

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

}
