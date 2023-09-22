class Solution {
    public List<Integer> fun(List<Integer> list)
    {
        List<Integer>temp=new ArrayList<>();
        temp.add(1);
        for(int i=0,j=1;i<list.size()&&j<list.size();i++,j++)
        {
            temp.add(list.get(i)+list.get(j));
        }
        temp.add(1);
        return temp;
    }
    public List<Integer> getRow(int rowIndex) {
         List<List<Integer>>ans=new ArrayList<>();

        List<Integer>temp1=new ArrayList<>();
        temp1.add(1);
        ans.add(temp1);
        if(rowIndex==0)return temp1;

        List<Integer>temp2=new ArrayList<>();
        temp2.add(1);
        temp2.add(1);
        ans.add(temp2);
        if(rowIndex==1)return temp2;

         int idx = rowIndex;
        while((rowIndex-1)!=0)
        {
            List<Integer>curr=fun(ans.get(ans.size()-1));
            ans.add(curr);
            rowIndex--;
        }

        return ans.get(idx);
    }
}