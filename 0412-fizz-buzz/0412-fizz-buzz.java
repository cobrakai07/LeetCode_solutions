class Solution {
    public List<String> fizzBuzz(int n) {
        List<String>ans=new ArrayList<>();
        String dby3a5="FizzBuzz";
        String dby3="Fizz";
        String dby5="Buzz";
        for(int i=1;i<=n;i++)
        {
            if(i%3==0&&i%5==0)
               ans.add(dby3a5);
            else if(i%3==0)
                ans.add(dby3);
            else if(i%5==0)
                ans.add(dby5);
            else
                ans.add(i+"");
        }
        return ans;
    }
}