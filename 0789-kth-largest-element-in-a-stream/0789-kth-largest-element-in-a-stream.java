class KthLargest {
    ArrayList <Integer> list= new ArrayList<>();
    int idx=0;
    public KthLargest(int k, int[] nums) {
     //Arrays.sort(nums);
     for(int x: nums)
     {
         list.add(x);
     }
     idx=k;

    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size()-idx);
    }
}
