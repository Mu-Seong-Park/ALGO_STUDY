package BAEKJOON;

import java.io.*;

public class p2270 {
    //문제풀이 : 가장 큰 디스크의 위치만 이동한다면 2^n인 문제가 2^(n-1)이 될 수 있다.
    //따라서 거정 큰 디스크의 위치를 중심으로 나머지 디스크를 옮겨야 한다.
    //목표 기둥에서 가장 큰 디스크부터 차례로 이어지는 디스크들은 무시해도 무방하다.
    //예를 들어 7,6,5,4와 같은 순이면 위의 것들을 다 무시하고 3부터 시작하면 되는 것이고
    //7,6,4와 같이 배치되어 있다면 5를 찾아서 4를 뽑고 끼워넣어야한다.
    //기저조건 :
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] state = br.readLine().split(" ");

        String[] aTemp = br.readLine().split(" ");
        String[] bTemp = br.readLine().split(" ");
        String[] cTemp = br.readLine().split(" ");


        int[] a = new int[aTemp.length];
        int[] b = new int[bTemp.length];
        int[] c = new int[cTemp.length];

        //몇 번째 기둥으로 옮겨야할지 저장할 변수.
        int main = 0;

        for(int i = 0 ; i < a.length ; i++) {
            a[i] = Integer.parseInt(aTemp[i]);
            if(a[i] == n) {
                main = 1;
            }
        }

        for(int i = 0 ; i < a.length ; i++) {
            b[i] = Integer.parseInt(bTemp[i]);
            if(b[i] == n) {
                main = 2;
            }
        }

        for(int i = 0 ; i < a.length ; i++) {
            c[i] = Integer.parseInt(cTemp[i]);
            if(c[i] == n) {
                main = 3;
            }
        }

        bw.write(main+"\n");

        if(main == 1) {
            for(int i = 0 ; i < a.length ; i++) {
                
            }

        } else if (main == 2) {

        } else {

        }

        bw.flush();
        bw.close();
        br.close();
    }
    static long hanoi(int n) {

        return ;
    }
}
