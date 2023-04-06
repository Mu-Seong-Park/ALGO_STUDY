package BAEKJOON;

import java.io.*;

public class p11660 {
    //문제풀이
    // 생각 : 이 문제는 숫자도 크고, 1000개씩 for문 2번 반복해서 일일이 더하면 시간초과가 불보듯 뻔한다.
    // 1. 세로열(column)의 누적합을 이차원 배열에 저장한다.
    // 2. 필요한 부분의 마지막 원소 - 필요한 부분의 시작하는 원소 바로 위의 index 원소
    // 위의 연산을 진행하면 필요한 부분의 열 하나의 값을 얻을 수 있다.
    // 3. 위 과정을 행 갯수만큼 반복하면 결과값이 도출된다.
    // 문제풀이 수정
    // 위의 과정에서 열을 더한다고 했는데, 데이터를 입력하는 과정이 복잡해진다.
    // 행을 더하는 방법으로 수정한다.
    // 수정 ver2
    // 0번째 index를 0으로 비워두고, 예외처리를 덜 하는 방향으로 수정.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] matrix = new int[n][n];
        int[][] dp = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++) {
            String[] nums = br.readLine().split(" ");
            for(int j = 1 ; j <= n ; j++) {
                dp[i][j] = Integer.parseInt(nums[j - 1]) + dp[i][j - 1];
            }
        }

        for(int testCase = 0 ; testCase < m ; testCase++) {
            String[] nums = br.readLine().split(" ");
            int x1 = Integer.parseInt(nums[0]);
            int y1 = Integer.parseInt(nums[1]);
            int x2 = Integer.parseInt(nums[2]);
            int y2 = Integer.parseInt(nums[3]);

            long sum = 0;
            for(int i = x1 ; i <= x2 ; i++) {
                sum += (dp[i][y2] - dp[i][y1-1]);
            }

            bw.write(sum+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
