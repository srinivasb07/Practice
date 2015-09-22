package randomProbs;


public class PascalTriangle {

  public static void main(String[] args) {
    PascalTriangle obj = new PascalTriangle();
    obj.printPascalTriangle(3);
    
  }
  
  public void printPascalTriangle(int n){
    for(int i=0;i<n;i++){
      int t=1;
      System.out.format("%"+(n-i)*2+"d", t);
      for(int j=0;j<i;j++){
        t = t*(i-j)/(j+1);
        System.out.format("%4d", t);
      }
      System.out.println("");
    }
  }

}
