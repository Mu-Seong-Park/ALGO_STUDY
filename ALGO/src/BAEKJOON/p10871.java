package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p10871 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        int size = Integer.parseInt(nums[0]);
        int x = Integer.parseInt(nums[1]);

        ArrayList<Integer> array = new ArrayList();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < size ; i++) {
            array.add(Integer.parseInt(st.nextToken()));
        }

        //Collections.sort(array);

        for(int i = 0 ; i < size ; i++) {
            int temp = array.get(i);
            if(temp < x) {
                bw.write(temp+" ");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
