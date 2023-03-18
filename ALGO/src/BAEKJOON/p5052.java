package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class p5052 {
    //문제풀이
    //1. 트라이에 모든 전화번호를 저장한다.
    //2. 트라이에 저장된 번호를 검색했을 때, 자식이 없다면 일관성이 있는 목록이다.
    // 자식이 있다면 번호를 눌렀을 때, 다른 전화로 통화가 걸리기 때문이다.
    //3. 따라서 search 메소드를 호출했을 때, 자식 노드의 key 개수가 1개를 넘는다면
    // (한 문자열이 끝날 때 *을 추가하는 방식으로 코드를 작성했기 때문에) 자식이 존재하므로
    // NO를 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCase ; i++) {
            int n = Integer.parseInt(br.readLine());
            Trie myTrie = new Trie();
            String[] numbers = new String[n];
            boolean result = true;
            for(int j = 0 ; j < n; j++) {
                numbers[j] = br.readLine();
                myTrie.insert(numbers[j]);
            }

            for(int j = 0 ; j < n; j++) {
                if(myTrie.search(numbers[j]).childNode.keySet().size() > 1) {
                    result = false;
                    break;
                }
            }

            if(result) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }


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

        ArrayList<String> collectAllWords(TrieNode node , String word, ArrayList<String> words) {
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
