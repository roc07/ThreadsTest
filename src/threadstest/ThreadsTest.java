package threadstest;

import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

public class ThreadsTest {

  public static class Person{
    public int age;
    public String name;

    public Person(int age, String name) {
      this.age = age;
      this.name = name;
    }       
  }
  
  public static void main(String[] args) throws InterruptedException {
    Person fir = new Person(20, "Gosho");
    Person sec = new Person(20, "Ivan");
    Person tri = new Person(22, "Gosho");
    HashSet<Person> text = new HashSet<>();
    text.add(fir);
    text.add(sec);
    text.add(tri);
    text.add(tri);
    
    HashMap<String, Integer> tesT = new HashMap();
    
    tesT.put(fir.name, fir.age);
    tesT.put(sec.name, sec.age); 
    tesT.put(tri.name, tri.age);
    
    System.out.println("HashSet:");
    for (Person p : text){
      System.out.println(p.age + " " + p.name);
    }
    
    System.out.println("HashMap:");
    for (Map.Entry<String, Integer> entry : tesT.entrySet()){
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
    
    HashMap<String, ArrayList<String>> phones = new HashMap<>();
    ArrayList<String> x = new ArrayList<>();
    x.add("10");
    x.add("20");
    
    phones.put("Subject One: ", x);
    
    //SAME
    System.out.println("HashMap:");
    phones.entrySet().forEach((entry) -> {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    });    
    
    Testor tredOne = new Testor();
    Second tredTwo = new Second();
    
    double timeCheck = System.currentTimeMillis();
    
//    tred.run();
//    (new Thread(new Testor())).start();
    Thread one = new Thread(tredOne);
    Thread two = new Thread(tredTwo);
    one.start();
    two.start();
    one.join();
    two.join();
    
    //System.out.println("Finished: " + (timeCheck - System.currentTimeMillis()));
    
  }
  
}
