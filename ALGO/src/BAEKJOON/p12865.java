package BAEKJOON;

import java.io.*;
import java.util.Hashtable;

public class p12865 {
    // 문제풀이
    // 1. 준서가 버티는 무게 k를 기준으로 dp 사용.
    // 2. 배열을 2개 만든다, 무게 w를 저장하는 배열과 가치 v를 저장하는 배열.
    // 3. 배열의
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);
        Integer[][] dp = new Integer[n][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                dp[i][j] = null;
            }
        }
        for(int testCase = 0 ; testCase < n ; testCase++) {
            String[] valueKg = br.readLine().split(" ");
            int w = Integer.parseInt(valueKg[0]);
            int v = Integer.parseInt(valueKg[1]);
            dp[testCase][0] = v;
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
