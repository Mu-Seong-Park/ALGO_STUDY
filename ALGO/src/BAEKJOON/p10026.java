package BAEKJOON;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p10026 {
    //문제풀이
    //1. bfs로 완전탐색을 실시한다.
    //2. 색약인 사람은 조건을 붙여서, R과 G를 같은 색으로 처리한다.
    //3. 아닌 사람은 R,G,B로 구분한다.
    //4. for문을 사용하여 모든 노드를 시작 노드로 설정하여 탐색을 돌린다.
    //5. 위의 과정에서 visited 값이 true라면, break해서 시간을 줄인다.
    //4번과 5번 과정을 통해서 현재 영역이 몇개로 나누어져 있는지 알 수 있다.

    static String[][] mapWeak;
    static String[][] mapNormal;
    static boolean[][] isVisitedWeak;
    static boolean[][] isVisitedNormal;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        mapWeak = new String[n][n];
        mapNormal = new String[n][n];
        isVisitedWeak = new boolean[n][n];
        isVisitedNormal = new boolean[n][n];

        for(int i = 0 ; i < n ; i++) {
            String[] temp = br.readLine().split("");
            for(int j = 0 ; j < n ; j++) {
                if(temp[j].equals("G") || temp[j].equals("R")) {
                    mapWeak[i][j] = "R";
                } else {
                    mapWeak[i][j] = "B";
                }
            }
            mapNormal[i] = temp;
        }

        int weak = 0;
        int normal = 0;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(!isVisitedWeak[i][j]) {
                    MyNode start = new MyNode(i,j);
                    bfsColorWeakness(start,n);
                    weak++;
                }
            }
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(!isVisitedNormal[i][j]) {
                    MyNode start = new MyNode(i,j);
                    bfs(start,n);
                    normal++;
                }
            }
        }

        bw.write(normal+" "+weak);



        br.close();
        bw.flush();
        bw.close();
    }

    static void bfsColorWeakness(MyNode start, int n) {
        Queue<MyNode> myQueue= new LinkedList<>();
        myQueue.offer(start);
        isVisitedWeak[start.getX()][start.getY()] = true;
        while(!myQueue.isEmpty()) {
            MyNode currentNode = myQueue.poll();
            for(int i = 0 ; i < 4 ;i++) {
                int newX = currentNode.getX()+dx[i];
                int newY = currentNode.getY()+dy[i];
                if( newX >= 0 &&  newY >= 0 && newX < n && newY < n) {
                    if(mapWeak[newX][newY].equals(mapWeak[start.getX()][start.getY()])  && !isVisitedWeak[newX][newY]) {
                        myQueue.offer(new MyNode(newX,newY));
                        isVisitedWeak[newX][newY] = true;
                    }
                }
            }
        }


    }

    static void bfs(MyNode start, int n) {
        Queue<MyNode> myQueue= new LinkedList<>();
        myQueue.offer(start);
        isVisitedNormal[start.getX()][start.getY()] = true;
        while(!myQueue.isEmpty()) {
            MyNode currentNode = myQueue.poll();
            for(int i = 0 ; i < 4 ;i++) {
                int newX = currentNode.getX()+dx[i];
                int newY = currentNode.getY()+dy[i];
                if( newX >= 0 &&  newY >= 0 && newX < n && newY < n) {
                    if(mapNormal[newX][newY].equals(mapNormal[start.getX()][start.getY()]) && !isVisitedNormal[newX][newY]) {
                        myQueue.offer(new MyNode(newX,newY));
                        isVisitedNormal[newX][newY] = true;
                    }
                }
            }
        }
    }

    static class MyNode {
        private int x;
        private int y;

        public MyNode(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
