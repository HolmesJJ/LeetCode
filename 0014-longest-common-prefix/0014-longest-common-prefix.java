class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isWord;
    public String word;
    public int remainingLongestCharacters;
    public TrieNode () {
        children = new HashMap<>();
        isWord = false;
        word = null;
        remainingLongestCharacters = -1;
    }
}

class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public TrieNode getRoot() {
        return root;
    }
}

class Solution {
    public void insert(TrieNode root, String word) {
        int l = word.length();
        TrieNode node = root;
        for (int i = 0; i < l; i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                node.children.put(letter, new TrieNode());
            }
            node = node.children.get(letter);
            if (node.remainingLongestCharacters < l - i - 1) {
                node.remainingLongestCharacters = l - i - 1;
            }
        }
        node.isWord = true;
        node.word = word;
    }
    
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        TrieNode root = trie.getRoot();
        for (int i = 0; i < strs.length; i++) {
            insert(root, strs[i]);
        }
        TrieNode node = root;
        String prefix = "";
        while (node != null) {
            char nextLetter = Character.MIN_VALUE;
            TrieNode nextNode = null;
            int remainingLongestCharacters = -1;
            if (node.isWord) {
                return prefix;
            }
            if (node.children.size() > 1) {
                return prefix;
            }
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                char childLetter = entry.getKey();
                TrieNode childNode = entry.getValue();
                if (remainingLongestCharacters < childNode.remainingLongestCharacters) {
                    remainingLongestCharacters = childNode.remainingLongestCharacters;
                    nextLetter = childLetter;
                    nextNode = childNode;
                }
            }
            if (nextNode != null) {
                prefix += nextLetter;
            }
            node = nextNode;
        }
        return prefix;
    }
}