class Node {
    String str;
    int steps;

    Node(String str, int steps) {
        this.str = str;
        this.steps = steps;
    }
}

class Solution {
    Set<List<String>> ans;

    public Map<String, Integer> ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();

        Set<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }

        int currLevel = 0;

        Queue<Node> queue = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();

        queue.offer(new Node(beginWord, 1));

        boolean foundAtThisLevel = false;

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<String> usedOnLevel = new ArrayList<>();
            for (int it = 0; it < level; it++) {
                Node node = queue.poll();

                if (map.get(node.str) == null) {
                    map.put(node.str, currLevel);
                }

                if (node.str.equals(endWord)) {
                    foundAtThisLevel = true;
                }
                usedOnLevel.add(node.str);
                if (vis.contains(node.str))
                    continue;
                vis.add(node.str);

                char[] arr = node.str.toCharArray();
                int steps = node.steps;

                for (int i = 0; i < arr.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char temp = arr[i];
                        arr[i] = ch;
                        String newStr = new String(arr);
                        if (set.contains(newStr)) {
                            queue.offer(new Node(newStr, steps + 1));
                        }
                        arr[i] = temp;
                    }
                }

            }

            if (foundAtThisLevel)
                break;

            for (String str : usedOnLevel)
                set.remove(str);
            currLevel++;
        }

        return map;
    }

    public void rev(List<String> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            String temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public boolean diff(String s, String t) {
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i) && flag) {
                return false;
            } else if (s.charAt(i) != t.charAt(i)) {
                flag = true;
            }
        }
        return true;
    }

    public void backtrack(String str, int level, List<String> list, List<String> wordList, Map<String, Integer> map,
            String beginWord) {
        // System.out.println(list+" ..."+level);
        if (level == 1) {
            List<String> temp = new ArrayList<>(list);
            temp.add(beginWord);
            rev(temp);
            ans.add(temp);

            return;
        }
        for (String s : wordList) {
            if (map.get(s) != null && map.get(s) == level - 1 && diff(str, s)) {
                list.add(s);
                backtrack(s, level - 1, list, wordList, map, beginWord);
                list.remove(list.size() - 1);
            }
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new HashSet<>();

        Map<String, Integer> map = ladderLength(beginWord, endWord, wordList);
        // System.out.println(map);
        if (map.get(endWord) == null)
            return new ArrayList(ans);
        ;
        backtrack(endWord, map.get(endWord), new ArrayList<>(List.of(endWord)), wordList, map, beginWord);

        return new ArrayList(ans);
    }
}
