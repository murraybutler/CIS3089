import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A URL domain blocker.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class DomainBlocker
{
   //DECLARE A PRIVATE SET DATA MEMBER NAMED blockedSet TO STORE THE BLOCKED DOMAINS
	private ____________________________;
	
	/**
	 * Sets up the domain blocker by reading in the blocked domain names from
	 * a file and storing them in a TreeSet.
	 * @throws FileNotFoundException
	 */
	public DomainBlocker() throws FileNotFoundException
	{
		blockedSet = new TreeSet<String>();
		
		File inputFile = new File("blockedDomains.txt");
		Scanner scan = new Scanner(inputFile);
		
		while (scan.hasNextLine())
		{
         //ADD THE DOMAIN TO THE SET USING THE nextLine FUNCTION
			blockedSet.______________________________;
		}
	}
	
	/**
	 * Checks to see if the specified domain has been blocked.
	 * 
	 * @param domain the domain to be checked
	 * @return true if the domain is blocked and false otherwise
	 */
	public boolean domainIsBlocked(String domain)
	{
      //RETURN TRUE IF THE DOMAIN IS CONTAINED IN THE SET AND FALSE IF NOT
		return _____________________________________;
	}
}