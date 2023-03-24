package BAEKJOON;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class p1149 {
    //문제 조건: 집의 좌우는 같은 색을 사용할 수 없다.
    //집마다 rgb 각각의 색 비용이 다르다.
    //문제 풀이
    // 1. 누적합을 저장하는 배열을 둔다.
    // 2. 색깔을 하나 고르면 다음 순번은 남은 두 색깔에서 min인 값을 더하고 그 과정을 끝까지 반복한다.
    // 3. 이렇게 R, G, B 3가지 색깔을 골랐을 때 각각 비교하여 최소인 값을 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        //R G B 순서로 비용 값을 저장한다.
        for (int i = 0; i < n; i++) {
            String[] rgb = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(rgb[0]);
            cost[i][1] = Integer.parseInt(rgb[1]);
            cost[i][2] = Integer.parseInt(rgb[2]);
        }

        int[][] memo = new int[n][3];

        //index가 0인 경우(1번째 집) cost의 1번째 집 값으로 초기화한다.
        memo[0][0] = cost[0][0];
        memo[0][1] = cost[0][1];
        memo[0][2] = cost[0][2];

        for(int i = 1 ; i < n ; i++) {
            memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + cost[i][0];
            memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + cost[i][1];
            memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + cost[i][2];
        }

        bw.write(Math.min(memo[n-1][0],Math.min(memo[n-1][1],memo[n-1][2]))+"\n");


        br.close();
        bw.flush();
        bw.close();
    }
}