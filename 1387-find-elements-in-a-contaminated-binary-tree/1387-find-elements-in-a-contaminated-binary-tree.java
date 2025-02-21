
class FindElements {

    TreeNode r=null;
    Set<Integer>set=new HashSet<>();
    public void fun(TreeNode r)
    {
        if(r==null)return;
        if(r.left!=null)r.left.val=2*r.val+1;
        if(r.right!=null)r.right.val=2*r.val+2;
        fun(r.left);
        fun(r.right);
    }
    public void pre(TreeNode r)
    {
        if(r!=null)
        {
            // System.out.print(r.val+" ,");
            set.add(r.val);
            pre(r.left);pre(r.right);
        }
    }
    public FindElements(TreeNode root) {
        r=root;
        r.val=0;
        fun(r);
        pre(r);
    }
    
    public boolean find(int target) {
        if(!set.contains(target))return false;
        return true;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */