package BAEKJOON;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class p1654 {
    //풀이방법: 이분탐색을 이용한다.
    //배열을 탐색하는 것이 아니라 길이를 탐색한다는 개념을 적용한다.
    //가장 긴 랜선의 길이를 right, 0을 left로 두고 이분탐색을 실시하여 만들 수 있는 랜선의 길이를 비교한다.
    //목표 갯수가 채워진 경우, 최대 길이를 구해야하기 때문에 left에 그 길이를 저장하여 다시 이분탐색을 실시한다.
    //작은 설정들, upperbound와 같은 부분은 https://st-lab.tistory.com/269 을 참고하였음.
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lineCount = br.readLine().split(" "); // 랜선의 개수에 대한 입력을 저장.
        int k = Integer.parseInt(lineCount[0]); // 가지고 있는 랜선의 개수를 저장.
        long n = Long.parseLong(lineCount[1]); // 필요한 랜선의 개수 저장.

        ArrayList<Integer> lineList = new ArrayList<>();

        for(int i = 0 ; i < k ; i++) {
            lineList.add(Integer.parseInt(br.readLine()));
        }

        //입력받은 랜선의 길이를 내림차순으로 정렬.
        Collections.sort(lineList,Collections.reverseOrder());

        long left = 0;
        long right = lineList.get(0) + 1;//탐색을 계속하기 위해서는 right가 left보다 2이상 커야한다.
        long mid = 0;

        while(left < right) {

            mid = (left + right) / 2 ; // 1부터 가장 길이가 긴 랜선 사이의 중간값.
            long count = 0; // 현재 mid의 길이로 랜선을 잘랐을 때 얻을 수 있는 갯수를 저장.

            for(int i = 0; i < k ; i++) {
                //가지고 있는 랜선을 mid로 잘랐을 때, 얻을 수 있는 개수를 구하는 반복문.
                count += (lineList.get(i) / mid) ;
            }
            bw.write("count값: "+count+"\n");
            bw.write("mid값: "+mid+"\n");
            if(count >= n) {
                //필요한 개수를 찾았거나 그 이상으로 얻은 경우, 최댓값을 구해야 하기 때문에 left에 mid를 저장.
                left = mid + 1;
            }
            else {
                //더 적게 얻은 경우, right에 mid값을 저장.
                right = mid;
            }
        }
        //
        bw.write((left - 1)+"\n");

        bw.flush();
        bw.close();
        br.close();

    }
}

//랜선을 등분하면서 자른다면 이 방법으로 풀 수 있지만, 얼마를 자르는 것은 사용자의 임의대로 조정할 수 있어야함.
//틀린 풀이***********************************************
//public class p1654 {
//    //풀이방법: 랜선의 길이를 내림차순으로 정렬한다.
//    //가장 긴 랜선을 자르지 않는 것부터 시작해서 자르는 횟수를 1씩 늘려나간다.
//    //잘린 랜선의 길이를 나머지 짧은 랜선에 적용시켜서 잘랐을 때, 필요한 개수가 맞는지 비교한다.
//    //개수가 만족될 때까지 위의 과정을 반복한다.
//    //-> 가장 긴 랜선을 등분한다면
//    public static void main(String[] args) throws IOException {
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] count = br.readLine().split(" "); // 랜선의 개수에 대한 입력을 저장.
//        int k = Integer.parseInt(count[0]); // 가지고 있는 랜선의 개수를 저장.
//        int n = Integer.parseInt(count[1]); // 필요한 랜선의 개수 저장.
//        ArrayList<Integer> lineLength = new ArrayList<>(); //가지고 있는 랜선의 길이를 저장할 ArrayList
//        long answer = 0; // 길이 최댓값을 저장할 변수.
//        for(int i = 0 ; i < k ; i++)
//        {
//            lineLength.add(Integer.parseInt(br.readLine()));
//        }
//
//        //내림차순으로 정렬
//        Collections.sort(lineLength,Collections.reverseOrder());
//
//        for(int i = 0 ; i < n ; i++) {
//            //제일 긴 랜선을 n - 1번까지 잘라본다.
//            long longest = lineLength.get(0);
//            long temp = 0;
//            temp = longest / (i + 1);// 자른다.
//
//            int result = 0;
//            for(int j = 1; j < lineLength.size() ; j++) {
//                //가지고 있는 랜선을 temp값(가장 긴 랜선을 자른 길이)으로 나누어서 결과값을 확인한다.
//                result += (lineLength.get(j) / temp);
//            }
//
//            if(result + (i + 1) >= n) {
//                if(answer < temp) {
//                    answer = temp;
//                }
//                else {
//                    break;
//                }
//            }
//        }
//
//
//        bw.write(answer+"\n");
//
//
//
//        bw.flush();
//        bw.close();
//        br.close();
//
//    }
//}