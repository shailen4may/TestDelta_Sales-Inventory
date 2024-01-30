package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils 
{
	/**
	 * @author Shailendra
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readData(String key) throws IOException
	{
	
		FileInputStream fis = new FileInputStream(IpathConstants.filepath);
		Properties pOBJ=new Properties();
		pOBJ.load(fis);
		String value = pOBJ.getProperty(key);
		return value;
	}
}
