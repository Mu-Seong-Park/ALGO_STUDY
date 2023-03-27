package BAEKJOON;

import java.io.*;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class p1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] citiesCost = new int[n][n];
        City[] cities = new City[n];


        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                citiesCost[i][j] = -1;
            }
        }

        for(int i = 0 ; i < m ; i++) {
            String[] nums = br.readLine().split(" ");
            int pre = Integer.parseInt(nums[0]) - 1;
            int post = Integer.parseInt(nums[1]) - 1;
            int cost = Integer.parseInt(nums[2]);

            if(cities[pre] == null) {
                cities[pre] = new City(pre,-1);
            }

            if(cities[post] == null) {
                cities[post] = new City(post,-1);
            }

            if(citiesCost[pre][post] == -1 || cost < citiesCost[pre][post]) {
                cities[pre].add(cities[post],cost);
                citiesCost[pre][post] = cost;
                citiesCost[post][pre] = cost;
            }
        }

        String[] nums = br.readLine().split(" ");

        int start = Integer.parseInt(nums[0]) - 1;
        int end = Integer.parseInt(nums[1]) - 1;

        for(int i = 0 ; i < n ; i++) {
            if(citiesCost[i][end] != -1) {
                cities[i].cost = citiesCost[i][end];
            }
        }



        int result = dijkstra(cities, start, end);

        bw.write(result+"\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static int dijkstra(City[] cities,int start, int end) {
        City current = cities[start];

        //시작도시부터 나머지 이어진 도시들의 비용 중 최솟값을 저장할 배열
        int[] cheapestCost = new int[cities.length];
        for(int i = 0 ; i < cities.length ; i++) {
            cheapestCost[i] = Integer.MAX_VALUE;
        }

        if(start == end) {
            cheapestCost[start] = cities[start].cost;
        } else {

            cheapestCost[start] = 0;
        }
        //방문 확인용 배열
        boolean[] visited = new boolean[cities.length];
        for(int i = 0 ; i < cities.length ; i++) {
            visited[i] = false;
        }

        //너비우선탐색
        PriorityQueue<City> queue = new PriorityQueue<>();
        queue.offer(current);

        while(!queue.isEmpty()) {

            current = queue.poll();

            if(!visited[current.cityNum]) {
                visited[current.cityNum] = true;
                for (City key :  current.adjacent.keySet()) {
                    queue.offer(key);
                    if(cheapestCost[key.cityNum] > cheapestCost[current.cityNum] + current.adjacent.get(key)) {
                        cheapestCost[key.cityNum] = cheapestCost[current.cityNum] + current.adjacent.get(key);
                    }
                }
            }
        }

        return cheapestCost[end];
    }

    static class City implements Comparable<City>{
        int cityNum;
        int cost;
        Hashtable<City,Integer> adjacent;


        public City(int cityNum,int cost) {
            this.cost = cost;
            this.cityNum = cityNum;
            this.adjacent = new Hashtable<>();
        }

        public void add(City city, int cost) {
            adjacent.put(city, cost);
            city.adjacent.put(this,cost);
        }

        @Override
        public int compareTo(City o) {
            return this.cost - o.cost;
        }
    }
}
