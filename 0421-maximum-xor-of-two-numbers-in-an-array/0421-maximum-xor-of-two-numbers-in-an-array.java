class Node{
    Node[]arr;
    boolean isLeaf;
    Node(){
        arr = new Node[2];
        isLeaf = false;
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    void insert(String s){
        Node temp = root;
        for(int i=0;i<s.length();i++){
            
            int idx = s.charAt(i)-'0';
            if(temp.arr[idx]==null){
                temp.arr[idx] = new Node();
            }
            if(i==s.length()-1)temp.arr[idx].isLeaf = true;
            temp = temp.arr[idx];
        }
    }

    int max(String s){
        Node temp = root;
        int max = 0;
        for(int i=0, power = 31;i<s.length();i++,power--){
            
            int idx = s.charAt(i)-'0';
            if(idx==1){
                if(temp.arr[0]!=null){
                    max += (int)Math.pow(2,power);
                    temp = temp.arr[0];
                }else{
                    temp = temp.arr[1];
                }
            }else{
                if(temp.arr[1]!=null){
                    max += (int)Math.pow(2,power);
                    temp = temp.arr[1];
                }else{
                    temp = temp.arr[0];
                }
            }
            
        }
        return max;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        List<String> list = new ArrayList<>();
        for(int i: nums){
            String s = Integer.toBinaryString(i);
            if(s.length()<32){
                int len = 32-s.length();
                StringBuilder sb = new StringBuilder();
                while(len!=0){
                    sb.append('0');
                    len--;
                }
                
                sb.append(s);
                s= sb.toString();
                // System.out.println(s.length()+" "+s);
            }
            list.add(s);
            trie.insert(s);
        }

        int max =0;

        for(String s: list){
            max = Math.max(max,trie.max(s));
        }

        return max;
    }
}