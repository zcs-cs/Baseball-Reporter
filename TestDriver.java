import java.io.FileReader;
import reporter.*;

/**
 * Test Driver class.
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
