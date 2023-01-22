package BAEKJOON;

import java.io.*;
import java.util.*;

public class p1764 {
    //풀이방법: 보도 못한 사람과 듣도 못한 사람 중 크기가 작은 집합을 선택한다.
    //다른 집합이 그 집합의 값을 가지는지 확인하는 과정을 선택한 집합의 크기만큼  반복한다.
    //-> 시간초과가 발생하는데, 해시셋을 이용하면 된다고 한다.
    //https://darksilber.tistory.com/70
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n과 m을 입력받고 저장.
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        HashSet<String> names = new HashSet<>();

        for(int i = 0 ; i < n ; i++ ) {
            names.add(br.readLine());
        }

        ArrayList<String> answer = new ArrayList<>();

        for(int i = 0 ; i < m ; i++) {
            String temp = br.readLine();

            if(names.contains(temp)) {
                answer.add(temp);
            }
        }

        Collections.sort(answer);

        bw.write(answer.size()+"\n");
        for(int i = 0 ; i < answer.size(); i++) {
            bw.write(answer.get(i)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}


// 틀린풀이
//    //-> 해시맵과 arraylist를 사용하니 모두 시간초과가 발생함.
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        //n과 m을 입력받고 저장.
//        String[] nums = br.readLine().split(" ");
//        int n = Integer.parseInt(nums[0]);
//        int m = Integer.parseInt(nums[1]);
//
//        // 보도 못한 사람과 듣도 못한 사람을 저장할 ArrayList.
//        HashMap<Integer,String> notSeen = new HashMap<>();
//        HashMap<Integer,String> notHeard = new HashMap<>();
//
//        for(int i = 0 ; i < n ; i++) {
//            //듣도 못한 사람 저장.
//            notSeen.put(i,br.readLine());
//        }
//
//        for(int i = 0 ; i < m ; i++) {
//            //보도 못한 사람 저장.
//            notHeard.put(i,br.readLine());
//        }
//
//        int count = 0;
//        ArrayList<String> answer = new ArrayList<>();
//        if( n < m) {
//            for(int i = 0 ; i < n ; i++) {
//                if(notHeard.containsValue(notSeen.get(i))) {
//                    count++;
//                    answer.add(notSeen.get(i));
//                }
//            }
//        }
//        else {
//            for(int i = 0 ; i < m ; i++) {
//                if(notSeen.containsValue(notHeard.get(i))) {
//                    count++;
//                    answer.add(notHeard.get(i));
//                }
//            }
//        }
//
//        Collections.sort(answer);
//        bw.write(count+"\n");
//        for(int i = 0 ; i < answer.size() ; i++) {
//            bw.write(answer.get(i)+"\n");
//        }
//
//
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }