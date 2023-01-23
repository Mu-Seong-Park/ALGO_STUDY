package BAEKJOON;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7569 {
    //풀이방법: 3차원 배열을 사용해서 토마토의 상태를 저장한다.
    //상하좌우전후, 6가지 방향을 배열을 사용해서 나타낸다.
    //BFS 탐색을 통해서 6가지 방향을 모두 탐색한다.

    static int[][][] tomatoBox;// 토마토의 상태를 저장하는 배열.
    static int n; // 가로
    static int m; // 세로
    static int h; // 높이

    //전후상하좌우 방향
    static int[] dr = {-1,1,0,0,0,0};
    static int[] dc = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    static Queue<tomato> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //가로 세로 높이를 입력받는다.
        String[] nums = br.readLine().split(" ");
        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);
        h = Integer.parseInt(nums[2]);

        tomatoBox = new int[h][m][n];
        q = new LinkedList<tomato>();

        //토마토의 위치 저장.
        for(int i = 0 ; i < h ; i++) {
            for(int j = 0 ; j < m ; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < n ; k++) {
                    tomatoBox[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomatoBox[i][j][k] == 1) {
                        //토마토가 1, 익은 것이라면 큐에 insert
                        q.add(new tomato(i,j,k));
                    }
                }
            }
        }

        bw.write(bfs()+"\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static int bfs() {
        //큐에 저장한 토마토가 없어질 때까지 탐색.
        while(q.isEmpty() == false) {
            tomato t = q.poll();

            int z = t.z;
            int x = t.x;
            int y = t.y;
            for(int i = 0 ; i < 6 ; i++) {
                int nr = x+dr[i];
                int nc = y+dc[i];
                int nh = z+dh[i];

                if(nr >= 0 && nc >= 0 && nh >= 0 && nh < h && nr < m && nc < n) {
                    if(tomatoBox[nh][nr][nc] == 0) {
                        //익은 토마토를 추가한다.
                        q.add(new tomato(nh,nr,nc));
                        //이전 토마토에서 날짜 + 1을 해서 익은 날짜를 계산한다.
                        tomatoBox[nh][nr][nc] = tomatoBox[z][x][y] + 1;
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0 ; i < h ; i++) {
            for(int j = 0 ; j < m ; j++) {
                for(int k = 0 ; k < n ; k++) {
                    if(tomatoBox[i][j][k] == 0) {
                        return -1;
                    }
                    //최댓값을 구하면 전체 토마토가 언제 익는지 알 수 있음.
                    if(answer < tomatoBox[i][j][k]) {
                        answer = tomatoBox[i][j][k];
                    }
                }
            }
        }
        if(answer == 1) {
            //토마토가 처음부터 익은 경우
            return 0;
        }
        else {
            //토마토가 익은것이 1부터 시작하기 때문에 answer - 1이 최종 걸린 날짜.
            return answer - 1;
        }
    }
}

class tomato {
    int x;
    int y;
    int z;

    tomato(int z, int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;

    }
}

//        for(int i = 0 ; i < h ; i++) {
//            for(int j = 0 ; j < m ; j++) {
//
//                for(int k = 0 ; k < n ; k++) {
//                    bw.write(tomatoBox[i][j][k]+" ");
//                }
//                bw.write("\n");
//            }
//        }
