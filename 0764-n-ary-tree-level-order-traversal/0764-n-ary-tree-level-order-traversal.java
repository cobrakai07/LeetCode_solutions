/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>>ans= new ArrayList<>();
        List<Pair<Node,Integer>>extender= new ArrayList<>();
        if(root==null)return ans;
        
        Queue<Pair<Node,Integer>>q=new ArrayDeque<>();

        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        {
          Pair<Node,Integer>p=q.poll();
          extender.add(p);
          Node temp = p.getKey();
          int level = p.getValue();

          List<Node> list=temp.children;

          for(int i=0;i<list.size();i++)
          {
            q.offer(new Pair(list.get(i),level+1));
          }   
        }

        List<Integer>temp= new ArrayList<>();
        int curr=-1;

        for(int i=0;i<extender.size();i++)
        {
          if(curr!=extender.get(i).getValue())
          {
            ans.add(temp);
            temp= new ArrayList<>();
            temp.add(extender.get(i).getKey().val);
            curr=extender.get(i).getValue();
            continue;

          }
         temp.add(extender.get(i).getKey().val);
        }
        ans.remove(0);
        ans.add(temp);
        return ans;

    }
}