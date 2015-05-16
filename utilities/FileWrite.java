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
     * @brief Write the input String to the file; close the file by default.
     */
    public void writeToFile()
    {
        this.writeToFile(true);
    }
    
    /**
     * @brief Write the input String to the file;
     *
     * @param close
     *        Close the file after write event (true), or not (false).
     */
    public void writeToFile(boolean close)
    {
        if (this.wrapText) {
            String formatedText = this.wordWrap(this.textStream, this.wrapCol);
            this.writer.print(formatedText);
        }
        else {
            this.writer.print(this.textStream);
        }
        
        if(close) {
            this.close();
        }
    }
    
    /**
     * @brief Add a String to the file.
     *
     * @note DO NOT use this method if the file has been close()ed. Will cause error!
     */
    public void writeToFile(String additionalText)
    {
        if(this.wrapText) {
            String formatedText = this.wordWrap(additionalText, this.wrapCol);
            this.writer.print(formatedText);
        }
        else {
            this.writer.print(additionalText);
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
     * @brief Wrap text to a certain width.
     */
    private String wordWrap(String input, int wrapCol)
    {
        String output = "";
        
        int i;
        for(i = 0;
            i < this.textStream.length() && this.textStream.length() - i > wrapCol;
            i += wrapCol) {
            output += input.substring( i, i + wrapCol ) + "\n";
        }
        output += input.substring( i );
        
        return output;
    }
}
