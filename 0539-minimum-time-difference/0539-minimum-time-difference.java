import java.util.*;

class Solution {
    public int fun(String s) {
        String hour = s.substring(0, s.indexOf(':'));
        String mins = s.substring(s.indexOf(':') + 1);
        int n1 = Integer.parseInt(hour) * 60;
        int n2 = Integer.parseInt(mins);
        return n1 + n2;
    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> min = new ArrayList<>();
        for (String s : timePoints) {
            min.add(fun(s));
        }
        Collections.sort(min);
        int minDifference = Integer.MAX_VALUE;
        int n = min.size();
        for (int i = 1; i < n; i++) {
            int diff = min.get(i) - min.get(i - 1);
            minDifference = Math.min(minDifference, diff);
        }

        // System.out.println(min);
        return Math.min(minDifference, 24 * 60 - (min.get(n - 1) - min.get(0)));
    }
}
