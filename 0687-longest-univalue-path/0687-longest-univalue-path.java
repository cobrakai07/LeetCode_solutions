class Solution {
    public int[] fun(TreeNode root) {
        if (root == null)
            return new int[] { -10000, -10000, 0 };
        int[] left = fun(root.left);
        int[] right = fun(root.right);

        if (left[0] == right[0]) {
            if (root.val == left[0]) {
                int currCount = Math.max(left[1], right[1]) + 1;

                int currMax = Math.max(Math.max(left[2], right[2]), left[1] + right[1] + 1);
                return new int[] { root.val, currCount, currMax };
            } else {
                int currCount = 1;
                int currMax = Math.max(currCount, Math.max(left[2], right[2]));
                return new int[] { root.val, currCount, currMax };
            }
        } else {
            if (root.val == left[0]) {
                int currCount = left[1] + 1;
                int currMax = Math.max(currCount, Math.max(left[2], right[2]));
                return new int[] { root.val, currCount, currMax };
            } else if (root.val == right[0]) {
                int currCount = right[1] + 1;
                int currMax = Math.max(currCount, Math.max(left[2], right[2]));
                return new int[] { root.val, currCount, currMax };
            } else {
                int currCount = 1;
                int currMax = Math.max(currCount, Math.max(left[2], right[2]));
                return new int[] { root.val, currCount, currMax };
            }
        }

    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        int[] arr = fun(root);
        return arr[2] - 1;
    }
}