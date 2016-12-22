import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Demonstrates the use of a TreeMap to store a sorted group of Product
 * objects.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class ProductSales
{
	/**
	 * Processes product sales data and prints a summary sorted by
	 * product code.
	 */
	public static void main(String[] args) throws IOException
	{
      //CREATE NEW TREEMAP NAMED sales TO STORE THE PRODUCT CODE (STRING) AND THE PRODUCT ITSELF (PRODUCT)
		______________________ sales = new ______________________;
		
		Scanner scan = new Scanner(new File("salesData.txt"));
		
		String code;
		Product product;
		while (scan.hasNext())
		{
			code = scan.nextLine();
			product = sales.________________;  // SEARCH FOR THE PRODUCT IN THE MAP
			if (product == null)
				_____________________________;  // IF NOT FOUND (NULL), ADD IT TO THE MAP
			else
				_____________________________;  // IF FOUND, INCREMENT THE SALES 
		}
		
		System.out.println("Products sold this period:");
		for (Product prod : sales.values())
			System.out.println(prod);
	}
}