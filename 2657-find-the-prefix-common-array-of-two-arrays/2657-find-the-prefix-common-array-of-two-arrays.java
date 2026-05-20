class Solution {
    public int find_common(Map<Integer,Integer> map_a, Map<Integer,Integer> map_b){
        int count = 0;
        for(int key: map_a.keySet()){
            if(map_b.containsKey(key)){
                count += Math.min(map_a.get(key),map_b.get(key));
            }
        }
        return count;
    }
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        Map<Integer,Integer> map_a = new HashMap<>();
        Map<Integer,Integer> map_b = new HashMap<>();
        for(int i=0;i<n;i++){
            map_a.put(A[i],map_a.getOrDefault(A[i],0)+1);
            map_b.put(B[i],map_b.getOrDefault(B[i],0)+1);
            ans[i]= find_common(map_a,map_b);
        }
        return ans;
    }
}