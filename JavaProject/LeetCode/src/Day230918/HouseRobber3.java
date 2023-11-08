package Day230918;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * <p>
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 * <p>
 * Example 1:
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * <p>
 * Example 2:
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * <p>
 * The number of nodes in the tree is in the range [1, 10^4].
 * 0 <= Node.val <= 10^4
 */

@SuppressWarnings("ALL")
public class HouseRobber3 {
//    static final Integer[] root = {3, 2, 3, null, 3, null, 1};
    static final Integer[] root = {3,4,null,1,3,null,null};


    public static void main(String[] args) {
        TreeNode rootTree = TreeNode.makeTree(root);
        TreeNode.printTreeNode(rootTree);
        System.out.println(rob(rootTree));
    }

    public static int rob(TreeNode root) {
        int [] score = dfs(root);
        return Math.max(score[0],score[1]);
    }

    public static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = root.val + left[1] + right[1];

        return new int[]{rob, notRob};
    }


}

class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    private TreeNode(Integer x) {
        val = x;
    }

//    public TreeNode(Integer x, TreeNode left, TreeNode right) {
//        val = x;
//        this.left = left;
//        this.right = right;
//    }

    public static TreeNode makeTree(Integer[] root) {
        if (root == null || root.length == 0) {
            return null;
        }
        TreeNode rootNode = new TreeNode(root[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        int i = 1;
        while (!queue.isEmpty() && i < root.length) {
            TreeNode node = queue.poll();
            TreeNode nodeLeft =  new TreeNode(root[i++]);
            TreeNode nodeRight = new TreeNode(root[i++]);
            queue.add(nodeLeft);
            queue.add(nodeRight);
            if(nodeLeft.val == null) nodeLeft =null;
            if(nodeRight.val == null) nodeRight =null;
            if(node != null){
                node.left = nodeLeft;
                node.right = nodeRight;
            }
        }
        return rootNode;
    }

    public static void printTreeNode(TreeNode root) {
        if (root == null) System.out.println("Tree is empty");
        System.out.println(root);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}