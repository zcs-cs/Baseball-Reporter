package modules;

import data.ReportData;

/**
 * Represents a specific generated component of a sports report.
 * Components can be titles, paragraphs, sentences, or entire reports.
 */
public abstract class ReportModule<T extends ReportData>
{
	protected T data;
	
	public ReportModule(T data)
	{
		this.data = data;
	}
	
	public ReportModule() { } 
	
	public String generate(T data)
	{
		this.data = data;
		return generate();
	}
	
	public abstract String generate();
	
	public String toString()
	{
		return generate();
	}
}