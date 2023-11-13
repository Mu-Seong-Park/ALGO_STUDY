package BAEKJOON;

import java.io.*;

public class p9663 {

    static int[][] visited;
    static int result;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        visited = new int[n+1][n+1];
        result = 0;

        dfs(0,0,n);
        bw.write(""+result+"\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int startX,int startY,int queenCount) {
        if(queenCount == 0) {
            result++;
            return;
        }

        for(int i = startX ; i < n ; i++) {

        }
    }


}
