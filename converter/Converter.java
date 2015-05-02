package converter;

import java.io.Reader;

/**
 * Abstract class representing an object that converts some data from a Reader into a T object
 */
public abstract class Converter<T> 
{
	protected Reader reader = null;
	protected T data = null;
	
	public Converter() { }
	/**
	 * Creates a converter and loads the specified reader
	 */
	public Converter(Reader reader)
	{
		this.reader = reader;
	}
	
	/**
	 * Creates a converter and loads the specified file
	 * @param fileName
	 *		String path to the file
	 * @throws java.io.FileNotFoundException
	 */
	public Converter(String fileName) throws java.io.FileNotFoundException
	{
		this(new java.io.FileReader(fileName));
	}

	/** 
	 * Converts the data contained in the reader to a POJO representation of the Reader
	 */
	public abstract T convertData();
	
	/**
	 * Returns the current POJO representation
	 */
	public T getData()
	{
		return data;
	}
}