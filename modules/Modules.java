package modules;

// for ReportData usage //
import data.*;

public class Modules
{
    protected ReportData data = null;
    protected String output = null;
    
    /** 
     * Instantiated with specified ReportData.
     */
    public Modules(ReportData data)
    {
        this.data = data;
    }
    
    /**
     * Generates a String from the modules' ReportData object. The string
     * generated is stored in the instance data 'output'. A pointer to
     * 'output' is returned.
     * @note One does not have to store the String returned by this method;
     *  it is stored in 'output' in addition to being returned.
     */
    public String generate()
    {
        return generateTitle()+"\n"+/*+nextMethods()*/;
    }
    
    /**
     * Returns the output string. If the module has not generated output,
     * it will be generated and returned.
     */
    public String getOutput()
    {
        if (output == null) {
            return generate();
        }
        return output;
    }
   
    private String generateTitle()
    {
        return "Baseball Game was a great success!";    /* should be reflective of an analysis of key data */
    }
    
    // GROUPS' METHODS NEEDED //
}




