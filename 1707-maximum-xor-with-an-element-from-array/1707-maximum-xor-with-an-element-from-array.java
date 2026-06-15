class Node {
    Node[] arr;
    boolean isLeaf;

    Node() {
        arr = new Node[2];
        isLeaf = false;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(String s) {
        Node temp = root;
        for (int i = 0; i < s.length(); i++) {

            int idx = s.charAt(i) - '0';
            if (temp.arr[idx] == null) {
                temp.arr[idx] = new Node();
            }
            if (i == s.length() - 1)
                temp.arr[idx].isLeaf = true;
            temp = temp.arr[idx];
        }
    }

    int max(String s) {
        Node temp = root;
        int max = 0;
        for (int i = 0, power = 31; i < s.length(); i++, power--) {

            int idx = s.charAt(i) - '0';
            if (idx == 1) {
                if (temp.arr[0] != null) {
                    max += (int) Math.pow(2, power);
                    temp = temp.arr[0];
                } else {
                    temp = temp.arr[1];
                }
            } else {
                if (temp.arr[1] != null) {
                    max += (int) Math.pow(2, power);
                    temp = temp.arr[1];
                } else {
                    temp = temp.arr[0];
                }
            }

        }
        return max;
    }
}

class Solution {
    public String pad(String s) {
        if (s.length() < 32) {
            int len = 32 - s.length();
            StringBuilder sb = new StringBuilder();
            while (len != 0) {
                sb.append('0');
                len--;
            }

            sb.append(s);
            s = sb.toString();
        }
        return s;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        Trie trie = new Trie();

        List<String> list = new ArrayList<>();

        Arrays.sort(nums);

        List<int[]> offlinequeries = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int arr[] = queries[i];
            offlinequeries.add(new int[] { arr[0], arr[1], i });
        }

        int[] ans = new int[queries.length];

        Collections.sort(offlinequeries, (a, b) -> Integer.compare(a[1], b[1]));

        int idx = 0;

        for (int[] arr : offlinequeries) {
            int x = arr[0], m = arr[1], ansIdx = arr[2];
            boolean hasVal = false;
            while (idx < nums.length && nums[idx] <= m) {

                String s = Integer.toBinaryString(nums[idx]);
                s = pad(s);

                trie.insert(s);
                idx++;
            }

            ans[ansIdx] = (idx == 0)
                    ? -1
                    : trie.max(pad(Integer.toBinaryString(x)));
        }

        return ans;
    }
}