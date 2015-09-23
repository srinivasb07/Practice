package randomProbs;

public class PrimeNumbers {

  private boolean[] isPrime;

  public static void main(String[] args) {
    PrimeNumbers obj = new PrimeNumbers();
    obj.setPrimes(100);
    obj.countPrimes(100);
    System.out.println("\nCircularPrimes: ");
    for(int i=2;i<100;i++){
      if(obj.isCircularPrimes(i))
        System.out.print(i+"  ");
    }
  }

  // The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n).
  public void setPrimes(int n) {
    isPrime = new boolean[n];
    for (int i = 2; i < n; i++) {
      isPrime[i] = true;
    }
    // Loop's ending condition is i * i < n instead of i < sqrt(n) to avoid repeatedly calling an expensive function sqrt().
    for (int i = 2; i * i < n; i++) {
      if (!isPrime[i])
        continue;
      for (int j = i * i; j < n; j += i) {
        isPrime[j] = false;
      }
    }
  }

  public int countPrimes(int n) {
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime[i]){
        System.out.print(i+"  ");
        count++;
      }
    }
    return count;
  }
  
  public boolean isCircularPrimes(int n){
    if(!isPrime[n]) 
      return false;
    int initNum = n;
    int len = (int)Math.log10(n); //gives number of digits -1
    int multiplier = (int)Math.pow(10, len);
    // rotate and check that number isPrime or not
    while(true){
      int r = n%10;
      n/=10;
      
      n = n + multiplier * r;
      if(n>=isPrime.length || n == initNum){
        break;
      }
      if(!isPrime[n])
        return false;
    }
    
    
    return true;
  }

}
