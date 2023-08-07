/*
 * Feature 1 - Store and Fetch Words - PROBLEM - Implement TRIE
 */

package SearchEngine;

import java.util.HashMap;

class TrieNode {
    boolean isWord;
    HashMap<Character, TrieNode> children;

    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isWord = false;
    }
}

public class ImplementTrie {
    TrieNode root;


    public ImplementTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode trieNode = this.root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!trieNode.children.containsKey(c)){
                trieNode.children.put(c, new TrieNode());
            }

            trieNode = trieNode.children.get(c);
        }

        trieNode.isWord = true;
    }

    public boolean search(String word){
        TrieNode trieNode = this.root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!trieNode.children.containsKey(c)){
                return false;
            } else 
                trieNode = trieNode.children.get(c);
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode trieNode = this.root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!trieNode.children.containsKey(c)){
                return false;
            } else
                trieNode = trieNode.children.get(c);
        }
        return true;
    }
}
