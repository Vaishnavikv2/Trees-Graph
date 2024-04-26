package BinaryTree;
import java.util.*;
public class UniqueBST {
    private int count=0;
    private int result=-1;
    public int KthSmallest(TreeNode root,int k){
            Traversal(root,k);
        return result;
    }
    public void Traversal(TreeNode root,int k){
        if(root==null) return;
        Traversal(root.left,k);
        count++;
        if(count==k){
            result=root.data;
            return;
        }
        Traversal(root.right,k);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        TreeNode root=null;
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        for(String s:input){
            if(!s.equals("null")){
                int val=Integer.parseInt(s);
                TreeNode newNode=new TreeNode(val);
                if(root==null){
                    root=newNode;
                }
                else{
                    TreeNode parent=q.peek();
                    if(parent.left==null){
                        parent.left=newNode;
                    }
                    else{
                        parent.right=newNode;
                        q.poll();
                    }
                }
                if(val!=-1) {
                    q.offer(newNode);
                }

            }
            else{
                q.poll();
            }
        }
        int k = sc.nextInt();

        UniqueBST uniqueBST = new UniqueBST();
        int kthSmallest = uniqueBST.KthSmallest(root, k);
        System.out.println("The " + k + "th smallest element in the BST is: " + kthSmallest);
    }
}
