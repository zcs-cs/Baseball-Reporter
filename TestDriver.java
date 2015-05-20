import java.io.FileReader;
import modules.*;
import converter.*;
import data.*;
import utilities.*;

/**
 * Test Driver class. Changes to this file will be ignored by Git. 
 * This class may be updated as the main driver from the BaseballReporter class is developed. 
 */
public class TestDriver
{
    public static void main(String[] args) throws Exception
    {
        // Determine file path: either default or from args
        String filePath = "data/data.json";
        if(args.length != 0 && args[0].length() > 0)
            filePath = args[0];
        System.out.println("Reading from " + filePath + "\n");
        
        // conversion //
        Converter<BaseballData> converter = new BaseballJSONConverter(filePath);
        BaseballData data = converter.convert();
        
        ReportModule[] modules = 
        {
            new TitleModule(data),
            new WeatherModule(data),
            new ExtraInningsModule(data),
            new BigInningModule(data),
            new InjuryModule(data),
            new PitchAvBModule(data),
            new BestPlayerModule(data),
            new StandingsModule(data)
        };
        
        String output = "";
        for(int i = 0; i < modules.length; i++) {
            output += modules[i].generate();
        }
        
        FilePrintWriter printer = new FilePrintWriter("dump.txt", 75);
        printer.print(output);
        //printer.print(data.toString());
        printer.close();
        
        // modules creation and output //
//         String output = "";
//         output += (new TitleModule()).generate(data);
//         output += (new BestPlayerModule()).generate();
//         System.out.println(output);
    }
}
