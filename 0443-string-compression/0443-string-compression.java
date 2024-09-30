class Solution {
    public int compress(char[] chars) {
        char now = chars[0];
        int count = 1;
        int ans = 0;
        int idx = 0;
        for (int i = 1; i < chars.length; i++) {
            // System.out.println(i+" "+now+"//"+count);
            if (chars[i] != now) {

                if (count == 1) {
                    chars[idx++] = now;
                    ans++;
                } else {
                    chars[idx++] = now;
                    String ss = new String(count + "");
                    ans += ss.length()+1;
                    for (char cc : ss.toCharArray()) {
                        chars[idx++] = cc;
                    }
                }

                count = 1;
                now = chars[i];
            } else {
                count++;
            }
        }

        if (count == 1) {
            chars[idx++] = now;
            ans++;
        } else {
            chars[idx++] = now;
            String ss = new String(count + "");
            ans += ss.length()+1;
            for (char cc : ss.toCharArray()) {
                chars[idx++] = cc;
            }
        }

        return ans;
    }
}