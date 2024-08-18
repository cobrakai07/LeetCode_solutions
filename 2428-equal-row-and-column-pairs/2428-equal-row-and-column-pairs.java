class Solution {
    public int equalPairs(int[][] grid) {
        List<int[]>list=new ArrayList<>();
       for(int i=0; i<grid.length;i++){
            int []arr= new int[grid.length];
            for(int j=0;j<grid.length;j++){
                arr[j]=grid[j][i];
            }
            list.add(arr);
       }
    int c=0;
       for(int i=0; i<grid.length;i++){
            int[] arr=grid[i];
            for(int j=0; j<list.size();j++){
                if(Arrays.equals(arr,list.get(j)))c++;
            }
       }
       return c;
        
    }
}