/**
*Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
A subtree of a node node is node plus every node that is a descendant of node.

Input: root = [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]

https://leetcode.com/problems/binary-tree-pruning/solution/
 */

package leetcode;

public class BinaryTreePruning {
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
     * = left; this.right = right; } }
     */

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (canDelete(root))
            return null;
        return root;
    }

    public boolean canDelete(TreeNode node) {
        if (node.left == null && node.right == null && node.val == 0)
            return true;
        else
            return false;
    }

}
