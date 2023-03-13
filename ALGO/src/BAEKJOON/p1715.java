package BAEKJOON;

import java.io.*;
import java.util.ArrayList;

public class p1715 {
    static ArrayList<Long> heap;
    static int heapIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        heap = new ArrayList<>();


        for(int i = 0 ; i < n ; i++) {
            insert(Integer.parseInt(br.readLine()));
        }
        heapIndex--;
        long answer = 0;

        if(n > 1) {
            while(true) {
                long temp1 = delete();
                long temp2 = delete();
                answer = answer + temp1 + temp2;

                if(heapIndex < 0) {
                    break;
                }
                insert(temp1+temp2);
            }
        } else {
            answer = delete();
        }

        bw.write(answer+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
    static void insert(long data) {
        heap.add(heapIndex,data);
        for(int i = heapIndex ; i > 0 ; i /= 2) {

            if(heap.get(i) < heap.get(i / 2)) {
                long temp = heap.get(i);
                heap.set(i,heap.get(i / 2));
                heap.set(i/2 , temp);
            }
            else {
                break;
            }
        }

        heapIndex++;
    }

    static long delete() {
        long root = heap.get(0);
        heap.set(0, heap.get(heapIndex));

        for(int i = 0 ; i * 2 < heapIndex ; ) {

            if(heap.get(i) < heap.get(i*2 + 1) && heap.get(i) < heap.get(i * 2 + 2)) {
                break;
            }
            else if((i * 2 + 2) > heapIndex || heap.get(i*2 + 1) <= heap.get(i * 2 + 2)) {
                long temp = heap.get(i);
                heap.set(i, heap.get(i * 2 + 1));
                heap.set(i*2 + 1, temp);
                i = i * 2 + 1;
            } else {
                long temp = heap.get(i);
                heap.set(i, heap.get(i * 2 + 2));
                heap.set(i*2 + 2, temp);
                i = i * 2 + 2;
            }
        }

        heap.remove(heapIndex--);
        return root;
    }

}
