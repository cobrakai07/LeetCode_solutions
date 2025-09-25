class Solution {
    public List<Integer> mergeIntervals(List<int[]> intervals) {

        Collections.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        List<int[]> mergedIntervals = new ArrayList<>();

        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {

            int in[] = intervals.get(i);

            if (end >= in[0]) {
                end = Math.max(end, in[1]);
            } else {
                mergedIntervals.add(new int[] { start, end });
                end = in[1];
                start = in[0];
            }
        }
        mergedIntervals.add(new int[] { start, end });

        List<Integer> ans = new ArrayList<>();

        for (int[] in : mergedIntervals) {
            ans.add(in[1] - in[0] + 1);
        }

        return ans;
    }

    public List<int[]> makeIntervals(String s) {
        int[] startIdx = new int[26];
        int[] endIdx = new int[26];

        Arrays.fill(startIdx, -1);
        Arrays.fill(endIdx, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (startIdx[c - 'a'] == -1)
                startIdx[c - 'a'] = i;
            endIdx[c - 'a'] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (startIdx[i] != -1)
                intervals.add(new int[] { startIdx[i], endIdx[i] });
        }

        return intervals;
    }

    public List<Integer> partitionLabels(String s) {
        List<int[]> intervals = makeIntervals(s);
        return mergeIntervals(intervals);
    }
}