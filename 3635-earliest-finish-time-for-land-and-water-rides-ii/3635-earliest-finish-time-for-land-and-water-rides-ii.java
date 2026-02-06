class Solution {

    public int earliestFinishTime(
            int[] landStartTime, int[] landDuration,
            int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        List<int[]> waterRides = new ArrayList<>();
        List<int[]> landRides = new ArrayList<>();

        for (int i = 0; i < m; i++)
            waterRides.add(new int[]{waterStartTime[i], waterDuration[i]});

        for (int i = 0; i < n; i++)
            landRides.add(new int[]{landStartTime[i], landDuration[i]});

        waterRides.sort(Comparator.comparingInt(a -> a[0]));
        landRides.sort(Comparator.comparingInt(a -> a[0]));

        // ---------- WATER prefix & suffix ----------
        int[] waterPrefix = new int[m];
        int[] waterSuffix = new int[m];

        waterPrefix[0] = waterRides.get(0)[1];
        for (int i = 1; i < m; i++)
            waterPrefix[i] = Math.min(waterPrefix[i - 1], waterRides.get(i)[1]);

        waterSuffix[m - 1] =
                waterRides.get(m - 1)[0] + waterRides.get(m - 1)[1];
        for (int i = m - 2; i >= 0; i--)
            waterSuffix[i] = Math.min(
                    waterSuffix[i + 1],
                    waterRides.get(i)[0] + waterRides.get(i)[1]
            );

        // ---------- LAND prefix & suffix ----------
        int[] landPrefix = new int[n];
        int[] landSuffix = new int[n];

        landPrefix[0] = landRides.get(0)[1];
        for (int i = 1; i < n; i++)
            landPrefix[i] = Math.min(landPrefix[i - 1], landRides.get(i)[1]);

        landSuffix[n - 1] =
                landRides.get(n - 1)[0] + landRides.get(n - 1)[1];
        for (int i = n - 2; i >= 0; i--)
            landSuffix[i] = Math.min(
                    landSuffix[i + 1],
                    landRides.get(i)[0] + landRides.get(i)[1]
            );

        int ans = Integer.MAX_VALUE;

        // ---------- LAND -> WATER ----------
        for (int i = 0; i < n; i++) {
            int curr = landStartTime[i] + landDuration[i];
            int idx = upperBound(waterRides, curr);

            if (idx - 1 >= 0)
                ans = Math.min(ans, curr + waterPrefix[idx - 1]);

            if (idx < m)
                ans = Math.min(ans, waterSuffix[idx]);
        }

        // ---------- WATER -> LAND ----------
        for (int i = 0; i < m; i++) {
            int curr = waterStartTime[i] + waterDuration[i];
            int idx = upperBound(landRides, curr);

            if (idx - 1 >= 0)
                ans = Math.min(ans, curr + landPrefix[idx - 1]);

            if (idx < n)
                ans = Math.min(ans, landSuffix[idx]);
        }

        return ans;
    }

    private int upperBound(List<int[]> rides, int time) {
        int l = 0, r = rides.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (rides.get(mid)[0] <= time) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
