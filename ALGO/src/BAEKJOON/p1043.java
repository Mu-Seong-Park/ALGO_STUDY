package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p1043 {
    //문제 풀이
    // 1. 분리집합 문제이다.
    // 분리집합이란(disjoint set)? 서로소 집합이라고도 한다.
    // 특징: 집합 A와 B는 전체집합 U의 부분집합이다.
    // A,B는 공통 원소를 가지지 않는 서로소이다.
    // A와 B 합집합이 결국 전체집합 U가 된다.
    // 집합이 3개 이상인 경우에도 위의 특징이 적용된다.
    // Union-Find 알고리즘 : 분리 집합을 구현하는 알고리즘
    // 위에 대한 설명은  https://4legs-study.tistory.com/94 참고.
    //우선 input을 받으며 파티 참석자의 정보를 저장하고, 파티 참석자 간 연관 관계를 나타내야했다.
    // 그래프를 전부 그리기 보다는 각각의 사람이 연관관계가 있는지만 판단하면 됐기 때문에
    // union-find를 활용해서 parent 정보를 저장했다. (같은 parent를 가지면 이어져 있는 것으로 판단)
    //이후 진실을 아는 사람과 연관되어있다는 것은 진실을 듣는다는 것이기 때문에 각각 파티에서 진실을 듣는지, 과장된 이야기를 듣는지를 저장해둔다.
    //각 파티 별 참석자를 확인한다. 진실된 이야기를 들어야하는 사람이 한명이라도 있다면 패스하고,
    // 아니라면 그 파티에서는 과장된 이야기를 할 수 있기 때문에 카운트 해준다.

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, total = 0;
    static boolean[] truePeople = new boolean[51];
    static int[] parent;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수

        // 1. union-find 초기화
        parent = new int[N+1];
        for(int i=1;i<=N; i++) {
            parent[i] = i;
        }

        // 2. 진실을 아는 사람 정보 받아오기 truePeople[진실을아는사람] == true
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            truePeople[Integer.parseInt(st.nextToken())] = true;
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(int x : a) {

        }
        // 3. 파티 정보를 받아오면서 같은 파티에 있는 사람들 union
        ArrayList<Integer>[] peoples = new ArrayList[M];
        for(int i=0; i<M; i++) {
            peoples[i] = new ArrayList<>();
        }
        int value, pre =0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n > 0) {
                pre = Integer.parseInt(st.nextToken());
                peoples[i].add(pre);
            }
            for(int j=1; j<n; j++) {
                value = Integer.parseInt(st.nextToken());
                peoples[i].add(value);
                union(pre, value); // 두명씩 union하면 모두가 같은 parent를 갖게 됨.
                pre = value;
            }
        }

        // 4. 진실을 아는 사람들의 parent는 같이 파티를 참여 했으므로 진실을 아는 사람들
        int parent;
        for(int i=1; i<truePeople.length; i++) {
            if(truePeople[i]) {
                truePeople[find(i)] = true;
            }
        }

        // 5. 진실을 아는 사람들과 파티를 같이 하지 않았으면 total++
        for(int i=0; i<M; i++) {
            if(peoples[i].size() > 0) {
                parent = find(peoples[i].get(0));
                if(!truePeople[parent]) total++;
            }
        }

        // 6. 거짓말 할 수 있는 파티 최대 수 출력
        System.out.println(total);
    }

    private static int find(int x) {
        if(parent[x] == x)
            return parent[x] = x;
        else  return find(parent[x]);

    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!= b) {
            if(a>b) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
            return true;
        }
        return false;
    }

}
//잘못된 풀이~~~~~~~~~~~~~~~~~~~~~~
//    //문제 풀이
//    // 1. key value 구조를 갖는 자료구조를 사용한다.
//    // 2. key로 파티의 번호, value로 ArrayList에 저장된 파티 참여 목록을 사용한다.
//    // 3. 파티를 돌면서 이미 알고 있는 사람이 포함되어 있다면, 그 참여 목록 전체를 알고 있는 사람 목록에 추가한다.
//    // 4. 파티를 모두 확인한다.
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] nums = br.readLine().split(" ");
//
//        int n = Integer.parseInt(nums[0]);
//        int m = Integer.parseInt(nums[1]);
//
//        String[] truth = br.readLine().split(" ");
//        int truthPeople = Integer.parseInt(truth[0]);
//        boolean[] truthKnow = new boolean[n];;
//
//        if(truthPeople != 0) {
//            for(int i = 1 ; i < truth.length ; i++) {
//                int index = Integer.parseInt(truth[i]) - 1;
//                truthKnow[index] = true;
//            }
//        }
//
//        HashMap<Integer, ArrayList<Integer>> entry = new HashMap<>();
//        for(int testCase = 0 ; testCase < m ; testCase++) {
//            ArrayList<Integer> partyEntry = new ArrayList<>();
//            String[] entries = br.readLine().split(" ");
//
//            for(int i = 1 ; i < entries.length ; i++) {
//                partyEntry.add(Integer.parseInt(entries[i]));
//            }
//        }
//
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }