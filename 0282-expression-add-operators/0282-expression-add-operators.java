class Solution {

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", num, target, 0, 0, 0);
        return ans;
    }

    private void backtrack(List<String> ans, String path, String num, int target,
                           int index, long value, long prevNum) {

        // base case
        if (index == num.length()) {
            if (value == target) ans.add(path);
            return;
        }

        // build current number
        for (int i = index; i < num.length(); i++) {
            // prevent leading zeros
            if (i != index && num.charAt(index) == '0') break;

            String part = num.substring(index, i + 1);
            long curr = Long.parseLong(part);

            if (index == 0) {
                // first number: start expression
                backtrack(ans, part, num, target, i + 1, curr, curr);
            } else {
                // addition
                backtrack(ans, path + "+" + part, num, target, i + 1, value + curr, curr);
                // subtraction
                backtrack(ans, path + "-" + part, num, target, i + 1, value - curr, -curr);
                // multiplication
                backtrack(ans, path + "*" + part, num, target, i + 1,
                          value - prevNum + prevNum * curr, prevNum * curr);
            }
        }
    }

   
}
