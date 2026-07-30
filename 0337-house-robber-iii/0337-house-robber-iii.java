class Solution {

    Map<String,Integer> map = new HashMap<>();

    public int fun(TreeNode root, int idx, boolean prePicked){

        if(root==null)return 0;
        int pick = 0, skip = 0;

        String str = idx+","+prePicked;
        if(map.containsKey(str))return map.get(str);

        if(!prePicked){
            pick = root.val + fun(root.left,idx*2+1,true) + fun(root.right,idx*2+2,true);
        }
        
        skip = fun(root.left,idx*2+1,false) + fun(root.right,idx*2+2,false);
        map.put(str,Math.max(pick,skip));
        return Math.max(pick, skip);
        
    }
    public int rob(TreeNode root) {
        return fun(root,0,false);
    }
}