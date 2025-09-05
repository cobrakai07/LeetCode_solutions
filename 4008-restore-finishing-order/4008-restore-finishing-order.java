class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
       Set<Integer>set = new HashSet<>();
       for(int i: friends){
        set.add(i);
       } 
       int idx=0;
       for(int i: order){
        if(set.contains(i)){
            friends[idx++]=i;
        }
       }
       return friends;
    }
}