package BAEKJOON;

import java.io.*;

public class p2263 {
    //참고 : https://lotuslee.tistory.com/82
    static int n;
    static int[] inOrder;
    static int[] postOrder;
    static int[] preOrder;
    static int index;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new int[n];

        String[] nums = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++) {
            inOrder[i] = Integer.parseInt(nums[i]);
        }

        nums = br.readLine().split(" ");

        for(int i = 0 ; i < n ; i++) {
            postOrder[i] = Integer.parseInt(nums[i]);
        }

        getPreOrder(0,n - 1, 0 , n - 1);

        for(int n : preOrder) {
            bw.write(n+" ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd){



        if(inStart <= inEnd && postStart <= postEnd) {
            preOrder[index++] = postOrder[postEnd];

            int pos = inStart;

            for (int i = inStart; i <= inEnd; i++) {
                if (inOrder[i] == postOrder[postEnd]) {
                    pos = i;
                    break;
                }
            }

            getPreOrder(inStart,pos-1,postStart,postStart+ pos - inStart -1);
            getPreOrder(pos+1,inEnd,postStart + pos - inStart,postEnd-1);

        }

    }
}
