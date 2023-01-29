package BAEKJOON;

import java.io.*;

public class p9095 {
    //풀이방법: DP를 이용한다.
    //점화식을 구해야한다.
    // 이 문제의 경우 1, 2, 3이 고정적으로 이용된다.
    // 그렇기 때문에 우선 1, 2, 3을 만들 수 있는 경우의 수를 만들어야 한다고 한다.
    // 1 ={1}로 한 개, 2 = {1+1, 2}로 2개, 3 = {1+1+1, 1+2, 2+1, 3}으로 4개이다.
    // 그렇다면 4는 어떻게 만들 수 있을까? 고정된 수 세 개를 이용해 우선 4를 만들어 보려 한다면 4= 1+3 / 2+2 / 3+1이 된다.
    // 즉 1, 2, 3의 각 경우의 수에 +1, +2, +3을 해주기만 하면 4를 만들 수가 있는 것이다.
    // 각 경우의 수에 1, 2, 3만을 더해주므로 전체적인 경우의 수는 변합이 없게 되고 결과적으로 4 + 2 + 1로 7개라는 경우의 수가 발생한다.
    // 마지막으로 5를 예로 들어 보면 5 = 1+4 / 2+3 / 3+2로 5를 만들 수 있다. 즉 4의 경우의 수에 +1, 3의 경우의 수에 +2, 2의 경우의 수에 +3만 해주면 5를 만들 수 있다. 최종적으로 5의 경우의 수는 7 + 4 + 2로 13이 된다. 이를 통해 점화식을 유추해보면 dp [n] = dp [n-1] + dp [n-2] + dp [n-3]이라는 식을 세울 수 있다.
    //https://fbtmdwhd33.tistory.com/73
    static int[] dp = new int[11]; // 문제 조건에서 11보다 작은 수라고 하였기 때문에 크기는 11 고정.

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4 ; i < 11 ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for(int testCase = 0 ; testCase < t ; testCase++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
