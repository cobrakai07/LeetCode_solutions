class WordDictionary {
    Trie t;
    public WordDictionary() {
        t= new Trie();
    }
    
    public void addWord(String word) {
        t.insert(word);
    }
    
    public boolean search(String word) {
        return t.recSearch(0,t.root,word.toCharArray());
    }
}

class TrieNode {
  boolean isLeaf;
  TrieNode[] arr;

  TrieNode() {
    this.isLeaf = false;
    this.arr = new TrieNode[26];
  }
}

class Trie {
  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      if (i == word.length() - 1) {
        if (node.arr[word.charAt(i) - 'a'] == null) {
          TrieNode temp = new TrieNode();
          node.arr[word.charAt(i) - 'a'] = temp;
        }
        node.arr[word.charAt(i) - 'a'].isLeaf = true;
      } else {
        if (node.arr[word.charAt(i) - 'a'] == null) {
          TrieNode temp = new TrieNode();
          node.arr[word.charAt(i) - 'a'] = temp;
        }
        node = node.arr[word.charAt(i) - 'a'];
      }
    }
  }

public boolean recSearch(int i, TrieNode node, char[] word) {
        if (i == word.length) {
            return node.isLeaf;
        }

        if (word[i] == '.') {
            for (int ii = 0; ii < 26; ii++) {
                if (node.arr[ii] != null) {
                    if (recSearch(i + 1, node.arr[ii], word)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (node.arr[word[i] - 'a'] == null) {
                return false;
            } else {
                return recSearch(i + 1, node.arr[word[i] - 'a'], word);
            }
        }
    }

  public boolean search(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      if (node.arr[word.charAt(i) - 'a'] == null)
        return false;
      else
        node = node.arr[word.charAt(i) - 'a'];
    }
    if (node.isLeaf)
      return true;
    return false;
  }

  public boolean startsWith(String prefix) {
    TrieNode node = root;
    for (int i = 0; i < prefix.length(); i++) {
      if (node.arr[prefix.charAt(i) - 'a'] == null)
        return false;
      else
        node = node.arr[prefix.charAt(i) - 'a'];
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */