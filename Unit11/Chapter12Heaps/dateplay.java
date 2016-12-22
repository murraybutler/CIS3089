import java.util.*;
import java.text.*;

public class dateplay
{

  public static void main(String args[]) 
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Birthday DAY (1-31): ");
    int day = scanner.nextInt();
    System.out.println("Enter Birthday MONTH (1-12): ");
    int month = scanner.nextInt();

    month = month - 1;
    Calendar cal = Calendar.getInstance();
    Date now = cal.getTime();
    int yr = 0;
    if (cal.get(Calendar.MONTH) > (month - 1)) {
      yr = cal.get(Calendar.YEAR) + 1;
      cal.set(cal.get(Calendar.YEAR) + 1, month, day);
    } else {
      yr = cal.get(Calendar.YEAR);
      cal.set(cal.get(Calendar.YEAR), month, day);
    }
    Date bday = cal.getTime();

    System.out.println(bday);
    System.out.println(now);

    long diff = now.getTime() - bday.getTime();
    long time = 1000 * 60 * 60 * 24;

    long count = diff/time;

    ArrayHeap<Integer> cntdn = new ArrayHeap<Integer>();

    int cnt = Math.abs((int)count);
    for (int i = 0; i < cnt; i++) {
      cntdn.addElement(i);
    }
    
    // Countdown to the big day
    //
    Calendar cntd = Calendar.getInstance(); 
    while (!cntdn.isEmpty()) {
      int closer = cntdn.removeMin();
      Calendar caltmp = (Calendar)cntd.clone();
      caltmp.add(Calendar.DAY_OF_YEAR, closer);
      System.out.println("Today is: " + caltmp.getTime() + "\n" + closer + " days since you asked me to track this!!");
    }

  }
}
  
