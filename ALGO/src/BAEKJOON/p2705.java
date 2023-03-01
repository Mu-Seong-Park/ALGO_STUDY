package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class p2705 {
    //재귀를 사용한다.
    //기저조건 : n == 2,3이 되는 경우 무조건 2, n == 1인 경우는 1
    //중간의 숫자(m)을 기준으로 좌우에 얼마의 값이 남는지 계산하고 그 값이 가질 수 있는 펠린드롬파티션을
    //더하면 된다.
    //만약 n = 100이면, 호출하는 과정에서 5, 4 따위의 작은 숫자들은 굉장히 많은 호출이 될 것이고
    //이는 메모이제이션을 통해서 계산을 해결한다.

    //메모이제이션을 위한 ArrayList 선언
    static ArrayList<Integer> memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        memo = new ArrayList<>();
        //index를 n으로 사용하고, index = 0이면 0, 1,2,3이면 1과 2를 저장.
        //나머지는 null로 저장한다.(Integer 타입으로 저장한 이유)
        for(int i = 0 ; i < 1001 ; i++) {
            if(i == 0){
                memo.add(0,0);
            } else if(i == 1) {
                memo.add(1,1);
            } else if(i == 2) {
                memo.add(2,2);
            } else if(i == 3) {
                memo.add(3,2);
            } else {
                memo.add(i,null);
            }
        }

        for(int i = 0 ; i < testCase ; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(pelPar(n)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int pelPar(int n) {

        if(memo.get(n) == null) {
            //n에 대한 팰린드롬파티션이 없는 경우
            int value = 1;
            int temp = 0;
            for(int i = n ; i >= 0 ; i--) {
                //작은 펠린드롬파티션으로 나누어질 수 있는지 n부터 0까지 1씩 줄여가면서
                //확인한다.
                if((n - i) % 2 == 0) {
                    //짝수라면 팰린드롬파티션으로 나누어질 수 있기 때문에 모든 경우를 더한다.
                    temp = (n - i) / 2 ;
                    value = value + pelPar(temp);
                }
            }
            memo.add(n,value);
            return value;
        }
        else {
            return memo.get(n);
        }


    }
}
