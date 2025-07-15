class Solution {
    public boolean isValid(String word) {
        String vows = "aeiou";
        String vowl = "AEIOU";

        if (word.length() < 3)
            return false;
        boolean c = false, v = false, n = true;
        for (char ch : word.toCharArray()) {
            int ascii = ch;
            if (ascii >= 48 && ascii <= 57) {
                n = true;
            } else if ((65 <= ascii && 90 >= ascii) || (97 <= ascii && 122 >= ascii)) {
                // System.out.println(ch + "  ..");
                if (vows.indexOf(ch) != -1 || vowl.indexOf(ch) != -1)
                    v = true;
                else
                    c = true;
            } else {
                // System.out.println(ch);
                return false;
            }
        }
        return c && v;
    }
}