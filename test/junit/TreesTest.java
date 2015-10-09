package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import ds.Trees;
import ds.Trees.TreeNode;

public class TreesTest {
  Trees obj = new Trees();
  TreeNode root = obj.prepareTree();
  
  int _5thLarge = obj.findNthLargest(root, 5);
  int actual_5_large = 6;
  
  @Test
  public void testFindNthLargest(){
    System.out.println("@Test :"+ _5thLarge + " = "+actual_5_large);
    assertEquals(actual_5_large, _5thLarge);
  }
  
}
