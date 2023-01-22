package BAEKJOON;

import java.io.*;

public class p7569 {
    //풀이방법: 3차원 배열을 사용해서 토마토의 상태를 저장한다.
    //상하좌우전후, 6가지 방향을 배열을 사용해서 나타낸다.
    //DFS 탐색을 통해서 6가지 방향을 모두 탐색한다.
    //탐색할 때, visited 배열을 만들어서 방문한 노드는 true로 저장한다.
    //

    static boolean[][][] visited; // 방문했는지 결과를 저장하는 배열.
    static int[][][] tomatoBox;// 토마토의 상태를 저장하는 배열.
    static int n; // 가로
    static int m; // 세로
    static int h; // 높이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //가로 세로 높이를 입력받는다.
        String[] nums = br.readLine().split(" ");
        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);
        h = Integer.parseInt(nums[2]);

        for(int i = 0 ; i < h ; i++) {
            for(int j = 0 ; j < m ; j++) {
                for(int k = 0 ; k < n ; k++) {

                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(int x, int y, int z) {
        //x,y,z 3가지 좌표로 가로 세로 높이를 나타낸다.
        visited[x][y][z] = true; //방문함을 저장한다.

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {

            }
        }
    }
}
