public class Solution {
    int nCr(int n, int r) {
        if (r > n - r) r = n - r; // C(n, r) == C(n, n - r)
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(nCr(rowIndex, i));
        }
        return ans;
    }
}
