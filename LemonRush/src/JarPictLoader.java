import javax.swing.*;      
import java.net.URL;	
import java.io.*;			

public class JarPictLoader 
{

	private ImageIcon yonce;		
	
    public JarPictLoader() {
		ClassLoader cldr = this.getClass().getClassLoader();	
	
			
  		try {
		
			URL yonceURL   = cldr.getResource("yonce.jpg");
			yonce = new ImageIcon(yonceURL);
  		}  	
     	catch (Exception e){
			try
			{	
				
				PrintStream p = new PrintStream(new FileOutputStream(new File("trace.txt")));
				p.println("got here");	// sample output to file
				e.printStackTrace(p);	// print stack trace to output file
			}
			catch(Exception e1)	// need this empty section for PrintStream
			{
			}
    	}   					
    }
    public ImageIcon yonce()
    {						// have a 'get' method for each image
    	return yonce;
    }
}
