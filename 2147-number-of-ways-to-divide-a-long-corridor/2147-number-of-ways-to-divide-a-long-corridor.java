	class Solution {
		public int numberOfWays(String corridor) {
			char[] s = corridor.toCharArray();
			int n = s.length;

			List<Integer> ss = new ArrayList<>();
			for(int i = 0;i < n;i++){
				if(s[i] == 'S')ss.add(i);
			}
			if(ss.size() % 2 == 1 || ss.size() == 0){
				return 0;
			}
			final int mod = 1000000007;
			long ans = 1;
			for(int i = 1;i+1 < ss.size();i+=2){
				ans = ans * (ss.get(i+1) - ss.get(i)) % mod;
			}
			return (int)ans;
		}
	}