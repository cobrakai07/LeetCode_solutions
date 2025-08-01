class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>list1 = new ArrayList<>();
        list1.add(1);ans.add(list1);
        if(numRows==1)return ans;
        List<Integer>list2 = new ArrayList<>();
        list2.add(1);list2.add(1);ans.add(list2);
        if(numRows==2)return ans;


        while(numRows-2!=0){
            List<Integer>pre = ans.get(ans.size()-1);
            List<Integer>list = new ArrayList<>();
            list.add(1);
            int i=0,j=1;
            while(j<pre.size()){
                list.add(pre.get(i)+pre.get(j));
                i++;j++;
            }
            list.add(1);
            ans.add(list);
            numRows--;
        }

        return ans;
    }
}