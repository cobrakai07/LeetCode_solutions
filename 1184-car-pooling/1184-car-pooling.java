class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] cap = new int[1001]; // locations 0 to 1000

        for (int[] a : trips) {
            int c = a[0], x = a[1], y = a[2];
            cap[x] += c;
            cap[y] -= c;
        }

        int curr = 0;
        for (int i = 0; i < cap.length; i++) {
            curr += cap[i];
            if (curr > capacity) return false;
        }

        return true;
    }
}
