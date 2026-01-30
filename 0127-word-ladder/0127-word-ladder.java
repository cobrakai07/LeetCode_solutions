class Node{
    String str;
    int steps;
    Node(String str, int steps){
        this.str = str;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String>set = new HashSet<>();
        for(String s: wordList){
            set.add(s);
        }

        Queue<Node> queue = new ArrayDeque<>();
        Set<String>vis = new HashSet<>();

        queue.offer(new Node(beginWord,1));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.str.equals(endWord))return node.steps;

            if(vis.contains(node.str))continue;
            vis.add(node.str);

            char [] arr = node.str.toCharArray();
            int steps = node.steps;
            
            for(int i=0; i<arr.length; i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char temp = arr[i];
                    arr[i]= ch;
                    String newStr = new String(arr);
                    if(set.contains(newStr)){
                        queue.offer(new Node(newStr,steps+1));
                    }
                    arr[i]=temp;
                }
            }
        }

        return 0;
    }
}