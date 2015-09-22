package ds;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Algos {

  public class ListNode {
    int val;
    ListNode next;
    ListNode nextHigh;

    ListNode(int x) {
      val = x;
      next = null;
      nextHigh = null;
    }
  }

  public static void main(String[] args) {
    Algos obj = new Algos();
    // System.out.println(obj.isPalindrome(1432095867));
    System.out.println(obj.addBinary("11", "10"));
    obj.andTest();
    obj.finalTest();

    ListNode head = obj.new ListNode(8);
    head.next = obj.new ListNode(2);
    head.next.next = obj.new ListNode(6);

    System.out.println(obj.convertToTitle(754));
    System.out.println(obj.titleToNumber("ABZ"));
    System.out.println(obj.trailingZeroes(4));

    obj.sortList(head);

    List<String> ls = new LinkedList<String>();

    LinkedList<Integer> l = new LinkedList<Integer>();
    ArrayList<Integer> al = new ArrayList<Integer>();
    al.size();

  }
  
  public String addBinary(String a, String b) {
    String result = "";
    int c=0, i = a.length()-1, j = b.length()-1;
    while(i>=0 && j>=0){
        int sum = c;
        sum += (a.charAt(i)-'0') + (b.charAt(j)-'0');
        c = sum>>1;
        sum&=1;
        result = sum + result;
        i--;j--;
    }
    while(i>=0){
      int sum = c;
      sum += (a.charAt(i)-'0');
      c = sum>>1;
      sum&=1;
      result = sum + result;
      i--;
    }
    while(j>=0){
      int sum = c;
      sum += (b.charAt(j)-'0');
      c = sum>>1;
      sum&=1;
      result = sum + result;
      j--;
    }
    if(c>0) result = "1"+result;
    return result;
  }

  public boolean isPalindrome(int s) {
    int len = 1, copy = s;
    /* no.of digits */
    while (copy / 10 != 0) {
      len++;
      copy /= 10;
    }
    for (int i = 0, j = len - 1; i <= j; i++, j--) {
      int a = (int) ((s / Math.pow(10, i)) % 10);
      int b = (int) ((s / Math.pow(10, j)) % 10);
      if (a != b)
        return false;
    }
    return true;
  }

  public boolean isPalindrome(ListNode head) {
    int len = 0;
    ListNode temp = head, second = head, rev = null;
    while (temp != null) {
      len++;
      temp = temp.next;
    }
    temp = head;
    for (int i = 0; i < len / 2; i++) {
      second = temp.next;
      temp.next = rev;
      rev = temp;
      temp = second;
    }
    if (len % 2 != 0) {
      second = second.next;
    }
    while (rev != null && second != null) {
      if (rev.val != second.val) {
        return false;
      }
      rev = rev.next;
      second = second.next;
    }
    return true;
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null, temp = head, rev = head;
    while (temp != null) {
      rev = temp.next;
      temp.next = prev;
      prev = temp;
      temp = rev;
    }
    return prev;
  }

  public ListNode reverseList(ListNode head, ListNode prev) {
    if (head == null) {
      return prev;
    }
    ListNode temp = head.next;
    head.next = prev;
    return reverseList(temp, head);
  }

  public ListNode removeElements(ListNode head, int val) {
    ListNode prev = null;
    for (ListNode tr = head; tr != null; tr = tr.next) {
      if (tr.val == val) {
        if (prev == null) {
          head = tr.next;
        } else {
          prev.next = tr.next;
        }
      } else
        prev = tr;
    }
    return head;
  }

  public boolean isAnagram(String s, String t) {
    int[] alpha = new int[26];
    int i;

    for (i = 0; i < s.length(); i++) {
      alpha[s.charAt(i) - 'a']++;
    }

    for (i = 0; i < t.length(); i++) {
      alpha[t.charAt(i) - 'a']--;
    }

    for (i = 0; i < 26; i++) {
      if (alpha[i] != 0)
        return false;
    }
    return true;
  }

  public boolean containsDuplicate(int[] nums) {
    HashSet hs = new HashSet();
    // for(int i;i<nums.length;i++)
    for (int i : nums) {
      if (!hs.add(i))
        return true;
    }
    return false;
  }

  public int reverse(int x) {
    boolean negative = (x < 0);

    int n = 0, r;

    while (x != 0) {
      r = Math.abs(x % 10);
      if (n > (Integer.MAX_VALUE - r) / 10)
        return 0;
      n = n * 10 + r;
      x /= 10;
    }
    if (negative) {
      n *= -1;
    }
    return n;
  }

  public boolean isPowerOfTwo(int n) {
    if (n <= 0)
      return false;
    return (((n & n - 1) == 0) ? true : false);
  }

  public int hammingWeight(int n) {
    int count = 1;

    if (n == 0)
      return 0;
    while (n != 1) {
      count += (n % 2);
      n /= 2;
    }
    return count;
  }

  public List<String> anagrams(String strs) {
    List list = new LinkedList<String>();
    permutation(list, "", strs);
    return list;
  }

  public void permutation(List<String> list, String prefix, String str) {
    int n = str.length();
    if (n == 0)
      list.add(prefix);
    else {
      for (int i = 0; i < n; i++)
        permutation(list, prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
    }
  }

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (m.containsKey(nums[i])) {
        if (i - m.get(nums[i]) <= k) {
          return true;
        }
      }
      m.put(nums[i], i);
    }
    return false;
  }

  public int findMin(int[] nums) {
    int i = 0, j = nums.length - 1, mid;
    while (i < j && nums[i] >= nums[j]) {
      mid = (i + j) / 2;
      if (nums[mid] < nums[j]) {
        j = mid;
      } else {
        i = mid + 1;
      }
    }
    return nums[i];
  }

  public String convertToTitle(int n) {

    String alpha = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
    String res = "";
    while (n > 0) {
      int i = n % 26;
      res = alpha.charAt(i) + res;
      n = (i == 0) ? (n / 26) - 1 : n / 26;
    }
    return res;
  }

  public int titleToNumber(String s) {
    int n = s.length(), res = 0;
    int i = n - 1;
    while (i >= 0) {
      int c = s.charAt(i) - 'A' + 1;
      res += c * Math.pow(26, n - 1 - i);
      i--;
    }
    return res;
  }

  public int trailingZeroes(int n) {
    int count = 0, i = 1;
    int c = n / (int) Math.pow(5, i);
    while (c > 1) {
      count += c;
      i++;
      int p = (int) Math.pow(5, i);
      c = n / p;
    }
    count += c;
    return count;
  }

  public void sortList(ListNode head) {
    ListNode min = head, temp = head.next;
    while (temp != null) {
      ListNode j, prev = null;
      for (j = min; j != null; j = j.nextHigh) {
        if (j.val > temp.val) {
          break;
        }
        prev = j;
      }
      if (prev == null) {
        temp.nextHigh = min;
        min = temp;
      } else {
        prev.nextHigh = temp;
        temp.nextHigh = j;
        temp = temp.next;
      }
    }
    System.out.println("Actual List: ");
    dispList(head);

  }

  public void dispList(ListNode head) {
    for (ListNode p = head; p != null; p = p.next) {
      System.out.print(" " + p.val);
    }
  }

  public void andTest() {
    ListNode t = null;
    System.out.println(t != null && t.next != null);
    // System.out.println(t!=null&t.next!=null); --run time error
    System.out.println("Done!");
  }

  public void finalTest() {
    final int a = 10;
    // a=11; --Compilation error
    final int n = new Integer(10);
    // n=11; --Compilation error
    // n = new Integer(11);

    Integer s = new Integer(10);
    final Integer t = s;
    s = 11; // s will be 11 but t will still be 10;
    System.out.println("S: " + s);
    System.out.println("t: " + t);

  }

  public boolean isValid(String s) {
    LinkedList<Character> l = new LinkedList<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      try {
        switch (c) {
          case ')':
            if (l.pop() != '(') {
              return false;
            }
            break;
          case '}':
            if (l.pop() != '{') {
              return false;
            }
            break;
          case ']':
            if (l.pop() != '[') {
              return false;
            }
            break;
          default:
            l.push(c);
        }
      } catch (NoSuchElementException e) {
        return false;
      }
    }
    if (l.isEmpty()) {
      return true;
    }

    return false;
  }

}
