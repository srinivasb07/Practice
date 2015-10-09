package test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestPurpose {

  public static void main(String[] args) {
      ArrayList<Integer> l = new ArrayList<Integer>();
      l.add(1);l.add(2);
      disp(l);
  }


  public static void disp(ArrayList<? extends Number> l) {
    for (Number n : l) {
      System.out.print(n + "  ");
    }
  }

  public void regExTest() {
    String label = "\\\\CAMOES01\\print$";
    try {
      // Create a regular expression to match a seqence of characters which should be part of a
      // single line
      // and after which text should be wrapped.
      Pattern pattern = Pattern.compile("(.{1,20})( +|$\n?)|(.{1,20})");
      // Pattern pattern = Pattern.compile ("(.{1," + nodeLabelWrapLength + "})( +|$\n?)|(.{1," +
      // nodeLabelWrapLength + "})");
      Matcher matcher = pattern.matcher(label.replace("\\", "\\\\").replace("$", "\\$"));

      // Stores the temporary string data during replacement
      StringBuffer sb = new StringBuffer();

      // Append HTML BR tag after each sequence of characters returned by the matcher
      while (matcher.find()) {
        // Do not add HTML BR tag if the matched sequence will form the last line of node label text
        if (!matcher.hitEnd())
          matcher.appendReplacement(sb, matcher.group() + "<br/>");
        else
          matcher.appendReplacement(sb, matcher.group(1));
      }
      label = sb.toString();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw e;
    }
    System.out.println(label);
  }


}
