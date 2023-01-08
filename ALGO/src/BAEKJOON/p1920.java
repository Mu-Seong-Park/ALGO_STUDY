package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class p1920 {
    //풀이방법: n개의 숫자를 입력받아서 문자열 배열로 저장한다.
    //ArrayList에 앞선 문자열 배열을 모두 Integer로 저장하여 Collections의 Timsort로 정렬한다.
    //m개의 숫자 또한 같은 방법으로 정렬한다.
    //두 ArrayList의 원소들을 비교해서 자신보다 큰 수가 나올때까지 검색해보고 나오지 않는다면 결과 배열에 0을 저장한다.
    //같은 숫자가 있다면 1을 저장한다.
    //오답 이유 : 메모리 초과 -> 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
    //위의 조건에서 배열을 만드는 과정에 오버플로우가 발생하는 것 같음.


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n개의 정수를 입력받고 정렬하는 과정
        int n = Integer.parseInt(br.readLine());
        String[] nNum = br.readLine().split(" ");
        ArrayList<Integer> nExample = new ArrayList<>();

        for(int i =0 ; i < n ; i++)
        {
            nExample.add(Integer.parseInt(nNum[i]));
        }

        Collections.sort(nExample);

        //m개의 정수를 입력받고 정렬하는 과정
        int m = Integer.parseInt(br.readLine());
        String[] mNum = br.readLine().split(" ");
        ArrayList<Integer> mExample = new ArrayList<>();

        for(int i =0 ; i < n ; i++)
        {
            mExample.add(Integer.parseInt(mNum[i]));
        }

        Collections.sort(mExample);
        int[] result = new int[mExample.get(m-1)]; // 결과를 저장할 배열

        for(int i = 0 ; i <= m ; i++) //결과 배열을 -1로 초기화
        {
            result[i] = -1;
        }

        for(int i = 0 ; i < m ; i++)
        {
            int x = mExample.get(i);//있는지 알아볼 숫자.
            for(int j = 0 ; j < n ; j++)
            {
                int a = nExample.get(j); //비교할 대상.
                if(x == a) {
                    result[mExample.get(i)-1] = 1;
                    break;
                }
                else if(x < a){
                    // 비교대상이 없음을 확인하고 0을 저장
                    result[mExample.get(i)-1] = 0;
                    break;
                }
            }
        }

        //결과값을 얻었으니 다시 원래 순서대로 바꾸어주는 작업.
        mExample.clear();
        for(int i = 0 ; i < m ; i++)
        {
            mExample.add(Integer.parseInt(mNum[i]));
        }
        for(int i = 0 ; i < m ; i++)
        {
            if(result[mExample.get(i)-1] != -1){
                bw.write(result[mExample.get(i)-1]+"\n");
                bw.flush();
            }
        }




        bw.flush();
        bw.close();
        br.close();
    }
}
