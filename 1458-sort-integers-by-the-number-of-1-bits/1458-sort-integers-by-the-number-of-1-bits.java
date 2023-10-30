class Solution {
    public int fun(int num)
    {
        String str="";
        int count=0;
        while(num!=0)
        {
            int rem=num%2;
             if(rem==1)count++;
              str=rem+str;
            num=num/2;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        int[]bit=new int[arr.length];
        for(int i=0;i<arr.length;i++)
           bit[i]=fun(arr[i]);
        // for(int i=0;i<arr.length;i++)
        // System.out.print(bit[i]+" ");

        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(bit[i]==bit[j])
                {
                    if(arr[i]>arr[j])
                    {
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
                else if(bit[i]>bit[j])
                {
                    int temp=bit[i];
                    bit[i]=bit[j];
                    bit[j]=temp;

                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}