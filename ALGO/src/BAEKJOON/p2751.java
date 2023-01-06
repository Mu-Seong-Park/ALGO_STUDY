package BAEKJOON;

import java.io.*;
import java.util.*;
public class p2751 {
    //collections의 timsort를 활용한다.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> num = new ArrayList<>();

        for(int i = 0 ; i < n ; i++)
        {
            num.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(num);

        for(int i = 0 ; i < n ; i++)
        {
            bw.write(num.get(i)+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
