class Solution {
    public int minOperations(int[][] grid, int x) {
       List<Integer>list = new ArrayList<>();
       for(int [] arr: grid)
            for(int i: arr)
                list.add(i);

        Collections.sort(list);

        for(int i: list){
            if(Math.abs(i-list.get(0))%x!=0)return -1;
        }

        int median = list.get(list.size()/2);
        int op=0;
        for(int i:list){
            op+=Math.abs(i-median)/x;
        }
        return op;
    }
}