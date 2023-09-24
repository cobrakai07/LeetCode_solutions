class Solution {
    private void fun(int idx, char[] arr, List<String> ans, StringBuilder str) {
        if (idx == arr.length) {
            ans.add(str.toString());
            return;
        }

        if ((arr[idx] >= 'A' && arr[idx] <= 'Z') || (arr[idx] >= 'a' && arr[idx] <= 'z')) {
            // Convert to lowercase and explore one branch
            char originalChar = arr[idx];
            arr[idx] = Character.toLowerCase(originalChar);
            str.append(arr[idx]);
            fun(idx + 1, arr, ans, str);

            // Revert back to the original character
            arr[idx] = originalChar;
            str.deleteCharAt(str.length() - 1);

            // Convert to uppercase and explore the other branch
            arr[idx] = Character.toUpperCase(originalChar);
            str.append(arr[idx]);
            fun(idx + 1, arr, ans, str);

            // Revert back to the original character
            arr[idx] = originalChar;
            str.deleteCharAt(str.length() - 1);
        } else {
            str.append(arr[idx]);
            fun(idx + 1, arr, ans, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        fun(0, arr, ans, new StringBuilder());
        return ans;
    }
}
