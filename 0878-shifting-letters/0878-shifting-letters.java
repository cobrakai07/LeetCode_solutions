class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder str = new StringBuilder();
        int sum = 0;


        for (int i = s.length() - 1; i >= 0; i--) {
            sum = (sum + shifts[i]) % 26;
            char ch = s.charAt(i);
            char newChar = (char)((ch - 'a' + sum) % 26 + 'a');
            str.insert(0, newChar);
        }

        return str.toString();
    }
}
