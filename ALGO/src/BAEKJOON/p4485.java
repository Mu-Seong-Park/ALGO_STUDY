package BAEKJOON;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;

public class p4485 {
    //문제풀이
    //전형적인 다익스트라(데이크스트라) 문제.
    //모든 노드(정점)를 탐색하면서 상하좌우 방향으로 최소비용을 업데이트하면서 이동한다.

    static Pos[] dir = {new Pos(0,-1), new Pos(0,1), new Pos(-1,0), new Pos(1,0)};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                break;
            }

            int[][] cave = new int[n][n];
            for(int i = 0 ; i < n ; i++) {
                String[] rupees = br.readLine().split(" ");
                for(int j = 0 ; j < n ; j++) {
                    cave[i][j] = Integer.parseInt(rupees[j]);
                }
            }


        }
        br.close();
        bw.flush();
        bw.close();
    }
    static void dijkstra(int[][] cave,int n) {
        Hashtable<Pos,Integer> cheapestPriceTable = new Hashtable<>();
        Hashtable<Pos,Pos> cheapestPreviousPosTable = new Hashtable<>();

        //시작 위치는 좌측 상단 0,0
        Pos startPos = new Pos(0,0);

        //현재 위치를 나타내는 변수, 처음에는 startPos를 가리킨다.
        Pos currentPos = startPos;

        //방문했던 위치를 저장할 배열
        boolean[][] visited = new boolean[n][n];

        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < n ; j++) {
                visited[i][j] = false;
            }
        }


        cheapestPriceTable.put(currentPos,cave[0][0]);
        //동굴의 마지막 탐사가 끝날 때까지 반복
        while(currentPos.x != n - 1 && currentPos.y != n - 1) {
            visited[currentPos.x][currentPos.y] = true;
            int priceThroughCurrentPos = -1;
            //상하좌우로 인접한 배열(노드)에 방문.
            for(int i = 0 ; i < 4 ; i++) {

                Pos adjacent = new Pos(currentPos.x + dir[i].x,currentPos.y + dir[i].y);
                //상하좌우의 좌표가 cave를 넘어가는 범위를 제외해야함.
                if(adjacent.x >= 0 && adjacent.x < n && adjacent.y >= 0 && adjacent.y < n) {
                    //직전의 위치에서 현재 위치의 비용을 더한 값.
                    priceThroughCurrentPos = cheapestPriceTable.get(currentPos) + cave[adjacent.x][adjacent.y];

                    Integer temp = cheapestPriceTable.putIfAbsent(adjacent, priceThroughCurrentPos);
                    if(temp != null) {
                        if(priceThroughCurrentPos < temp) {
                            cheapestPriceTable.replace(adjacent,priceThroughCurrentPos);
                            //가장 낮은 비용
                            cheapestPreviousPosTable.put(adjacent,currentPos);
                        }
                    }
                }
            }
        }

    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
