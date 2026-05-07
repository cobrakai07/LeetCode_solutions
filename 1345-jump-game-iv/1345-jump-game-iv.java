class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int id = queue.poll();

                if (id == n - 1)
                    return steps;

                if (id + 1 < n && !visited[id + 1]) {
                    visited[id + 1] = true;
                    queue.offer(id + 1);
                }

                if (id - 1 >= 0 && !visited[id - 1]) {
                    visited[id - 1] = true;
                    queue.offer(id - 1);
                }

                if (map.containsKey(arr[id])) {

                    for (int next : map.get(arr[id])) {

                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }

                    map.remove(arr[id]);
                }
            }

            steps++;
        }

        return -1;
    }
}