package ds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Trees {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {

    Trees obj = new Trees();
    TreeNode root = obj.prepareTree();
    
    obj.inOrder(root);
    obj.preOrder(root);
    
    System.out.println("\n5th Largest: "+obj.findNthLargest(root, 5));
    
    List<List<Integer>> ll = obj.levelOrder(root);

    List<String> l = obj.binaryTreePaths(root);

    Iterator<String> i = l.iterator();
    System.out.println("Binary Tree Paths: ");
    while (i.hasNext()) {
      System.out.println(i.next());
    }
  }

  public TreeNode prepareTree() {
    TreeNode root = new TreeNode(8);

    root.left = new TreeNode(6);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);

    root.right = new TreeNode(11);
    root.right.left = new TreeNode(9);

    return root;
  }

  /*
   * Given a binary tree, return all root-to-leaf paths.
   * 
   * For example, given the following binary tree:
   * 
   * 1 / \ 2 3 \ 5 All root-to-leaf paths are:
   * 
   * ["1->2->5", "1->3"]
   */
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> l = new LinkedList<String>();
    setPaths(l, root, "");
    return l;
  }

  public void setPaths(List<String> ls, TreeNode root, String path) {
    if (root == null) {
      return;
    } 
    path = path.equalsIgnoreCase("") ? root.val + "" : path + "->" + root.val;
    if (root.left == null && root.right == null) {
      ls.add(path);
      return;
    }
    setPaths(ls, root.left, path);
    setPaths(ls, root.right, path);
  }
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<TreeNode> queue;
      LinkedList<List<Integer>> ll = new LinkedList<List<Integer>>();
      queue = new ArrayList<TreeNode>();
      System.out.println("\nLevel Order: ");
      if(root != null){
          queue.add(root);
      }
      while(queue.size()>0){
          List<Integer> l = new LinkedList<Integer>();
          for(int i=0;i<queue.size();i++){
            l.add((queue.get(i)).val);
            System.out.print((queue.get(i)).val+" ");
          }
          ll.add(l);
          //ll.push(l); // To get level order from bottom to top
          System.out.println();
          ArrayList<TreeNode> newQLevel = new ArrayList<TreeNode>();
          for(int i=0;i<queue.size();i++){
            TreeNode temp = queue.get(i);
            if(temp.left!=null)
              newQLevel.add(temp.left);
            if(temp.right!=null)
              newQLevel.add(temp.right);
          }
          queue = newQLevel;
      }
      return ll;
  }
  
  public void preOrder(TreeNode root){
    if(root==null)
      return;
    System.out.println("\nPre Order:  ");
    Stack<TreeNode> st = new Stack<Trees.TreeNode>();
    st.push(root);
    TreeNode temp;
    while(!st.empty()){
      temp = st.pop();
      while(temp!=null){
        System.out.format("%4d", temp.val);
        if(temp.right!=null)
          st.push(temp.right);
        temp = temp.left;
      }
    }
  }
  
  public void inOrder(TreeNode root){
    if(root==null)
      return;
    System.out.println("\nIn Order: ");
    Stack<TreeNode> s = new Stack<Trees.TreeNode>();
    TreeNode t = root;
    boolean done = false;
    while(!done){
      while(t!=null){
        s.push(t);
        t = t.left;
      }
      if(!s.empty()){
        t = s.pop();
        System.out.format("%4d", t.val);
        t = t.right;
      }else
        done = true;
    }
  }

  /*
   * To find the nth largest in a BST, idea is to traverse tree in reverse in order and stop after n elements;
   */
  public int findNthLargest(TreeNode root, int n){
    if(root==null)
      return -1;
    
    Stack<TreeNode> s = new Stack<Trees.TreeNode>();
    TreeNode t = root;
    boolean done = false;
    while(!done){
      while(t!=null){
        s.push(t);
        t= t.right;
      }
      if(!s.empty()){
        n--;
        t = s.pop();
        if(n==0) return t.val;
        t = t.left;
      }else{
        done = true;
      }
    }
    
    return -1;
  }
}
