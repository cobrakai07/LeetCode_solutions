class Solution {
    public int decode(int n, int[]mapping)
    {
        if(n==0)return mapping[0];

        List<Integer>list=new ArrayList<>();

        int newNum=0;
        int temp=n;

        while(n!=0)
        {
            int r=n%10;
            list.add(mapping[r]);
            n/=10;
        }

        for(int i=list.size()-1;i>=0;i--){
            newNum=newNum*10+list.get(i);
        }

        return newNum;

    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer>list=new ArrayList<>();
        // List<Integer>list1=new ArrayList<>();
        Map<Integer,Integer>mp=new HashMap<>();
        Map<Integer,Integer>mpIdx=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int newNum=decode(nums[i],mapping);
            mp.put(nums[i],newNum);
            mpIdx.put(nums[i],i);
            list.add(nums[i]);
            // list1.add(newNum);
        }

        //  System.out.println(list);
        //  System.out.println(list1);

        Collections.sort(list,(a,b)->{
            if(mp.get(a)==mp.get(b))return Integer.compare(mpIdx.get(a),mpIdx.get(b));
            else return Integer.compare(mp.get(a),mp.get(b));
        });
        // System.out.println(list);

        int ans[]=new int[list.size()];
        int idx=0;
        for(int i: list)
            ans[idx++]=i;
        return ans;
    }
}