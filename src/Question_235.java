/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/13
 *  235. 二叉搜索树的最近公共祖先
 */


public class Question_235 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q){     //如果根节点为空或者等于 p，或者等于q，则直接返回根节点
                return root;
            }
            //p q为父子关系---- 则可直接判定最近公共祖先是p或者q ----->是一种特例
            //p q非父子关系---- 首先找到其中一个节点p，然后回溯上一个节点继续dfs查找q，如果没找到继续回溯直到找到为止！
            //出口条件：如果查找到q则返回，没查找到返回null
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right,p,q);
            }else if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left,p,q);
            }else{
                return root;
            }
        }
    }

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

}
