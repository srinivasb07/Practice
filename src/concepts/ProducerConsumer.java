package concepts;
class Q {
  int val;
  boolean valueSet = false;
  
  public synchronized void put(int x) {
    if(valueSet){
      try {
        wait();
      } catch (InterruptedException e) {
          System.out.println("Put: Interruption caught");
      }
    }
    this.val = x;
    System.out.println("Put : " + x);
    valueSet = true;
    notify();
  }

  public synchronized int get() {
    if(!valueSet){
      try {
        wait();
      } catch (InterruptedException e) {
          System.out.println("Get: Interruption caught");
      }
    }
    System.out.println("Get : " + this.val);
    valueSet = false;
    notify();
    return this.val;
  }
}

class Producer implements Runnable {
  Q q;
  Producer(Q q){
    this.q = q;
    new Thread(this,"Producer").start();
  }
  public void run(){
    int i=0;
    while(true){
      q.put(i++);
    }
  }  
}

class Consumer implements Runnable {
  Q q;
  Consumer(Q q){
    this.q = q;
    new Thread(this,"Consumer").start();
  }
  public void run(){
    while(true){
      q.get();
    }
  }
}
public class ProducerConsumer {

  public static void main(String[] args) {
    Q q = new Q();
    new Producer(q);
    new Consumer(q);
    
    System.out.println("");
  }

}
