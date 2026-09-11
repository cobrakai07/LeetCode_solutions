class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if ((digits[i] % 2) == 0) {
                StringBuilder sb = new StringBuilder(digits[i] + "");
                for (int j = 0; j < digits.length; j++) {
                    if (i == j)
                        continue;

                    sb.append(digits[j]);

                    for (int k = 0; k < digits.length; k++) {
                        if (i == k || j == k)
                            continue;

                        sb.append(digits[k]);
                        int num = Integer.parseInt(sb.reverse().toString());
                        sb.reverse();
                        String str = num + "";
                        if (str.length() == 3)
                            set.add(num);
                        sb = new StringBuilder(sb.substring(0, sb.length() - 1));

                    }
                    sb = new StringBuilder(sb.substring(0, sb.length() - 1));

                }

            }
        }
        // System.out.println(set);
        return set.size();
    }
}