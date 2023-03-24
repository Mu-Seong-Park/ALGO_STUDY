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
    // 1. 모든 배열을 탐색한다. -> root 노드의 거리와는 상관없으므로 bfs, dfs 어느것을 사용하든 괜찮을듯.
    // 2. 탐색한 값을 저장한다.
    // 3. 탐색 과정에서 해가 될 수 없는(옆집과 같은 색깔이라던가) 순서는 break하여 탐색하지 않는다.
    // 색깔 비용 배열은 [순서][색깔]의 형태로 2차원 배열을 선언한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        //R G B 순서로 비용 값을 저장한다.
        for(int i = 0 ; i < n ; i++) {
            String[] rgb = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(rgb[0]);
            cost[i][1] = Integer.parseInt(rgb[1]);
            cost[i][2] = Integer.parseInt(rgb[2]);
        }




        br.close();
        bw.flush();
        bw.close();
    }

    //도색하는 비용 cost 배열과 집의 갯수 n을 parameter로 받는다.
    static void bfs(int[][] cost,int n) {

        Queue<Integer> queue = new LinkedList<>();
        Hashtable<Integer, Integer> memo = new Hashtable<>();
        queue.offer(0);

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                cost[i][j] = ;
            }
        }

    }

    static void dfs(int[][] cost) {

    }
}
//
//red = new int[n];
//        blue = new int[n];
//        green = new int[n];
//
//        for(int i = 0 ; i < n ; i++) {
//        String[] nums = br.readLine().split(" ");
//        red[i] = Integer.parseInt(nums[0]);
//        blue[i] = Integer.parseInt(nums[1]);
//        green[i] = Integer.parseInt(nums[2]);
//        }
