record Pair(int row, int col, int val){}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Pair>pq= new PriorityQueue<>((a,b)->{
            if(a.val()==b.val()){
                if(a.row()==b.row()){
                    return a.col()-b.col();
                }else{
                    return a.row()-b.row();
                }
            }else {
                return a.val()-b.val();
            }
        });

        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;

        for(int i=0; i<nums.size(); i++){
            pq.offer(new Pair(i,0,nums.get(i).get(0)));
            max=Math.max(max,nums.get(i).get(0));
        }

        min=pq.peek().val();
        int []ans={min,max};

        while(pq.size()==nums.size()){
            Pair temp=pq.poll();
            int val=temp.val();
            int row=temp.row();
            int col=temp.col();

            if(col+1<nums.get(row).size()){
                col++;
                pq.offer(new Pair(row,col,nums.get(row).get(col)));
                max=Math.max(max,nums.get(row).get(col));
                min=pq.peek().val();
            }

            if(max-min<ans[1]-ans[0]){
                ans[0]=min;
                ans[1]=max;
            }

        }
        
    return ans;
    }
}