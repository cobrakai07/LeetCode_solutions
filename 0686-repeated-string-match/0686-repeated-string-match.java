class Solution {

    int rabinKarp(String str, String pattern) {

        int n = str.length();
        int m = pattern.length();

        if (m > n)
            return -1;

        long base = 31;
        long mod = 1_000_000_007L;

        long power = 1;
        long patternHash = 0;
        long windowHash = 0;

        // BASE^(m-1)
        for (int i = 0; i < m - 1; i++) {
            power = (power * base) % mod;
        }

        for (int i = 0; i < m; i++) {

            patternHash = ((patternHash * base)
                    + (pattern.charAt(i) - 'a' + 1))
                    % mod;

            windowHash = ((windowHash * base)
                    + (str.charAt(i) - 'a' + 1))
                    % mod;
        }

        for (int i = 0; i <= n - m; i++) {

            if (windowHash == patternHash) {

                if (str.substring(i, i + m)
                        .equals(pattern)) {
                    return i;
                }
            }

            if (i < n - m) {

                long leftChar = str.charAt(i) - 'a' + 1;

                long newChar = str.charAt(i + m) - 'a' + 1;

                windowHash = (windowHash
                        - (leftChar * power) % mod
                        + mod) % mod;

                windowHash = ((windowHash * base)
                        + newChar) % mod;
            }
        }

        return -1;
    }

    public int repeatedStringMatch(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (rabinKarp(sb.toString(), b) != -1) {
            return count;
        }

     
        sb.append(a);

        if (rabinKarp(sb.toString(), b) != -1) {
            return count + 1;
        }

        return -1;
    }
}