class Node {
    Node[] arr;

    Node() {
        arr = new Node[10];
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void add(int i, Node node, String num) {
        if (i == num.length()) {
            return;
        }
        int number = num.charAt(i) - '0';
        if (node.arr[number] == null) {
            node.arr[number] = new Node();
            add(i + 1, node.arr[number], num);
        } else {
            add(i + 1, node.arr[number], num);
        }
    }

    int prefixLen(int i, Node node, String num) {
        if (i == num.length())
            return 0;
        int number = num.charAt(i) - '0';
        if (node.arr[number] == null)
            return 0;
        int len = 0;
        len = 1 + prefixLen(i + 1, node.arr[number], num);
        return len;
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for (int i : arr1) {
            String num = i + "";
            trie.add(0, trie.root, num);
        }

        int max = 0;

        for (int i : arr2) {
            String num = i + "";
            max = Math.max(max, trie.prefixLen(0, trie.root, num));
        }

        return max;
    }
}