class Node {
    Node[] arr;
    int score; // To track how many words pass through this node

    Node() {
        arr = new Node[26];
        score = 0;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    // Insert the word into the Trie and update prefix scores
    public void build(String word) {
        Node t = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (t.arr[idx] == null) {
                t.arr[idx] = new Node();
            }
            t = t.arr[idx];
            t.score++;  // Increase the score for each prefix node
        }
    }

    // Calculate the prefix score for a word
    public int getPrefixScore(String word) {
        Node t = root;
        int totalScore = 0;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (t.arr[idx] == null) break;
            t = t.arr[idx];
            totalScore += t.score;  // Add the score for each character in the prefix
        }

        return totalScore;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie t = new Trie();
        int[] ans = new int[words.length];

        // Build the Trie with all words
        for (String word : words) {
            t.build(word);
        }

        // Calculate the prefix scores for each word
        for (int i = 0; i < words.length; i++) {
            ans[i] = t.getPrefixScore(words[i]);
        }

        return ans;
    }
}
