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
		return output = generate();
	}
	
	/**
	 * Generates text from the modules' ReportData object and returns the text
	 */
	public abstract String generate();
	
	/** 
	 * Returns the output string. If the module has not generated output, it will be generated
	 */
	public String getOutput()
	{
		if(output == null)
			output = generate();
		return output;
	}
}