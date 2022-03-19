package A202203;

import java.io.*;
import java.util.*;

public class A1946 {
    static class Person implements Comparable<Person>{
        int first;
        int second;

        Person(int first, int second){
            this.first = first;
            this.second = second;
        }

        public int compareTo(Person p){
            return this.first - p.first;
        }
    }

    private static int T;
    private static int N;
    private static Person[] people;
    private static int cnt;
    private static int min;

    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; ++i){
            N = Integer.parseInt(bf.readLine());
            people = new Person[N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(bf.readLine());
                int f = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                people[j] = new Person(f,s);
            }
            Arrays.sort(people);
            cnt = 1;
            min = people[0].second;
            for (int j = 1; j < N; j++) {
                if(min > people[j].second){
                    cnt++;
                    min = people[j].second;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
}
