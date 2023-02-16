package BAEKJOON;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class p7576 {
    //문제풀이 : 상하좌우 4가지 방향을 배열을 사용해서 나타낸다.
    //BFS 탐색을 통해서 4가지 방향을 모두 탐색한다.

    static int[][] tomatoBox;
    static Queue<Tomato1> queue;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //가로 세로를 입력받는다.
        String[] nums = br.readLine().split(" ");

        m = Integer.parseInt(nums[0]);
        n = Integer.parseInt(nums[1]);

        tomatoBox = new int[n][m];

        queue = new LinkedList<Tomato1>();
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoBox[i][j] == 1) {
                    //토마토가 1, 익은 것이라면 큐에 insert
                    Tomato1 t = new Tomato1(i,j);
                    queue.add(t);
                }
            }
        }
        bw.write(bfs()+"\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static int bfs() {

        while(queue.isEmpty() == false) {
            Tomato1 t = queue.poll();
            int x = t.x;
            int y = t.y;
            for(int i = 0 ; i < 4 ; i++) {
                int nr = x+dr[i];
                int nc = y+dc[i];


                if(nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    if(tomatoBox[nc][nr] == 0) {
                        //익은 토마토를 추가한다.
                        queue.add(new Tomato1(nc,nr));
                        //이전 토마토에서 날짜 + 1을 해서 익은 날짜를 계산한다.
                        tomatoBox[nc][nr] = tomatoBox[y][x] + 1;
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(tomatoBox[i][j] == 0) {
                    return -1;
                }
                //최댓값을 구하면 전체 토마토가 언제 익는지 알 수 있음.
                if(answer < tomatoBox[i][j]) {
                    answer = tomatoBox[i][j];
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

class Tomato1 {
    int x;
    int y;

    Tomato1(int y, int x) {
        this.x = x;
        this.y = y;

    }
}
