class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(b[1], a[1]);
            else
                return Integer.compare(a[0], b[0]);
        });
        int count = 0;
        int s = intervals[0][0], e = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if (s <= a && b <= e) {
                count--;
            } else {
                s = a;
                e = b;
            }
        }
        return intervals.length + count;
    }
}