class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        int[] vis = new int[arr.length];

        while (!queue.isEmpty()) {

            int currIdx = queue.poll();
            if (vis[currIdx] == 1)
                continue;
            vis[currIdx] = 1;
            if (arr[currIdx] == 0)
                return true;

            if (currIdx + arr[currIdx] < arr.length)
                queue.offer(currIdx + arr[currIdx]);

            if (currIdx - arr[currIdx] >= 0)
                queue.offer(currIdx - arr[currIdx]);

        }

        return false;
    }
}