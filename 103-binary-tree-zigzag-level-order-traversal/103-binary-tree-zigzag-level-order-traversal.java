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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.offer(root);
        boolean LeftToRight = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                
                 if(LeftToRight){
                   list.add(node.val);   
               } else {
                   //reverse and add
                   list.addFirst(node.val);
               }
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            LeftToRight = !LeftToRight;
            ans.add(list);
        }
        return ans;
    }
    
}