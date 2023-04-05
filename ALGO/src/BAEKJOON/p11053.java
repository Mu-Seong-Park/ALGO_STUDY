package BAEKJOON;

import java.io.*;
import java.util.ArrayList;

public class p11053 {
    //문제풀이 : 최장 증가 부분 수열(LIS)
    // 1. 주어진 숫자 집합에서 각 숫자별로 선택했을 때, 앞에서부터 그 숫자까지 가질 수 있는 길이를 저장한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>  numSet = new ArrayList<>();
        String[] nums = br.readLine().split(" ");
        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++) {
            numSet.add(Integer.parseInt(nums[i]));
        }

        for(int i = 0 ; i < n ; i++) {
            LIS(i,dp,numSet);
        }

        int max = dp[0];

        for(int i = 1 ; i < n ; i++) {
            max = Math.max(max,dp[i]);
        }

        bw.write(max+"\n");


        bw.flush();
        bw.close();
        br.close();
    }

    static int LIS(int n, int[] dp, ArrayList<Integer> numSet) {

        if(dp[n] == 0) {
            dp[n] = 1;

            for(int i = n - 1 ; i >= 0 ; i--) {

                if(numSet.get(i) < numSet.get(n)) {
                    dp[n] = Math.max(dp[n], LIS(i,dp,numSet)+1);
                }
            }
        }

        return dp[n];
    }
}
