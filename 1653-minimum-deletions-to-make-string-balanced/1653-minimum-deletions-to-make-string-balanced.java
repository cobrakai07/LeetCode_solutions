class Solution {
    public int minimumDeletions(String s) {

        int min = 0;
        ArrayDeque<Character> stk = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stk.isEmpty() && c == 'a' && stk.peek() == 'b') {
                stk.pop();
                min++;
            } else {
                stk.push(c);
            }
        }

        return min;
    }
}