import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> events = new ArrayList<>();
        for (int[] in : intervals) {
            events.add(new int[]{in[0], 1});   // start
            events.add(new int[]{in[1], -1});  // end
        }

        // Sort by position; if same position, process start (+1) BEFORE end (-1)
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1]; // start (1) comes before end (-1)
        });

        List<int[]> res = new ArrayList<>();
        int active = 0;
        int start = 0;

        for (int[] e : events) {
            if (active == 0 && e[1] == 1) {
                // new merged interval begins
                start = e[0];
            }
            active += e[1];
            if (active == 0) {
                // merged interval ends
                res.add(new int[]{start, e[0]});
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
