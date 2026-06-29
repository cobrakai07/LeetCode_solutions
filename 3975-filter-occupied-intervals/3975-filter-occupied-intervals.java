class Solution {
    public List<List<Integer>> filterOccupiedIntervals(
            int[][] occupiedIntervals,
            int freeStart,
            int freeEnd) {

        Arrays.sort(occupiedIntervals, (a, b) ->
                a[0] == b[0]
                        ? Integer.compare(a[1], b[1])
                        : Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int start = occupiedIntervals[0][0];
        int end = occupiedIntervals[0][1];

        for (int i = 1; i < occupiedIntervals.length; i++) {
            int s = occupiedIntervals[i][0];
            int e = occupiedIntervals[i][1];

            // overlap OR touching
            if (s <= end + 1) {
                end = Math.max(end, e);
            } else {
                merged.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }

        merged.add(new int[]{start, end});

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] interval : merged) {
            int s = interval[0];
            int e = interval[1];

            // no overlap
            if (e < freeStart || s > freeEnd) {
                ans.add(List.of(s, e));
                continue;
            }

            // left piece
            if (s < freeStart) {
                ans.add(List.of(s, freeStart - 1));
            }

            // right piece
            if (e > freeEnd) {
                ans.add(List.of(freeEnd + 1, e));
            }
        }

        return ans;
    }
}