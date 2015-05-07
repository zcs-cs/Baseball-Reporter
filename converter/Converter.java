package converter;

//exceptions
import java.io.FileNotFoundException;
//standard io libraries
import java.io.FileReader;
import java.io.BufferedReader;

//our libraries
import reporter.ReportData;

/**
 * Abstract class representing an object that reads a file and
 * converts the data within the file to a ReportData object.
 */
public abstract class Converter
{
	//see: http://www.homeandlearn.co.uk/java/read_a_textfile_in_java.html
	protected BufferedReader reader = null;
	protected ReportData data = null;
	
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
	}

	/** 
	 * Converts the data contained in the reader to a ReportData
	 * object representation of file read by the BufferedReader.
	 * Stashes the convered data in the variable 'data' while 
	 * returning a pointer to it.
	 * @return A pointer to the object created.
	 */
	public abstract ReportData convertData();
	
	/**
	 * Returns the current ReportData representation of the converted data.
	 */
	public ReportData getData()
	{
		if(data == null) {
			return convertData();
		}
		return data;
	}
	
	/**
	 * Create a string containing information regarding the state of the
	 * instance data (if pointers are null)
	 * Textual representation of the reader (file path to loaded file?)
	 * Call toString of ReportData.
	 */
	public abstract String toString();
}
