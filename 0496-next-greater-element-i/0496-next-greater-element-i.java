class Solution {
    public Stack<Integer> stackFill(int[]arr)
    {
        Stack<Integer>stk=new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            stk.push(arr[i]);
        }
        return stk;
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int ans[]=new int[nums1.length];

        for(int i=0;i<nums1.length;i++)
        {
            Stack<Integer>stk=stackFill(nums2);
            while(!stk.isEmpty()&&stk.peek()!=nums1[i])
                stk.pop();
            if(stk.isEmpty()) 
                ans[i]=-1;
               
            if(stk.peek()==nums1[i])
            {
                 stk.pop();
                System.out.println("milaaa");
                while(!stk.isEmpty()&&stk.peek()<nums1[i])
                    stk.pop();
                if(stk.isEmpty()) 
                   ans[i]=-1;
                else
                   ans[i]=stk.peek();
            }
        }
        return ans;
    }
}