import java.io.FileReader;
import reporter.*;

/**
 * Test Driver class. Changes to this file will be ignored by Git. 
 * This class may be updated as the main driver from the Program class is developed. 
 */
public class TestDriver 
{
	public static void main(String[] args)
	{
		// Determine file path: either default or from args
		String filePath = "data/data.csv";
		if(args.length != 0 && args[0].length() > 0)
			filePath = args[0];
			
		// TODO: Convert file to ReportData using Converter child
		// ReportData data = (new Converter(filePath)).convertReportData();
		
		String output = "";
		// TODO: Create modules and concatenate to output
		// output += (new ReportModule(data)).generate();
		
		System.out.println(output);
	}
}
