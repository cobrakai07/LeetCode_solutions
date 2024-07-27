class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int[][] aj = new int[26][26];
        for(int i[]: aj)
            Arrays.fill(i,Integer.MAX_VALUE);
        
        for(int i=0; i<cost.length; i++){
            aj[ original[i] - 'a'][ changed[i]-'a']= Math.min(cost[i] ,aj[ original[i] - 'a'][ changed[i]-'a']);
        }
        

        for (int midle = 0; midle < 26; midle++) {
            for (int sou = 0; sou < 26; sou++) {
                for (int destination = 0; destination < 26; destination++) {
                    if (aj[sou][midle] < Integer.MAX_VALUE && aj[midle][destination] < Integer.MAX_VALUE) {
                        aj[sou][destination] = Math.min(
                            aj[sou][destination], aj[sou][midle] + aj[midle][destination]
                        );
                    }
                }
            }
        }

        // for(int i[]: aj)
        //     System.out.println(Arrays.toString(i));

        long ansCost=0;

        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i)){
                if(aj[source.charAt(i)-'a'][target.charAt(i)-'a']==Integer.MAX_VALUE)return -1;
                else ansCost+=aj[source.charAt(i)-'a'][target.charAt(i)-'a'];
            }
        }


         return ansCost;
    }
}