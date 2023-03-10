package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

public class p5430 {
    static int[] numsArray;
    static int rCount;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int iter = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < iter ; i++) {
            String[] cal = br.readLine().split("");
            int numCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(),"[],");
            rCount = 0;
            numsArray = new int[numCount];

            if(st.countTokens() > 0) {
                for(int j = 0 ; j < numCount ; i++) {
                    numsArray[j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = calculate(cal);


            if(result == 0){
                bw.write("error\n");
            } else {
                bw.write("[");
                if(rCount % 2 ==0 ){
                    for(int j = 0 ; j < numsArray.length ; j++) {
                        bw.write(numsArray[j]+"");
                        if(j < numsArray.length - 1) {
                            bw.write(",");
                        }
                        else {
                            bw.write("]\n");
                        }
                    }
                } else {
                    for(int j = numsArray.length - 1 ; j >= 0 ; j--) {
                        bw.write(numsArray[j]+"");
                        if(j > 0) {
                            bw.write(",");
                        }
                        else {
                            bw.write("]\n");
                        }
                    }
                }
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

//    static int[] stringToIntArray(int numCount, String s) {
//        int[] nums = new int[numCount];
//
//        if(numCount > 0) {
//            nums = new int[numCount];
//
//
//        }
//
//        return nums;
//    }

//    static int[] r(int[] array) {
//        if(array.length > 1) {
//
//            int[] newArray = new int[array.length];
//
//            for(int i = 0 ; i < array.length ; i++) {
//                int temp = array[i];
//                newArray[i] = array[array.length - i - 1];
//                array[i] = temp;
//            }
//
//            return newArray;
//        }
//        else {
//            return array;
//        }
//    }

    static int[] d(int[] array,int r) {

        if(array.length == 0 || array.length < 0) {
            int[] result = new int[1];
            result[0] = -1;
            return result;
        }
        int[] newArray = new int[array.length - 1];
        if(r % 2 == 0) {
            for(int i = 1 ; i < array.length ; i++) {
                newArray[i-1] = array[i];
            }
        } else {
            for(int i = 0 ; i < array.length - 1 ; i++) {
                newArray[i] = array[i];
            }
        }
        return newArray;
    }
    static int calculate(String[] cal) {

        for(int i = 0 ; i < cal.length ; i++) {
            if(cal[i].equals("R")) {
                rCount++;
            }
            else {
                numsArray = d(numsArray,rCount);
                if(numsArray.length > 0) {
                    if(numsArray[0] == -1) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}
