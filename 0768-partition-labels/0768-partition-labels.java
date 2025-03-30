class Solution {
  public int[][] combineIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int mergedCount = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= intervals[mergedCount][1]) {
        intervals[mergedCount][1] = Math.max(intervals[i][1], intervals[mergedCount][1]);
      } else {
        intervals[++mergedCount] = intervals[i];
      }
    }

    return Arrays.copyOf(intervals, mergedCount + 1);
  }

  public List<Integer> partitionLabels(String s) {

    Map<Character, int[]> mp = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (mp.get(s.charAt(i)) == null) {
        int a[] = { i, i };
        mp.put(s.charAt(i), a);
      } else {
        int a[] = mp.get(s.charAt(i));
        a[1] = i;
        mp.put(s.charAt(i), a);
      }
    }

    int arr[][] = new int[mp.size()][2];
    int idx = 0;
    for (char c : mp.keySet())
      arr[idx++] = mp.get(c);

    // merge interval

    arr = combineIntervals(arr);
    for (int i[] : arr)
      ans.add(i[1] - i[0] + 1);

    return ans;
  }
}