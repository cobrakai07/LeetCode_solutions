class Node {
    Node[] arr;
    int minLen;
    int minIdx;

    Node() {
        arr = new Node[26];
        minLen = Integer.MAX_VALUE;
        minIdx = Integer.MAX_VALUE;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void update(Node node, int len, int idx) {
        if (node.minLen > len) {
            node.minLen = len;
            node.minIdx = idx;
        } else if (node.minLen == len) {
            node.minIdx = Math.min(node.minIdx, idx);
        }
    }

    void add(int idx, String s) {
        Node temp = root;
        int len = s.length();


        update(temp, len, idx);

        for (int i = len - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            if (temp.arr[c] == null) {
                temp.arr[c] = new Node();
            }

            temp = temp.arr[c];

            update(temp, len, idx);
        }
    }

    int search(String s) {
        Node temp = root;
        int ans = root.minIdx;

        for (int i = s.length() - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';

            if (temp.arr[idx] == null) {
                break;
            }

            temp = temp.arr[idx];
            ans = temp.minIdx;
        }

        return ans;
    }
}

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();

        for (int i = 0; i < wordsContainer.length; i++) {
            trie.add(i, wordsContainer[i]);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = trie.search(wordsQuery[i]);
        }

        return ans;
    }
}