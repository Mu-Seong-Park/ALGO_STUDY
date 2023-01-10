package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class p1920 {
    //풀이방법: n개의 숫자를 입력받아서 Collections의 timsort로 정렬한다.
    //m개의 숫자를 입력받아서 차례로 이진탐색(binary search)을 진행한다.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] nNum = br.readLine().split(" ");
        ArrayList<Integer> examples = new ArrayList<>(); // n개의 보기를 정렬해서 저장할 ArrayList

        for(int i = 0 ; i < n ; i++)
        {
            examples.add(Integer.parseInt(nNum[i]));
        }

        Collections.sort(examples);

        int m = Integer.parseInt(br.readLine());
        String[] mNum = br.readLine().split(" ");

        int[] result = new int[m]; //결과값을 순서대로 저장할 배열.
        for(int i = 0; i < m ; i++) {
            //배열을 0으로 초기화.
            result[i] = 0;
        }



        for(int i = 0; i < m ; i++) {
            //m개의 배열만큼 이진탐색 진행.
            int start = 0;// ArrayList의 가장 좌측값.
            int end = (examples.size() - 1);// ArrayList의 가장 우측 값.
            int middle = -1; // 중간의 index를 저장할 변수.

            while (start <= end){
                //이진탐색진행, start 값과 end값이 같아지는 순간까지 반복한다.
                middle = (start + end) / 2;

                if(examples.get(middle) < Integer.parseInt(mNum[i])){
                    //middle에 위치한 값보다 큰 경우
                    start = middle + 1; // 시작할 값을 오른쪽 부분으로 바꾼다.
                }
                else if(examples.get(middle) > Integer.parseInt(mNum[i])){
                    //middle에 위차한 값보다 작은 경우.
                    end = middle - 1; // 끝나는 값을 왼쪽 부분으로 바꾼다.
                }
                else if(examples.get(middle) == Integer.parseInt(mNum[i])){
                    //원하는 값을 찾은 경우.
                    result[i] = 1;
                    break;
                }
            }
        }

        for(int i = 0; i < m ; i++) {
            //결과값 출력
            bw.write(result[i]+"\n");
            bw.flush();
        }

        bw.flush();
        bw.close();
        br.close();
    }


}


//틀린풀이*********************************************************************
//풀이방법: n개의 숫자를 입력받아서 문자열 배열로 저장한다.
//ArrayList에 앞선 문자열 배열을 모두 Integer로 저장하여 Collections의 Timsort로 정렬한다.
//m개의 숫자 또한 같은 방법으로 정렬한다.
//두 ArrayList의 원소들을 비교해서 자신보다 큰 수가 나올때까지 검색해보고 나오지 않는다면 결과 배열에 0을 저장한다.
//같은 숫자가 있다면 1을 저장한다.
//오답 이유 : 메모리 초과 -> 모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다.
//위의 조건에서 배열을 만드는 과정에 오버플로우가 발생하는 것 같음. -> 양수만 한다는 말이 없음. 음수 표현 X

//    //n개의 정수를 입력받고 정렬하는 과정
//    int n = Integer.parseInt(br.readLine());
//    String[] nNum = br.readLine().split(" ");
//    ArrayList<Integer> nExample = new ArrayList<>();
//
//        for(int i =0 ; i < n ; i++)
//        {
//        nExample.add(Integer.parseInt(nNum[i]));
//        }
//
//        Collections.sort(nExample);
//
//        //m개의 정수를 입력받고 정렬하는 과정
//        int m = Integer.parseInt(br.readLine());
//        String[] mNum = br.readLine().split(" ");
//        ArrayList<Integer> mExample = new ArrayList<>();
//
//        for(int i =0 ; i < n ; i++)
//        {
//        mExample.add(Integer.parseInt(mNum[i]));
//        }
//
//        Collections.sort(mExample);
//        int[] result = new int[mExample.get(m-1)]; // 결과를 저장할 배열
//
//        for(int i = 0 ; i <= m ; i++) //결과 배열을 -1로 초기화
//        {
//        result[i] = -1;
//        }
//
//        for(int i = 0 ; i < m ; i++)
//        {
//        int x = mExample.get(i);//있는지 알아볼 숫자.
//        for(int j = 0 ; j < n ; j++)
//        {
//        int a = nExample.get(j); //비교할 대상.
//        if(x == a) {
//        result[mExample.get(i)-1] = 1;
//        break;
//        }
//        else if(x < a){
//        // 비교대상이 없음을 확인하고 0을 저장
//        result[mExample.get(i)-1] = 0;
//        break;
//        }
//        }
//        }
//
//        //결과값을 얻었으니 다시 원래 순서대로 바꾸어주는 작업.
//        mExample.clear();
//        for(int i = 0 ; i < m ; i++)
//        {
//        mExample.add(Integer.parseInt(mNum[i]));
//        }
//        for(int i = 0 ; i < m ; i++)
//        {
//        if(result[mExample.get(i)-1] != -1){
//        bw.write(result[mExample.get(i)-1]+"\n");
//        bw.flush();
//        }
//        }