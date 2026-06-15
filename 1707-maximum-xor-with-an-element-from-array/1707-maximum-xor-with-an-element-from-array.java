class Node {
    Node[] arr;

    Node() {
        arr = new Node[2];
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node temp = root;

        for (int bit = 31; bit >= 0; bit--) {

            int currBit = (num >> bit) & 1;

            if (temp.arr[currBit] == null) {
                temp.arr[currBit] = new Node();
            }

            temp = temp.arr[currBit];
        }
    }

    int maxXor(int num) {
        Node temp = root;
        int max = 0;

        for (int bit = 31; bit >= 0; bit--) {

            int currBit = (num >> bit) & 1;
            int opposite = 1 - currBit;

            if (temp.arr[opposite] != null) {
                max |= (1 << bit);
                temp = temp.arr[opposite];
            } else {
                temp = temp.arr[currBit];
            }
        }

        return max;
    }
}

class Solution {

    public int[] maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);

        List<int[]> offlineQueries = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            offlineQueries.add(
                new int[]{queries[i][0], queries[i][1], i}
            );
        }

        offlineQueries.sort((a, b) ->
            Integer.compare(a[1], b[1])
        );

        Trie trie = new Trie();
        int[] ans = new int[queries.length];

        int idx = 0;

        for (int[] q : offlineQueries) {

            int x = q[0];
            int m = q[1];
            int ansIdx = q[2];

            while (idx < nums.length && nums[idx] <= m) {
                trie.insert(nums[idx]);
                idx++;
            }

            ans[ansIdx] =
                (idx == 0) ? -1 : trie.maxXor(x);
        }

        return ans;
    }
}