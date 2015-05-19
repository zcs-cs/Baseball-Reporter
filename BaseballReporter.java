import java.util.ArrayList;

import org.json.*;
import converter.*;
import data.*;
import modules.*;

/*
 * ATTENTION: DO NOT EDIT THIS FILE UNLESS YOU ARE A PROGRAM DEV LEADER
 *            Please Edit the TestDriver class for your own personal use.
 * If everyone edits this file, many conflicts will need to be resolved.
 * Rewrite or copy this class to a new TestDriver class (TestDriver.java) and do not commit those changes
 */
public class BaseballReporter 
{
    public static void main(String[] args) throws Exception
    {
        // Determine file path: either default or from args
        String filePath = "data/data.json";
        if(args.length != 0 && args[0].length() > 0)
            filePath = args[0];
        System.out.println("The following article is being generated from: " + filePath + "\n");
        
        // conversion //
        Converter<BaseballData> converter = new BaseballJSONConverter(filePath);
        BaseballData data = converter.convert();
        
        // modules creation and output //
        ArrayList<ReportModule<BaseballData>> modules = new ArrayList<ReportModule<BaseballData>>();
        // examples (currently disabled):
        // modules.add(new ExamplesModule());
        modules.add(new TitleModule());
        modules.add(new WeatherModule());
        modules.add(new BestPlayerModule());
        modules.add(new BigInningModule());
        modules.add(new ExtraInningsModule());
        modules.add(new InjuryModule());
        modules.add(new PitchAvBModule());
        
        String output = "";
        for (ReportModule<BaseballData> module : modules)
        {
            output += module.generate(data)+"\n\n";
        }
        System.out.print(output);
    }
}
