package BAEKJOON;

import java.io.*;

public class p2579 {
    //풀이방법: DP를 사용한다.

    static Integer[] dp;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 계단의 갯수

        dp = new Integer[n+1];
        scores = new int[n+1];

        for(int i = 1 ; i < n+1 ; i++) {
            // 각 계단의 점수 저장
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = scores[0];
        dp[1] = scores[1];

        if( n >= 2) {
            dp[2] = scores[1] + scores[2];
        }

        bw.write(find(n)+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int n) {

        if(dp[n] == null) {
            //2칸 전의 점수 값과 (3칸 전의 값에 1칸 전의 값을 더한 값) 중에 더 큰 것을 골라서, 현재 밟고 있는
            //계단의 점수를 더해준다.
            dp[n] = Math.max(find(n - 2) , find(n - 3) + scores[n-1]) + scores[n];
        }

        return dp[n];
    }
}
