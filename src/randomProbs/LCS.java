package randomProbs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * a := array {"The", "great", "square", "has", "no", "corners"} 
 * b := array {"The", "great", "image", "has", "no", "form"} 
 * We want to find the longest subsequence possible of items that are
 * found in both a and b in the same order. 
 * The LCS of a and b is : "The", "great", "has", "no"
 */
public class LCS {

  public static void main(String[] args) {
    LCS obj = new LCS();
    String[] s = {"The", "great", "square", "has","no","corners"};
    String[] t = {"The", "great", "image","has","no","form"};
    List<String> res = obj.lcs_bactrack(s, t);
    obj.printList(res);
    System.out.println("Done!");
    
  }

  void printList(List<String> l){
    
    Iterator<String> i =l.iterator();
    while(i.hasNext()){
      System.out.print(i.next()+"  ");
    }
    System.out.println();
  }
  public List<String> lcs_bactrack(String[] s, String[] t) {

    // if we're at the end of either list, then the lcs is empty
    if (s.length == 0 || t.length == 0) {
      return new ArrayList<String>();
    }

    // if the start element is the same in both, then it is on the lcs,
    // so we just recurse on the remainder of both lists.
    if (s[0].equals(t[0])) {
      List<String> l =
          lcs_bactrack(Arrays.copyOfRange(s, 1, s.length), Arrays.copyOfRange(t, 1, t.length));
      l.add(0, s[0]);
      return l;
    }

    // we don't know which list we should discard from. Try both ways,
    // pick whichever is better.
    List<String> l1, l2;
    l1 = lcs_bactrack(Arrays.copyOfRange(s, 1, s.length), t);
    l2 = lcs_bactrack(s, Arrays.copyOfRange(t, 1, t.length));

    if (l1.size() > l2.size()) {
      return l1;
    } else
      return l2;
  }

  public List<String> lcs_DP(String[] s, String[] t){
    return new ArrayList<String>();
    
  }
}
