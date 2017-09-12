package threadstest;

public class Second extends Testor implements Runnable {
  
  @Override
  public void run() {
    for(long j = 0; j < 50; j++){
      synchronized(lock){
        System.out.println("x");
        try {
          lock.notify();
          if (j == 49){
            break;
          }
          lock.wait();
        } catch (InterruptedException e) {
        }
      } 
    }
    System.out.println("Done Secon");
  }

}
