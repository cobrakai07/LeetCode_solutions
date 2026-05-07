class Solution {

    record Node(int id, int step) {}

    public int minJumps(int[] arr) {

        int n = arr.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int val = arr[i];

            if (map.get(val) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(val, list);
            } else {
                List<Integer> list = map.get(val);
                list.add(i);
            }
        }

        boolean[] visited = new boolean[n];

        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            int id = node.id();
            int step = node.step();

            if (visited[id])
                continue;

            visited[id] = true;

            if (id == n - 1)
                return step;

            if (id + 1 < n)
                queue.offer(new Node(id + 1, step + 1));

            if (id - 1 >= 0)
                queue.offer(new Node(id - 1, step + 1));

            if (!map.containsKey(arr[id]))
                continue;

            List<Integer> list = map.get(arr[id]);

            for (int nid : list) {
                queue.offer(new Node(nid, step + 1));
            }

            map.remove(arr[id]);
        }

        return -1;
    }
}