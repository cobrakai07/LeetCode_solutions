class Solution {
    public int fun(TreeNode r, boolean parentIsEven, boolean grandparentIsEven){
        if(r == null) return 0;
        
        int sum = 0;

        if(grandparentIsEven){
            sum += r.val;
        }

        boolean isEven = (r.val & 1) == 0;
        
        sum += fun(r.left, isEven, parentIsEven);
        sum += fun(r.right, isEven, parentIsEven);
        
        return sum;
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        return fun(root, false, false);
    }
}
