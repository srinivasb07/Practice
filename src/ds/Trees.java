package ds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
      System.out.println("Level Order: ");
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

}
