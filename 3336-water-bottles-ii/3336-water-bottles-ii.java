class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int td=0;
        int fullBottles=numBottles, emptyBottles=0;
        while(fullBottles!=0)
        {
            td+=fullBottles;
            emptyBottles+=fullBottles;
            fullBottles=0;
            while(numExchange<=emptyBottles)
            {
                emptyBottles-=numExchange;
                numExchange++;
                fullBottles++; 
            }
        }
        return td;
    }
}