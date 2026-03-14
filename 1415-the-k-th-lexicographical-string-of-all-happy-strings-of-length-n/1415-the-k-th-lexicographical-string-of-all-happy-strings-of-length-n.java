class Solution {
    String str = "";
    int counter;

    public void madeString(String s, int n, int k, boolean[] isFound) {
        if (isFound[0])
            return;
        if (n == 0) {
            counter++;
            if (counter == k) {
                str = s;
                isFound[0] = true;
            }
            return;
        }
        if (s.length() == 0) {

            for (char c = 'a'; c <= 'c'; c++) {
                s = s + c;
                madeString(s, n - 1, k, isFound);
                s = s.substring(0, s.length() - 1);
            }

        } else {

            for (char c = 'a'; c <= 'c'; c++) {
                if (s.charAt(s.length() - 1) == c)
                    continue;
                s = s + c;
                madeString(s, n - 1, k, isFound);
                s = s.substring(0, s.length() - 1);
            }

        }
    }

    public String getHappyString(int n, int k) {
        madeString("", n, k, new boolean[] { false });
        return str;
    }
}