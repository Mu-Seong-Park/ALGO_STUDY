package BAEKJOON;

import java.io.*;
import java.util.*;

public class p1181 {
    //풀이방법: comparator 인터페이스를 사용해서 정렬방법을 정의한다.
    //중복되는 데이터를 제외하기 위해 HashMap을 사용한다.

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        HashMap<String,String> inputWords = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            String temp = br.readLine();
            inputWords.put(temp,temp);
        }

        ArrayList<String> words = new ArrayList<>(inputWords.keySet());
        // HashMap에서 key를 단어로 받아서 단어가 중복되지 않도록 했으니 그 key들을 다시 ArrayList로 저장한다.

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //길이순으로 정렬을 하되, 길이가 같다면 알파벳을 비교하여 사전순으로 정렬한다.
                if(o1.length() > o2.length()){
                    return 1;
                }
                else if(o1.length() == o2.length()) {
                    for(int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i) > o2.charAt(i)) {
                            return 1;
                        }
                        else if(o1.charAt(i) < o2.charAt(i)) {
                            return -1;
                        }
                    }
                    return 0;
                }
                else {
                    return -1;
                }
            }
        });

        for(int i = 0 ; i < words.size() ; i++){

            bw.write(words.get(i)+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }


}
