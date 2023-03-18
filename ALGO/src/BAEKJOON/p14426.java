package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class p14426 {
    //문제풀이
    //1. n개의 입력받은 단어를 트라이에 저장한다.
    //2. 이후로 m개의 단어를 트라이에 검색한다.
    //3. 자동완성 기능을 구현하여 m개의 접두사에 연결되는 단어가 있다면 words 배열에 저장한다.
    //4. 모든 재귀 혹은 반복문이 끝났을 때, 반환되는 words 배열의 크기를(혹은 저장되어 있는 데이터의 개수)
    //확인하면 접두사의 개수를 알 수 있다.

    // 위의 방법으로 하니 너무 느려서 시간 초과 발생, 모든 노드를 확인하기 때문
    // 수정한 방법
    // 트라이에 저장된 단어를 검색한다.
    // 검색 후에 return 값이 뒤의 자식 노드이기 때문에 null을 리턴 받으면 접두사가 아니라는 의미고 값이 있다면 접두사라는 의미이다.
    // 따라서 search 결과값이 null인지 아닌지만 비교하여 count를 1씩 올려주면 된다.
    static Trie myTrie;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        myTrie = new Trie();
        int count = 0;
        for(int testCase = 0; testCase < n ; testCase++) {
            myTrie.insert(br.readLine());
        }

        for(int testCase = 0; testCase < m ; testCase++) {
            TrieNode temp = myTrie.search(br.readLine());
            if(temp != null) {
                count++;
            }
        }

        bw.write(count+"\n");

        bw.flush();
        bw.close();
        br.close();

    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String str) {
            //시작은 root부터.
            TrieNode newNode = this.root;

            //문자열을 문자 하나씩 끊어가면서 자식 노드가 존재하는지 확인
            //없다면 자식 노드를 생성한다.
            //이를 위해서 해시 맵의 computeIfAbsent 메소드를 사용한다.
            //해당 맵에서 key값이 있는지 확인하고 값이 있다면 value를 반환
            //없다면 새로운 key와 람다함수를 실행한 value값(실행 결과)을 저장한다.
            for(int i = 0 ; i < str.length() ; i++) {
                newNode = newNode.childNode.computeIfAbsent(str.charAt(i), key -> new TrieNode());
            }

            //저장하는 문자열의 마지막에는 *과 null 혹은 0을 저장한다.
            newNode.childNode.put('*',null);
        }

        TrieNode search(String word) {
            TrieNode currentNode = this.root;

            //해시맵의 getOrDefault 메소드를 사용한다.
            //해당 키가 존재한다면 key에 매핑된 값을 반환
            //존재하지 않는다면 사용자가 정한 디폴트 값을 반환한다. (여기서는 null을 반환)
            for(int i = 0 ; i < word.length() ; i++) {
                 currentNode = currentNode.childNode.getOrDefault(word.charAt(i),null);

                 //문자열이 존재하지 않으니 null을 리턴한다.
                 if(currentNode == null) {
                     return null;
                 }
            }

            return currentNode;
        }

        ArrayList<String> collectAllWords(TrieNode node ,String word, ArrayList<String> words) {
            TrieNode currentNode;
            if(node == null) {
                currentNode = this.root;
            }
            else {
                currentNode = node;
            }

            //keySet 메소드를 이용해서, 전체 자식을 확인한다.
            for(char key : currentNode.childNode.keySet()) {

                //끝에 도달한 경우에는 그 단어를 추가한다.
                //끝에 도달하지 못했으면 그 자식노드에 대해서 재귀적으로 이 메소드를 호출한다.
                if(key == '*') {
                    words.add(word);
                }
                else {
                    collectAllWords(currentNode.childNode.get(key),word+key, words);
                }
            }

            return words;
        }

        ArrayList<String> autocomplete(String prefix) {
            TrieNode currentNode = search(prefix);

            if(currentNode == null) {
                return null;
            }
            ArrayList<String> words = new ArrayList<>();
            return collectAllWords(currentNode,prefix, words);
        }
    }
    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
    }
}
