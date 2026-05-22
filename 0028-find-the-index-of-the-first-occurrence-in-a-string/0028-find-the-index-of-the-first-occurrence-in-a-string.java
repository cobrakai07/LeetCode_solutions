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

        for (int i = 0; i < m - 1; i++) {
            power = (power * base) % mod;
        }

        for (int i = 0; i < m; i++) {

            windowHash = ((windowHash * base) + (str.charAt(i) - 'a' + 1)) % mod;

            patternHash = ((patternHash * base) + (pattern.charAt(i) - 'a' + 1)) % mod;
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

                windowHash = (windowHash - (leftChar * power) % mod + mod) % mod;

                windowHash = ((windowHash * base)+ newChar) % mod;
            }
        }

        return -1;
    }

    public int strStr(String haystack,
            String needle) {

        return rabinKarp(haystack, needle);
    }
}