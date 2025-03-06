class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
     Set<Integer>set= new HashSet<>();
     int rep=0, not=0;
     for(int a[]: grid){
        for(int i: a){
            if(set.contains(i))rep=i;
            else set.add(i);
        }
     }

     for(int i=1; i<=grid.length*grid.length;i++){
        if(!set.contains(i)){
            not=i;break;
        }
     }

     return new int[]{rep,not};   
    }
}