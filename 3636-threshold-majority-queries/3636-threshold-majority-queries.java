import java.util.*;

class Solution {
    public int[] subarrayMajority(int[] nums, int[][] queries) {
        List<Query> list = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            list.add(new Query(queries[i][0], queries[i][1], i, queries[i][2]));
        }

        MosAlgorithm mosalgo = new MosAlgorithm(nums);
        mosalgo.sortQuery(list);

        return mosalgo.processQueries(list);
    }
}

class MosAlgorithm {
    int[] arr;
    int n;
    int blockSize;
    int currL = 0, currR = -1;

    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, TreeSet<Integer>> map = new HashMap<>();
    int max = 0;

    public MosAlgorithm(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        this.blockSize = (int) Math.sqrt(n);
    }

    public void sortQuery(List<Query> queries) {
        queries.sort((q1, q2) -> {
            int block1 = q1.left / blockSize;
            int block2 = q2.left / blockSize;
            if (block1 != block2) return block1 - block2;
            return q1.right - q2.right;
        });
    }

    public int[] processQueries(List<Query> queries) {
        int[] answers = new int[queries.size()];

        for (Query q : queries) {
            while (currL > q.left) add(--currL);
            while (currR < q.right) add(++currR);
            while (currL < q.left) remove(currL++);
            while (currR > q.right) remove(currR--);

            answers[q.idx] = getAnswer(q.threshold);
        }
        return answers;
    }

    public void add(int idx) {
        int val = arr[idx];
        int currFreq = freq.getOrDefault(val, 0);

        if (currFreq > 0) {
            TreeSet<Integer> set = map.get(currFreq);
            set.remove(val);
            if (set.isEmpty()) map.remove(currFreq);
        }

        freq.put(val, currFreq + 1);
        map.computeIfAbsent(currFreq + 1, k -> new TreeSet<>()).add(val);
        max = Math.max(max, currFreq + 1);
    }

    public void remove(int idx) {
        int val = arr[idx];
        int currFreq = freq.get(val);

        TreeSet<Integer> set = map.get(currFreq);
        set.remove(val);
        if (set.isEmpty()) map.remove(currFreq);

        if (currFreq == 1) {
            freq.remove(val);
        } else {
            freq.put(val, currFreq - 1);
            map.computeIfAbsent(currFreq - 1, k -> new TreeSet<>()).add(val);
        }

        while (max > 0 && !map.containsKey(max)) {
            max--;
        }
    }

    public int getAnswer(int threshold) {
        if (max < threshold) return -1;
        return map.get(max).first();
    }
}

class Query {
    int left, right, idx, threshold;

    Query(int left, int right, int idx, int threshold) {
        this.left = left;
        this.right = right;
        this.idx = idx;
        this.threshold = threshold;
    }
}
