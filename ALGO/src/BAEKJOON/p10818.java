package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class p10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();

        String[] list = br.readLine().split(" ");

        for(int i = 0 ; i < n ; i++) {
            nums.add(Integer.parseInt(list[i]));
        }

        Collections.sort(nums);

        bw.write(nums.get(0)+" "+nums.get(n-1));


        br.close();
        bw.close();
    }
}
