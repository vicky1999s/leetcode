/**
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
*/

package leetcode;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(0);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        tree.insert(5);
        tree.printPreorder(tree.root);
        Solution4 sol = new Solution4();
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode res = sol.find(tree.root, p, q);
        System.out.println("\n"+ res.val);
    }
}

class Solution4 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }
    
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if (root.val == p.val)
            return p;
        else if (root.val == q.val)
            return q;
        else if (root.val>p.val && root.val<q.val || root.val>q.val && root.val<p.val)
            return root;
        else{
            if (p.val<root.val)
                return find(root.left, p, q);
            else
                return find(root.right, p, q);
        }
   
    }
}

class TreeNode {
    TreeNode left;
    int val;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class BST {
    TreeNode root;

    public void insert(int key) {
        TreeNode node = new TreeNode(key);
        if (root == null) {
            root = node;
            return;
        }
        TreeNode prev = null;
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > key) {
                prev = temp;
                temp = temp.left;
            } else if (temp.val < key) {
                prev = temp;
                temp = temp.right;
            }
        }
        if (prev.val > key)
            prev.left = node;
        else
            prev.right = node;
    }

    void printPreorder(TreeNode node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.val + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }
}
