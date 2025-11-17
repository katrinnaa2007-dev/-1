java
import java.util.*;

class TreeNode {
    String value;
    List<TreeNode> children;
    
    public TreeNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
    
    public void addChild(TreeNode child) {
        children.add(child);
    }
}

class Tree {
    TreeNode root;
    
    public List<String> findPath(String target) {
        List<String> path = new ArrayList<>();
        if (dfsFindPath(root, target, path)) {
            return path;
        }
        return new ArrayList<>();
    }
    
    private boolean dfsFindPath(TreeNode node, String target, List<String> path) {
        if (node == null) return false;
        
        path.add(node.value);
        if (node.value.equals(target)) return true;
        
        for (TreeNode child : node.children) {
            if (dfsFindPath(child, target, path)) return true;
        }
        
        path.remove(path.size() - 1);
        return false;
    }
}
