package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class p1916 {
    //문제풀이
    //1. 전형적인 다익스트라문제
    //2. 참고 : https://steady-coding.tistory.com/84
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());


        ArrayList<ArrayList<Node>> a = new ArrayList<>();


        for(int i = 0 ; i <= n ; i++) {
            a.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++) {
            String[] nums = br.readLine().split(" ");

            int start = Integer.parseInt(nums[0]);
            int end = Integer.parseInt(nums[1]);
            int weight = Integer.parseInt(nums[2]);

            a.get(start).add(new Node(end,weight));
        }

        String[] nums = br.readLine().split(" ");

        int start = Integer.parseInt(nums[0]);
        int end = Integer.parseInt(nums[1]);

        bw.write(dijkstra(a,start,end,n)+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(ArrayList<ArrayList<Node>> a, int start, int end, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!visited[node.end] && distance[node.end] > distance[cur] + node.weight) {
                        distance[node.end] = distance[cur] + node.weight;
                        pq.add(new Node(node.end, distance[node.end]));
                    }
                }
            }
        }
        return distance[end];
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}


//package BAEKJOON;
//
//import java.io.*;
//<<<<<<< HEAD
//import java.util.Hashtable;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//public class p1916 {
//=======
//        import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//
//    public class p1916 {
//        //문제풀이
//        //1. 전형적인 다익스트라문제
//        //2. 참고 : https://steady-coding.tistory.com/84
//>>>>>>> 590625ed6fe1038dbd1c86d41b212935457cbdc8
//        public static void main(String[] args) throws IOException {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//            int n = Integer.parseInt(br.readLine());
//            int m = Integer.parseInt(br.readLine());
//<<<<<<< HEAD
//            int[][] citiesCost = new int[n][n];
//            City[] cities = new City[n];
//
//
//            for(int i = 0 ; i < n ; i++) {
//                for(int j = 0 ; j < n ; j++) {
//                    citiesCost[i][j] = -1;
//                }
//=======
//
//
//                ArrayList<ArrayList<Node>> a = new ArrayList<>();
//
//
//                for(int i = 0 ; i <= n ; i++) {
//                    a.add(new ArrayList<>());
//>>>>>>> 590625ed6fe1038dbd1c86d41b212935457cbdc8
//                }
//
//                for(int i = 0 ; i < m ; i++) {
//                    String[] nums = br.readLine().split(" ");
//<<<<<<< HEAD
//                    int pre = Integer.parseInt(nums[0]) - 1;
//                    int post = Integer.parseInt(nums[1]) - 1;
//                    int cost = Integer.parseInt(nums[2]);
//
//                    if(cities[pre] == null) {
//                        cities[pre] = new City(pre,-1);
//                    }
//
//                    if(cities[post] == null) {
//                        cities[post] = new City(post,-1);
//                    }
//
//                    if(citiesCost[pre][post] == -1 || cost < citiesCost[pre][post]) {
//                        cities[pre].add(cities[post],cost);
//                        citiesCost[pre][post] = cost;
//                        citiesCost[post][pre] = cost;
//                    }
//=======
//
//                    int start = Integer.parseInt(nums[0]);
//                    int end = Integer.parseInt(nums[1]);
//                    int weight = Integer.parseInt(nums[2]);
//
//                    a.get(start).add(new Node(end,weight));
//>>>>>>> 590625ed6fe1038dbd1c86d41b212935457cbdc8
//                }
//
//                String[] nums = br.readLine().split(" ");
//
//<<<<<<< HEAD
//                int start = Integer.parseInt(nums[0]) - 1;
//                int end = Integer.parseInt(nums[1]) - 1;
//
//                for(int i = 0 ; i < n ; i++) {
//                    if(citiesCost[i][end] != -1) {
//                        cities[i].cost = citiesCost[i][end];
//                    }
//                }
//
//
//
//                int result = dijkstra(cities, start, end);
//
//                bw.write(result+"\n");
//
//                br.close();
//                bw.flush();
//                bw.close();
//            }
//
//            static int dijkstra(City[] cities,int start, int end) {
//                City current = cities[start];
//
//                //시작도시부터 나머지 이어진 도시들의 비용 중 최솟값을 저장할 배열
//                int[] cheapestCost = new int[cities.length];
//                for(int i = 0 ; i < cities.length ; i++) {
//                    cheapestCost[i] = Integer.MAX_VALUE;
//                }
//
//                if(start == end) {
//                    cheapestCost[start] = cities[start].cost;
//                } else {
//
//                    cheapestCost[start] = 0;
//                }
//                //방문 확인용 배열
//                boolean[] visited = new boolean[cities.length];
//                for(int i = 0 ; i < cities.length ; i++) {
//                    visited[i] = false;
//                }
//
//                //너비우선탐색
//                PriorityQueue<City> queue = new PriorityQueue<>();
//                queue.offer(current);
//
//                while(!queue.isEmpty()) {
//
//                    current = queue.poll();
//
//                    if(!visited[current.cityNum]) {
//                        visited[current.cityNum] = true;
//                        for (City key :  current.adjacent.keySet()) {
//                            queue.offer(key);
//                            if(cheapestCost[key.cityNum] > cheapestCost[current.cityNum] + current.adjacent.get(key)) {
//                                cheapestCost[key.cityNum] = cheapestCost[current.cityNum] + current.adjacent.get(key);
//=======
//                                int start = Integer.parseInt(nums[0]);
//                                int end = Integer.parseInt(nums[1]);
//
//                                bw.write(dijkstra(a,start,end,n)+"\n");
//
//                                bw.flush();
//                                bw.close();
//                                br.close();
//                            }
//
//                            public static int dijkstra(ArrayList<ArrayList<Node>> a, int start, int end, int n) {
//                                int[] distance = new int[n + 1];
//                                Arrays.fill(distance, Integer.MAX_VALUE);
//                                boolean[] visited = new boolean[n + 1];
//
//                                PriorityQueue<Node> pq = new PriorityQueue<>();
//                                pq.offer(new Node(start, 0));
//                                distance[start] = 0;
//
//                                while (!pq.isEmpty()) {
//                                    Node curNode = pq.poll();
//                                    int cur = curNode.end;
//
//                                    if (!visited[cur]) {
//                                        visited[cur] = true;
//
//                                        for (Node node : a.get(cur)) {
//                                            if (!visited[node.end] && distance[node.end] > distance[cur] + node.weight) {
//                                                distance[node.end] = distance[cur] + node.weight;
//                                                pq.add(new Node(node.end, distance[node.end]));
//>>>>>>> 590625ed6fe1038dbd1c86d41b212935457cbdc8
//                                            }
//                                        }
//                                    }
//                                }
//<<<<<<< HEAD
//
//                                return cheapestCost[end];
//                            }
//
//                            static class City implements Comparable<City>{
//                                int cityNum;
//                                int cost;
//                                Hashtable<City,Integer> adjacent;
//
//
//                                public City(int cityNum,int cost) {
//                                    this.cost = cost;
//                                    this.cityNum = cityNum;
//                                    this.adjacent = new Hashtable<>();
//                                }
//
//                                public void add(City city, int cost) {
//                                    adjacent.put(city, cost);
//                                    city.adjacent.put(this,cost);
//                                }
//
//                                @Override
//                                public int compareTo(City o) {
//                                    return this.cost - o.cost;
//=======
//                                    return distance[end];
//                                }
//
//                                static class Node implements Comparable<Node> {
//                                    int end;
//                                    int weight;
//
//                                    Node(int end, int weight) {
//                                        this.end = end;
//                                        this.weight = weight;
//                                    }
//
//                                    @Override
//                                    public int compareTo(Node o) {
//                                        return weight - o.weight;
//>>>>>>> 590625ed6fe1038dbd1c86d41b212935457cbdc8
//                                    }
//                                }
//                            }
