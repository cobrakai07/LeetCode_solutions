class Solution {
    TrieNode root = null;
    public List<String> removeSubfolders(String[] folder) {
        List<String> ret = new ArrayList<String>();
        if(folder == null)
            return ret;
        TrieNode root = new TrieNode("");
        for(String f : folder){
            add(f.split("/"), root);
        }
        for(String f: folder) {
            if(check(f.split("/"), root))
                ret.add(f);
        }
        return ret;
    }
    
    void add(String[] path, TrieNode root) {
        TrieNode node = root;
        for (int i = 0 ; i < path.length ; i ++) {
            TrieNode next = node.children.get(path[i]);
            if (next == null) {
                next = new TrieNode(path[i]);
                node.children.put(path[i], next);
            }
            node = next;
        }
        node.end = true;
    }  
    
    boolean check(String[] path, TrieNode root) {
        TrieNode node = root;
        for (int i = 0 ; i < path.length ; i ++) {
            TrieNode next = node.children.get(path[i]);
            if (next.end && i != path.length - 1) return false;
            node = next;
        }
        return true;
    }
    
    class TrieNode {
        boolean end;
        HashMap<String ,TrieNode> children = new HashMap<>();
        String val;
        public TrieNode(String val) {
            this.val = val;
        }
    }

}