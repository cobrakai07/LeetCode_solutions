class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int[] lcsa = kmp(a);
        int[] lcsb = kmp(b);

        List<Integer> occa = findIndex(s,a,lcsa);
        List<Integer> occb = findIndex(s,b,lcsb);
        
        List<Integer> ans = new ArrayList<>();

        for(int it : occa){
            if(isPresent(occb, it-k, it+k)){
                ans.add(it);
            }
        }

        return ans;
    }

    private int[] kmp(String a){
        int[] lcs = new int[a.length()];

        for(int i = 1, j = 0;i < a.length();i++){
            while (j > 0 && a.charAt(i) != a.charAt(j)) {
                j = lcs[j - 1];
            }
            
            if (a.charAt(i) == a.charAt(j)) {
                j++;
            }
            
            lcs[i] = j;
        }

        return lcs;
    }

    private List<Integer> findIndex(String s, String a, int[] lcs){
        List<Integer> index = new ArrayList<>();

        for(int i = 0, j = 0;i < s.length();i++){
            while(j > 0 && s.charAt(i) != a.charAt(j)){
                j = lcs[j-1];
            }

            if(s.charAt(i) == a.charAt(j)){
                j++;
            }

            if(j == a.length()){
                index.add(i-j+1);
                j = lcs[j-1];
            }
        }

        return index;
    }

    private boolean isPresent(List<Integer> nums, int s, int e){
        int lo = 0, hi = nums.size()-1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(nums.get(mid) < s){
                lo = mid + 1;
            }
            else if(nums.get(mid) > e){
                hi = mid - 1;
            }
            else{
                return true;
            }
        }

        return false;
    }
}