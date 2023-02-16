package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

public class p1012 {
    //풀이방법: 상하좌우를 이동하는 배열을 만든다.
    //상하좌우로 이동하면서 배추가 있고 방문하지 않은 곳을 DFS 탐색한다.

    static boolean[][] visited;//방문한 노드를 확인하기 위한 변수.
    static int[][] field;//현재 밭의 상태를 저장.
    static int m; // 가로
    static int n; // 세로
    static int k; //배추의 위치 개수
    //상하좌우 이동을 위한 배열.
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int worm = 0; //지렁이 갯수를 저장.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());


        for(int test_case = 0 ; test_case < testCase ; test_case++) {
            String[] nums = br.readLine().split(" ");
            m = Integer.parseInt(nums[0]); // 가로
            n = Integer.parseInt(nums[1]); // 세로
            k = Integer.parseInt(nums[2]); //배추의 위치 개수

            field = new int[m][n]; //배추를 심을 밭의 정보, 0은 배추가 없고 1은 배추가 있음.
            visited = new boolean[m][n];
            for(int i = 0 ; i < k ; i++) {
                // 위치의 수 k만큼 field의 값을 설정.
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            int worms = 0;

            for(int i = 0 ; i < m ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    //DFS 탐색 실시.
                    if(field[i][j] == 1 && visited[i][j] == false) {
                        dfs(i,j);
                        worms++;
                    }
                }
            }

            bw.write(worms+"\n");
            bw.flush();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x,int y) {
        //방문한 노드는 true처리하고, 상하좌우를 탐색해서 0으로 둘러쌓인 하나의 구역을 찾아낸다.
        visited[x][y] = true;

        for(int i = 0 ; i < 4 ; i++) {
            int r = x+dr[i];
            int c = y+dc[i];

            if(r >= 0 && c >= 0 && r < m && c < n) {
                if(field[r][c] == 1 && visited[r][c] == false) {
                    dfs(r,c);
                }
            }
        }
    }
}
