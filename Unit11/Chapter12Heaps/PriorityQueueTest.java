/**
 * Write a description of class PriorityQueueTest here.
 * 
 * @author Jen Rosato 
 * @version 1.0
 */
public class PriorityQueueTest
{
    public static void main(String args[])
    {       
        final int SENIOR = 1;
        final int JUNIOR = 2;
        final int SOPHOMORE = 3;
        final int FRESHMAN = 4;
        
        PriorityQueue<String> q = new PriorityQueue<String>();
        q.addElement("Harper", SOPHOMORE);
        System.out.println(q.removeNext());
    }
}
