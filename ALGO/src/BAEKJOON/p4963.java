package BAEKJOON;

import java.io.*;

public class p4963 {
    static int[][] map;
    //상, 우상단, 우, 우하단, 하, 좌하단, 좌, 좌상단의 순서
    static int[] dirRow = {0,1,1,1,0,-1,-1,-1};
    static int[] dirCol = {-1,-1,0,1,1,1,0,-1};
    static int result;

    static  int row;
    static  int col;

    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String[] nums = br.readLine().split(" ");
            row = Integer.parseInt(nums[0]);
            col = Integer.parseInt(nums[1]);

            if(row == 0 && col == 0) {
                break;
            }


            map = new int[col][row];
            check = new boolean[col][row];
            result = 0;

            for(int i = 0 ; i < col ; i++) {
                nums = null;
                nums = br.readLine().split(" ");
                for(int j = 0 ; j < row ; j++) {
                    map[i][j] = Integer.parseInt(nums[j]);
                }
            }

            for(int i = 0 ; i < col ; i++) {
                for(int j = 0 ; j < row ; j++) {
                     if(map[i][j] == 1 && !check[i][j]) {
                         dfs(i,j);
                         result++;
                     }
                }
            }

            bw.write(result+"\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y) {

        check[x][y] = true;

        for(int i = 0 ; i < 8 ; i++) {
            int nX = x + dirRow[i];
            int nY = y + dirCol[i];

            if(nX >= 0 && nY >= 0 && nX < col && nY < row) {
                if(map[nX][nY] == 1 && !check[nX][nY]) {
                    dfs(nX,nY);
                }
            }
        }



    }
}

//class Pos {
//    private int row;
//    private int col;
//    public Pos(int row, int col) {
//        this.row = row;
//        this.col = col;
//    }
//
//    public int getRow() {
//        return row;
//    }
//
//    public int getCol() {
//        return col;
//    }
//}