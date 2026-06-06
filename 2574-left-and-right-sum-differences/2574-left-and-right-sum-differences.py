class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        n = len(nums)
        pre=[0]*n
        post = [0]*n
        ans = [0]*n
        
        idx = 1
        while idx<n:
            pre[idx] = pre[idx-1]+nums[idx-1]
            idx+=1
        # print(pre)
        idx = n-2
        while idx>=0:
            post[idx] = post[idx+1]+nums[idx+1]
            idx-=1
        # print(post)
        idx = 0
        while idx<n:
            ans[idx] = abs(pre[idx]-post[idx])
            idx+=1
        return ans