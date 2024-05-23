/*******************************************************************************

    To check details of Java config in system the interesting part is that we can also 
run this over online compliers

*******************************************************************************/

public class JavaConfig
{
	public static void main(String[] args) {
		System.out.println( System.getProperty("os.arch") );
		System.out.println("Java Version is: "+System.getProperty("java.version"));  
	}
}
