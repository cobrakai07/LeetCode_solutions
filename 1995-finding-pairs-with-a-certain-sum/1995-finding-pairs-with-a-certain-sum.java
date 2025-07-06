class FindSumPairs {
    Map<Integer,Integer>mp = new HashMap<>();
    // Map<Integer,Integer>mpIdx = new HashMap<>();
    int[]nums1,nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2=nums2;
        this.nums1=nums1;
        for(int i=0;i<nums2.length;i++){
            mp.put(nums2[i],mp.getOrDefault(nums2[i],0)+1);
        }
    }
    
    public void add(int index, int val) {
        int c = mp.get(nums2[index]);
        c--;
        mp.put(nums2[index],c);
        nums2[index]+=val;
        mp.put(nums2[index],mp.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {
        int c=0;
        for(int i=0; i<nums1.length;i++){
            if(mp.get(tot-nums1[i])!=null){
                c=c+mp.get(tot-nums1[i]);
            }
        }
        return c;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */