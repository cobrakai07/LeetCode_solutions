class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int ans=0;
        for(int k: nums)
        {
            if(map.get(k)==null)
               {
                   map.put(k,1);
               }
            else
            {
                ans=ans+map.get(k);
                map.put(k,map.get(k)+1);
            }
        }
        return ans;
    }
}
/*
Imagine this problem like, There is a gathering organized by some guy, the guest list is [1,2,3,1,1,3].
The problem with the guest is they only handshake with like minded people. (Like minded here is basically the digit should be same , for example, 1 will handshake with 1 only, 2 will handshake with 2 only and so on)

So, finally we just need to count number of handshakes in the gathering. \U0001f4af \U0001f4af

(To distinguish , multiple 1's and 3's , a,b,c,d... letters are used)

\U0001f525 the day of arrival \U0001f525

one by one guests are arriving at the gathering

✅ first guest: 1

✅ second guest: 2
(at this moment, in gathering hall we have 1 (2 is about to enter) , since they are not like minded they wont shake hands)

✅ third guest:3
(at this moment, in gathering hall we have 1 ,2 (3 is about to enter), since they are not like minded they wont shake hands)

✅ fourth guest : 1
(at this moment, fourth guest will see in gathering hall , there is one like minded guy ie(1) , so he will handshake with him)
therefore totalHandShake = 1

✅ fifth guest : 1
(at this moment, fifth guest will see in gathering hall, there are two like minded guys ie(1,1) , so he will handshake with them)
therefore totalHandShake = 1(last handshake between 1a-1b ) + 2(current handshake between 1a-1c, 1b-1c) = 3

✅ sixth guest : 3
(at this moment, sixth guest will see in gathering hall, there is one like minded guy ie(3) , so he will handshake with him)
therefore totalHandShake = 3(last handshake) + 1(3a-3b) = 4

Here, in code we can imagine

given array as guest list.
Hashmap as gathering hall
ans as totalHandshakes.
*/

