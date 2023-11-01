/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void fun(TreeNode r,Map<Integer,Integer>map)
    {
        if(r!=null)
        {
            if(map.get(r.val)!=null)
               map.put(r.val,map.get(r.val)+1);
            else
                map.put(r.val,1);
            fun(r.left,map);
            fun(r.right,map);
        }
    }
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer>map=new HashMap<>();
        // List<Integer>list=new ArrayList<>();
        fun(root,map);
        int largestOccur=0;
        for(int key: map.keySet())
        {
            if(map.get(key)>largestOccur)
               largestOccur=map.get(key);
        }
        int size=0;
        for(int key: map.keySet())
        {
            if(map.get(key)==largestOccur)
                size++;
        }
        int ans[]=new int [size];
        int idx=0;
        for(int key: map.keySet())
        {
            if(map.get(key)==largestOccur)
            {
                ans[idx++]=key;
            }
        }
        return ans;
        

    }
}