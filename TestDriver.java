import java.io.FileReader;
import reporter.*;

/**
 * Test Driver class. Changes to this file will be ignored by Git. 
 * This class may be updated as the main driver from the BaseballReporter class is developed. 
 */
public class TestDriver
{
	public static void main(String[] args)
	{
		// Determine file path: either default or from args
        String filePath = "data/data.json";
        if(args.length != 0 && args[0].length() > 0)
            filePath = args[0];
        System.out.println("Reading from " + filePath + "\n");
        
        // conversion //
        Converter<BaseballData> converter = new BaseballJSONConverter(filePath);
        BaseballData data = converter.convert();
        
        
        // modules creation and output //
        String output = "";
        output += (new TitleModule()).generate(data);
        
        System.out.println(output);
	}
}
