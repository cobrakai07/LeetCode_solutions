class Solution {
    int ascii1[] = null;
    int ascii2[] = null;

    public int asciiCalculate(int i, int[] arr) {
        return i == 0 ? arr[arr.length - 1] : arr[arr.length - 1] - arr[i - 1];
    }

    public int fun(int i, int j, char[] arr1, char[] arr2, int[][] dp) {

        if (i == arr1.length && j == arr2.length)
            return 0;
        if (i == arr1.length)
            return asciiCalculate(j, ascii2);
        if (j == arr2.length)
            return asciiCalculate(i, ascii1);

        if (dp[i][j] != -1)
            return dp[i][j];

        if (arr1[i] == arr2[j]) {
            return dp[i][j] = fun(i + 1, j + 1, arr1, arr2, dp);
        } else {
            int asci1 = arr1[i];
            int asci2 = arr2[j];

            int one = (asci1 + asci2) + fun(i + 1, j + 1, arr1, arr2, dp);
            int two = (asci1) + fun(i + 1, j, arr1, arr2, dp);
            int three = (asci2) + fun(i, j + 1, arr1, arr2, dp);

            return dp[i][j] = Math.min(one, Math.min(two, three));
        }
    }

    public int minimumDeleteSum(String s1, String s2) {
        ascii1 = new int[s1.length()];
        ascii2 = new int[s2.length()];

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        ascii1[0] = arr1[0];
        ascii2[0] = arr2[0];

        for (int i = 1; i < arr1.length; i++) {
            char c = arr1[i];
            ascii1[i] = (int) c;
            ascii1[i] += ascii1[i - 1];
        }
        for (int i = 1; i < arr2.length; i++) {
            char c = arr2[i];
            ascii2[i] = (int) c;
            ascii2[i] += ascii2[i - 1];
        }

        int[][] dp = new int[arr1.length][arr2.length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return fun(0, 0, arr1, arr2, dp);
    }
}