package Java;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class LevelOrderTraversal {
    public List<List<Integer>> levelorder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                level.add(current.data);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            TreeNode newNode = new TreeNode(val);
            if (root == null) {
                root = newNode;
            } else {
                TreeNode parent = queue.peek();
                if (parent.left == null) {
                    parent.left = newNode;
                } else {
                    parent.right = newNode;
                    queue.poll();
                }
            }
            queue.offer(newNode);

        }
        LevelOrderTraversal lm = new LevelOrderTraversal();
        List<List<Integer>> result = lm.levelorder(root);
        for (List<Integer> level : result) {
            System.out.print(level);
        }
        sc.close();
    }

}
