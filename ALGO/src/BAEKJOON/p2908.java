package BAEKJOON;

import java.io.*;

public class p2908 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        StringBuffer sb1 = new StringBuffer(nums[0]);
        StringBuffer sb2 = new StringBuffer(nums[1]);
        int a = Integer.parseInt(sb1.reverse().toString());
        int b = Integer.parseInt(sb2.reverse().toString());

        if(a > b) {
            bw.write(a+"\n");
        }
        else {
            bw.write(b+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
