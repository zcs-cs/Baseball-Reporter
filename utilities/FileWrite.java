package utilities;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class FileWrite
{
    public static final int DEFAULT_WRAP_SIZE = 50;
    private PrintWriter writer;
    private String textStream;
    
    private boolean wrapText;
    private int wrapCol;
    
    public FileWrite(String textStream, String filename, String mode, int wrapCol)
    {
        try {
            this.writer = new PrintWriter(filename, mode);
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage() );
        } catch (UnsupportedEncodingException e) {
            System.err.println("UnsupportedEncodingException: " + e.getMessage() );
        }
        this.textStream = textStream;
        if(wrapCol <= 0)
            this.wrapCol = DEFAULT_WRAP_SIZE;
        else
            this.wrapCol = wrapCol;
        this.wrapText = true;
    }
    public FileWrite(String textStream, String filename, int wrapCol)
    {
        try {
            this.writer = new PrintWriter(filename, "UTF-8");
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage() );
        } catch (UnsupportedEncodingException e) {
            System.err.println("UnsupportedEncodingException: " + e.getMessage() );
        }
        this.textStream = textStream;
        if(wrapCol <= 0)
            this.wrapCol = DEFAULT_WRAP_SIZE;
        else
            this.wrapCol = wrapCol;
        this.wrapText = true;
    }
    public FileWrite(String textStream, String filename, String mode)
    {
        try {
            this.writer = new PrintWriter(filename, mode);
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage() );
        } catch (UnsupportedEncodingException e) {
            System.err.println("UnsupportedEncodingException: " + e.getMessage() );
        }
        this.textStream = textStream;
        this.wrapText = false;
        this.wrapCol = 0;
    }
    public FileWrite(String textStream, String filename)
    {
        try {
            this.writer = new PrintWriter(filename, "UTF-8");
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage() );
        } catch (UnsupportedEncodingException e) {
            System.err.println("UnsupportedEncodingException: " + e.getMessage() );
        }
        this.textStream = textStream;
        this.wrapText = false;
        this.wrapCol = 0;
    }

    
    /**
     *
     */
    public void writeToFile(boolean close)
    {
        if (wrapText) {
            String formatedText = this.wordWrap(this.textStream, this.wrapCol);
            this.writer.println(formatedText);
        }
        else {
            this.writer.println(this.textStream);
        }
        
        if(close) {
            this.close();
        }
    }
    
    /**
     * @brief Must call this method to safely close the file created!
     */
    public void close()
    {
        writer.close();
    }
    
    /**
     *
     */
    private String wordWrap(String input, int wrapCol)
    {
        String output = "";
        
        int i;
        for(i = 0;
            i < this.textStream.length() && this.textStream.length() - i > wrapCol;
            i += wrapCol) {
            output += this.textStream.substring( i, i + wrapCol ) + "\n";
        }
        output += this.textStream.substring( i );
        
        return output;
    }
}
