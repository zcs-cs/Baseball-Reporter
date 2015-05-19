package utilities;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class FilePrintWriter extends PrintWriter
{
    public static final int DEFAULT_WRAP_SIZE = 50;
    
    private boolean wrapText;
    private int wrapCol = DEFAULT_WRAP_SIZE;
    private String fileName = "Unknown";

    
    public FilePrintWriter(String fileName, String charset, int wrapCol)
           throws FileNotFoundException, UnsupportedEncodingException
    {
        super(fileName, charset);
        this.wrapText = true;
        this.wrapCol = wrapCol;
        this.fileName = fileName;
    }
    public FilePrintWriter(String fileName, int wrapCol)
           throws FileNotFoundException
    {
        super(fileName);
        this.wrapText = true;
        this.wrapCol = wrapCol;
        this.fileName = fileName;
    }
    public FilePrintWriter(String fileName, String charset)
           throws FileNotFoundException, UnsupportedEncodingException
    {
        super(fileName, charset);
        this.wrapText = false;
        this.fileName = fileName;
    }
    public FilePrintWriter(String fileName)
           throws FileNotFoundException
    {
        super(fileName);
        this.wrapText = false;
        this.fileName = fileName;
    }
    
    
    public void print(String s)
    {
        if(wrapText) {
            String formattedText = this.wrapComplex(s, this.wrapCol);
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
    public void close()
    {
        super.close();
        System.out.println("\"" + this.fileName + "\" written.");
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
    
    private String wrapComplex(String input, int wrapCol)
    {
        String output = "";
        
        int counter = 0, position = 0;
        while( position < input.length() ) {
            if( counter <= wrapCol ) {
                output += input.substring( position, position+1 );
                if( input.charAt(position) == '\n' ) {
                    counter = 0;
                    position++;
                    continue;
                }
            }
            else {
                if( input.charAt(position) == ' ' ||
                    input.charAt(position) == '\n'  ) {
                    output += "\n";
                    
                    //or simply: counter = -1;
                    counter = 0;
                    position++;
                    continue;
                }
                else {
                    output += input.substring( position, position+1 );
                }
            }
            counter++;
            position++;
        }
        
        return output;
    }
}