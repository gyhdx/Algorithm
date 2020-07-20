package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/20 13:56
 */
public class _208_实现Trie前缀树 {
    private TrieNode node;

    /** Initialize your data structure here. */
    public _208_实现Trie前缀树() {
        node = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.list[c - 'a'] == null){
                ws.list[c - 'a'] = new TrieNode(c);
            }
            ws = ws.list[c - 'a'];
        }
        ws.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.list[c - 'a'] == null){
                return false;
            }
            ws = ws.list[c - 'a'];
        }
        return ws.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = node;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.list[c - 'a'] == null){
                return false;
            }
            ws = ws.list[c - 'a'];
        }
        return true;
    }

    private class TrieNode{
        public char c;
        public TrieNode[] list = new TrieNode[26];
        public boolean isEnd = false;

        public TrieNode() {
        }

        public TrieNode(char c) {
            this.c = c;
        }
    }
}
