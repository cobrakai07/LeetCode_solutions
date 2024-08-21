class AuthenticationManager {
    Map<String,Integer>mp;
    int time;
    public AuthenticationManager(int timeToLive) {
        time=timeToLive;
        mp=new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        mp.put(tokenId,currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(mp.get(tokenId)==null)return;
        int t=mp.get(tokenId);
        if(t+time<=currentTime)return;
        else mp.put(tokenId,currentTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int c=0;
        // System.out.println(mp);
        for(String k: mp.keySet()){
            if(mp.get(k)+time>currentTime)
                c++;
        }
        return c;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */