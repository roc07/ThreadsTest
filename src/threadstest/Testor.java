package threadstest;

public class Testor implements Runnable{
  int x;
  static Object lock = new Object();
  
  public static int mymethod(int i) {
    return ++i;
  }

  @Override
  public void run() {
    for(long i = 0; i < 50; i++){
      synchronized(lock){
        System.out.println(i);
        try {
          lock.notify();
          if (i == 49){
            break;
          }
          lock.wait();
        } catch (InterruptedException e) {
        }
      } 
    }
    System.out.println("Done");
  }
}
