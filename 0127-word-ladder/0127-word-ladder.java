record Pair(String str, int len) {
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Set<String> vis = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.len() - b.len());
        pq.offer(new Pair(beginWord, 1));

        while (!pq.isEmpty()) {

            Pair pair = pq.poll();
            String s = pair.str();

            if (s.equals(endWord))
                return pair.len();
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {

                    char t = sb.charAt(i);
                    sb.setCharAt(i, c);
                    if (set.contains(sb.toString()) && !vis.contains(sb.toString())) {
                        vis.add(sb.toString());
                        pq.offer(new Pair(sb.toString(), pair.len() + 1));
                    }

                    sb.setCharAt(i, t);
                }

            }

        }
        return 0;
    }
}