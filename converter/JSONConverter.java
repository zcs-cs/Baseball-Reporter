package converter;

import org.json.*;
import java.io.FileNotFoundException;


/**
 * Write a description of class JSONConverter here.
 * 
 * @author Daniel Wesenberg
 * @version v1.0
 */
public class JSONConverter extends Converter
{
    public JSONConverter(String filePath) throws FileNotFoundException
    {
        super(filePath);
        convertData();
    }
    public JSONObject convertData() {
        String jsonInput = "";
        String lastLine;
        try{
            while ( ( lastLine = reader.readLine() ) != null){
                jsonInput += lastLine;
            }
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
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
