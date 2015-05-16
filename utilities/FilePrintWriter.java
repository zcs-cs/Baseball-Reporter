package utilities;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class FilePrintWriter extends PrintWriter
{
    public static final int DEFAULT_WRAP_SIZE = 50;
    
    private boolean wrapText;
    private int wrapCol = DEFAULT_WRAP_SIZE;

    
    public FilePrintWriter(String fileName, String charset, int wrapCol)
           throws FileNotFoundException, UnsupportedEncodingException
    {
        super(fileName, charset);
        this.wrapText = true;
        this.wrapCol = wrapCol;
    }
    public FilePrintWriter(String fileName, int wrapCol)
           throws FileNotFoundException
    {
        super(fileName);
        this.wrapText = true;
        this.wrapCol = wrapCol;
    }
    public FilePrintWriter(String fileName, String charset)
           throws FileNotFoundException, UnsupportedEncodingException
    {
        super(fileName, charset);
        this.wrapText = false;
    }
    public FilePrintWriter(String fileName)
           throws FileNotFoundException
    {
        super(fileName);
        this.wrapText = false;
    }
    
    
    public void print(String s)
    {
        if(wrapText) {
            String formattedText = this.wrapSimple(s, this.wrapCol);
            super.print(formattedText);
        }
        else {
            super.print(s);
        }
    }
    public void println(String s)
    {
        this.print( s += "\n" );
    }
    
    private String wrapSimple(String input, int wrapCol)
    {
        String output = "";
        
        int i;
        for(i = 0;
            input.length() - i > wrapCol;
            i += wrapCol) {
            output += input.substring( i, i + wrapCol ) + "\n";
        }
        output += input.substring( i );
        
        return output;
    }
}