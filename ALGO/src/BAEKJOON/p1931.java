package BAEKJOON;

import java.io.*;
import java.util.*;

public class p1931 {
    // 문제풀이
    // 1. 종료시간을 기점으로 제일 빨리 끝나는 회의를 고른다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] meeting = new int[n][2];

        for(int i =0 ; i < n ; i++) {
            String[] times = br.readLine().split(" ");
            meeting[i][0] = Integer.parseInt(times[0]);
            meeting[i][1] = Integer.parseInt(times[1]);
        }

        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int pre = 0;

        for(int i = 0 ; i < n ; i++) {
            if(pre <= meeting[i][0]) {
                pre = meeting[i][1];
                count++;
            }
        }

        bw.write(count+"\n");
        br.close();
        bw.flush();
        bw.close();
    }

//    static class Node implements Comparable<Node> {
//        private long time;
//        private long start;
//        private long end;
//
//        public Node(long start, long end) {
//            this.start = start;
//            this.end = end;
//            this.time = end - start;
//        }
//
//        public long getTime() {
//            return time;
//        }
//
//        public long getStart() {
//            return start;
//        }
//
//        public long getEnd() {
//            return end;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            long result = this.getStart() - o.getStart();
//            if (result == 0) {
//                return (int)(this.getTime() - o.getTime());
//            }
//            return (int)result;
//        }
//    }
}
