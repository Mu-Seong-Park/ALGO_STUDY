package BAEKJOON;

import java.io.*;

public class p1149 {
    //문제 조건: 집의 좌우는 같은 색을 사용할 수 없다.
    //집마다 rgb 각각의 색 비용이 다르다.
    //백트래킹 문제로 추정

    static int[] red;
    static int[] blue;
    static int[] green;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        red = new int[n];
        blue = new int[n];
        green = new int[n];

        for(int i = 0 ; i < n ; i++) {
            String[] nums = br.readLine().split(" ");
            red[i] = Integer.parseInt(nums[0]);
            blue[i] = Integer.parseInt(nums[1]);
            green[i] = Integer.parseInt(nums[2]);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
