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
    List<Integer>list;
    public void fun(Node r)
    {
        if(r!=null)
        {
            
            for(Node n: r.children)
                fun(n);
            if(r.val!=-1)list.add(r.val);
            r.val=-1;
        }
    }
    public List<Integer> postorder(Node root) {
        list=new ArrayList<>();
        fun(root);
        return list;
    }
}