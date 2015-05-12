package converter;

import org.json.*;
import java.io.FileNotFoundException;

import data.BaseballData;

/**
 * Write a description of class JSONConverter here.
 * 
 * @author Daniel Wesenberg
 * @version v1.0
 */
public class BaseballJSONConverter extends Converter<BaseballData>
{
    private JSONObject data;
    
    public BaseballJSONConverter(String filePath) throws FileNotFoundException
    {
        super(filePath);
    }
    
    public BaseballData convert() throws Exception
    {
        return new BaseballData(convertData());
    }
    
    public JSONObject convertData() throws Exception {
        String jsonInput = "";
        String lastLine;
        while ( ( lastLine = reader.readLine() ) != null){
            jsonInput += lastLine;
        }
        reader.close();
        data = new JSONObject(jsonInput);
        return data;
    }
    
    public String toString(){
        String out = "";
        out += filePath + "\n Contains: ";
        out += (data.toString().substring(0,50)) + ". . .";
        return out;
    }
}
