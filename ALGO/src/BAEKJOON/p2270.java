package BAEKJOON;

import java.io.*;

public class p2270 {
    //문제풀이 : 가장 큰 디스크의 위치만 이동한다면 2^n인 문제가 2^(n-1)이 될 수 있다.
    //따라서 거정 큰 디스크의 위치를 중심으로 나머지 디스크를 옮겨야 한다.
    //목표 기둥에서 가장 큰 디스크부터 차례로 이어지는 디스크들은 무시해도 무방하다.
    //예를 들어 7,6,5,4와 같은 순이면 위의 것들을 다 무시하고 3부터 시작하면 되는 것이고
    //7,6,4와 같이 배치되어 있다면 5를 찾아서 1번 기둥에 놓고, 나머지를 2번 기둥에 몰아 넣은 뒤
    //3번에 7654와 같은 순으로 정렬한다.
    //전체 디스크의 위치를 표현하는 배열이 필요하다.
    //기저조건 : 옮겨야할 디스크의 개수가 0인 경우.

    //원판의 위치 저장 배열
    static int[] pos;

    //2의 n제곱들을 저장할 배열
    static int[] num = new int[100001];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] state = br.readLine().split(" ");

        String[] aTemp = br.readLine().split(" ");
        String[] bTemp = br.readLine().split(" ");
        String[] cTemp = br.readLine().split(" ");

        pos = new int[n+1];
        cal(n);

        for(int i = 0 ; i < aTemp.length ; i++) {
            pos[Integer.parseInt(aTemp[i])] = 1;
        }

        for(int i = 0 ; i < bTemp.length ; i++) {
            pos[Integer.parseInt(bTemp[i])] = 2;
        }

        for(int i = 0 ; i < cTemp.length ; i++) {
            pos[Integer.parseInt(cTemp[i])] = 3;
        }
        //몇 번째 기둥으로 옮겨야할지 저장할 변수.
        int main = pos[n];

        hanoi(n,pos[n]);

        bw.write(main+"\n");
        bw.write(answer+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void cal(int n) {
        num[0] = 1;
        for(int i = 1; i < n ; i++) {
            num[i] = (num[i-1] * 2) % 1000000;
        }
    }
    static void hanoi(int n, int to) {

        if(n == 0) {
            //디스크가 없는 경우가 기저조건
            return;
        }

        //가장 큰 디스크의 위치 -> 현재 있는 기둥
        int now = pos[n];
        //목표와 시작 기둥을 제외한 temp 기둥.
        int temp = 0;

        for(int i = 1 ; i <= 3 ; i++) {
            if(now != i && to != i) {
                //목적 기둥과 현재 기둥을 제외한 것이 임시 기둥.
                temp = i;
            }
        }

        if(now == to) {
            hanoi(n - 1, to);
        }
        else {
            answer = (answer + num[n -1]) % 1000000;
            hanoi(n - 1, temp);
        }
        return ;
    }
}
