class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new ArrayDeque<>();
        //initially adding beginword and sequence length 1 into queue
        q.add(new Pair(beginWord,1));
        //adding all words in HashSet 
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String rem=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            if(rem.equals(endWord))return steps;
            
            //TC:N * rem.length * 26 *  0(1){hashset}
            //SC: 0(N) hashSet

            //for every character doing a change,so traverse to all the characters
            for(int i=0;i<rem.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedcharArray[]=rem.toCharArray();
                    replacedcharArray[i]=ch;
                    String replacedword=new String(replacedcharArray);
                    //exist in the set?
                    if(set.contains(replacedword)){
                        set.remove(replacedword);
                        q.add(new Pair(replacedword,steps+1));
                    }
                }
            }

        }
        return 0;

    }
}