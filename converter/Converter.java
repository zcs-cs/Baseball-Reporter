package converter;

//exceptions
import java.io.FileNotFoundException;
//standard io libraries
import java.io.FileReader;
import java.io.BufferedReader;

//our libraries
import data.ReportData;

/**
 * Abstract class representing an object that reads a file and
 * converts the data within the file to a ReportData object.
 */
public abstract class Converter<T extends ReportData>
{
	//see: http://www.homeandlearn.co.uk/java/read_a_textfile_in_java.html
	protected BufferedReader reader = null;
	protected String filePath;
	
	public Converter() 
	{
		//An empty constructor; used to create a Converter object, itself.
	}

	/**
	 * Creates a converter and loads the specified reader
	 * @param reader
	 *		BufferedReader for this object to use.
	 */
	public Converter(BufferedReader reader)
	{
		this.reader = reader;
	}
	
	/**
	 * Creates a converter and loads the specified file
	 * @param fileName
	 *		String path to the file to be loaded.
	 * @throws FileNotFoundException
	 *		Throws this if the file doesn't exist.
	 */
	public Converter(String fileName) throws FileNotFoundException
	{
		this( new BufferedReader( new FileReader(fileName) ) );
	    this.filePath = fileName;
	}
	
	/**
	 * Converts the reader into a ReportData-like object
	 * @param reader
	 *		A BufferedReader to parse.
	 * @throws Exception
	 *		May throw an exception if something goes wrong during parse (Implementation specific).
	 * @note
	 *		The reader specified in the paramter becomes the converter's new reader.
	 *		Any future calls to convert() will utilize this reader.
	 */
	public T convert(BufferedReader reader) throws Exception
	{
		this.reader = reader;
		return convert();
	}
	
	/**
	 * Converts the file into a ReportData-like object
	 * @param fileName
	 *		A valid URI path
	 * @throws Exception
	 *		May throw an exception if something goes wrong during parse (Implementation specific).
	 * @note
	 *		The file specified in the paramter becomes the converter's new data store.
	 *		Any future calls to convert() will utilize this file.
	 */
	public T convert(String fileName) throws FileNotFoundException, Exception
	{
		this.reader = new BufferedReader(new FileReader(fileName));
		return convert();
	}
	
	/**
	 * Converts the data store into a ReportData-like object
	 */
	public abstract T convert() throws Exception;
	
	/**
	 * Create a string containing information regarding the state of the
	 * instance data (if pointers are null)
	 * Textual representation of the reader (file path to loaded file?)
	 * Call toString of ReportData.
	 */
	public abstract String toString();
}
