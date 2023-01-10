package BAEKJOON;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class p1654 {
    //풀이방법: 랜선의 길이를 정렬한다.
    //
    //
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] count = br.readLine().split(" "); // 랜선의 개수에 대한 입력을 저장.
        int k = Integer.parseInt(count[0]); // 가지고 있는 랜선의 개수를 저장.
        int n = Integer.parseInt(count[1]); // 필요한 랜선의 개수 저장.
        ArrayList<Integer> lineLength = new ArrayList<>(); //가지고 있는 랜선의 길이를 저장할 ArrayList

        for(int i = 0 ; i < k ; i++)
        {
            lineLength.add(Integer.parseInt(br.readLine()));
        }





        bw.flush();
        bw.close();
        br.close();

    }
}
