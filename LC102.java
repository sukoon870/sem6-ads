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
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>>ans=new ArrayList<>();
    //     Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
    //     q.offer(new Pair(root,0));
    //     while(!q.isEmpty()){
    //         Pair<TreeNode,Integer>p=q.poll();
    //         TreeNode a=p.getKey();
    //         if(a==null)continue;
    //         int level=p.getValue();
    //         if(ans.size()<level+1)ans.add(new ArrayList<>());
    //         ans.get(level).add(a.val);
    //         q.offer(new Pair(a.left,level+1));
    //         q.offer(new Pair(a.right,level+1));
    //     }
    //     return ans;
    // }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int level=q.size();
            List<Integer>l=new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode node=q.poll();
                l.add(node.val);
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            ans.add(l);
        }
        return ans;
    }
}
