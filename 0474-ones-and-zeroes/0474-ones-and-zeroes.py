class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        size = len(strs)
        oneCount = [0] * size
        zeroCount = [0] * size

        for i, s in enumerate(strs):
            oneCount[i] = s.count('1')
            zeroCount[i] = s.count('0')

        def fun(i, zc, oc):
            if zc > m or oc > n:
                return -99999 
            if i == size:
                return 0
            if dp[i][zc][oc] != -1:
                return dp[i][zc][oc]

            pick = 1 + fun(i + 1, zc + zeroCount[i], oc + oneCount[i])
            npick = fun(i + 1, zc, oc)

            dp[i][zc][oc] = max(pick, npick)
            return dp[i][zc][oc]

        
        dp = [[[-1 for _ in range(n + 1)] for _ in range(m + 1)] for _ in range(size)]

        return fun(0, 0, 0)
