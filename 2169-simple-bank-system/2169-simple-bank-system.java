class Bank {
    Map<Integer,Long>mp;
    public Bank(long[] balance) {
        mp=new HashMap<>();
        for(int i=0;i<balance.length;i++)
            mp.put(i+1,balance[i]);
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(mp.get(account1)==null||mp.get(account2)==null)return false;
        if(mp.get(account1)<money)return false;

        mp.put(account2,mp.get(account2)+money);
        mp.put(account1,mp.get(account1)-money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(mp.get(account)==null)return false;
        mp.put(account,mp.get(account)+money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(mp.get(account)==null)return false;
        if(mp.get(account)<money)return false;
        mp.put(account,mp.get(account)-money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */