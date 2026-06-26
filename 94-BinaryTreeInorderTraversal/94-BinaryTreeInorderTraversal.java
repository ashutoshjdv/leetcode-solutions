// Last updated: 6/26/2026, 8:55:11 AM
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> x=new ArrayList<Integer>();
        helper(root,x);
        return x;
    }
    public void helper(TreeNode root,List<Integer> x){
        if(root==null)return;
        else{
            helper(root.left,x);
            x.add(root.val);
            helper(root.right,x);
        }
    }
}