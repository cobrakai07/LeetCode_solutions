
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> hasParent = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;

            hasParent.add(child);

            if (map.get(parent) != null) {
                // System.out.println("got par" + parent + ", " + child);
                TreeNode temp = map.get(parent);
                TreeNode childNode = null;
                if (map.get(child) != null) {
                    childNode = map.get(child);
                } else {
                    childNode = new TreeNode(child);
                    map.put(child, childNode);
                }

                if (isLeft)
                    temp.left = childNode;
                else
                    temp.right = childNode;

            } else {
                TreeNode temp = new TreeNode(parent);
                TreeNode childNode = null;
                if (map.get(child) != null) {
                    childNode = map.get(child);
                } else {
                    childNode = new TreeNode(child);
                    map.put(child, childNode);
                }

                if (isLeft)
                    temp.left = childNode;
                else
                    temp.right = childNode;
                map.put(parent,temp);
            }

        }

        for (int[] desc : descriptions) {
            int parent = desc[0];
            if (!hasParent.contains(parent))
                return map.get(parent);
        }

        return null;

    }
}