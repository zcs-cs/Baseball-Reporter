package reporter;

/**
 * A pluggable module that generates some text about a ReportData object
 */
public abstract class ReportModule
{
	protected ReportData data;
	protected String output;
	
	/** 
	 * Instantiates a ReportModule with specified ReportData.
	 */
	public ReportModule(ReportData data)
	{
		this.data = data;
	}
	
	/**
	 * Generates text from the supplied ReportData object and returns the text
	 */
	public String generate(ReportData data)
	{
		this.data = data;
		generate();
		return output;
	}
	
	/**
	 * Generates a String from the modules' ReportData object. The string
	 * generated is stored in the instance data 'output'. A pointer to
	 * 'output' is returned.
	 * @note One does not have to store the String returned by this method;
	 * 	it is stored in 'output' in addition to being returned.
	 */
	public abstract String generate();
	
	/** 
	 * Returns the output string. If the module has not generated output, it will be generated
	 */
	public String getOutput()
	{
		if(output == null) {
			generate();
		}
		return output;
	}
}
