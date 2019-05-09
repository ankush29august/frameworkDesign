package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
 
Properties pro;
	
	public ReadConfig() {
		File src=new File("./Configuration\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		return pro.getProperty("baseUrl");
	}
	
	public String getUserName() {
		return pro.getProperty("username");
	}
	
	public String getUserPassword() {
		return pro.getProperty("password");
			}
	
	
	public String getChromePath() {
		return pro.getProperty("chromepath");
			}
	
	public String getDropNo() {
		return pro.getProperty("dropNo");
	}
	
	public String getVName() {
		return pro.getProperty("vName");
	}
	
	public String getManagerName() {
		return pro.getProperty("mgName");
	}
	
	public String getNoOfPosition() {
		return pro.getProperty("noOfPosition");
	}
	
	
	public String getDesc() {
		return pro.getProperty("desc");
	}
	
	public String getJobVal() {
		return pro.getProperty("jobVal");
		
	}
	
	public String getIndic() {
		return pro.getProperty("indic");
	}
	
     public String getMin() {
    	 return pro.getProperty("min");
    	 	}

     public String getMax() {
	return pro.getProperty("max");
      }
   //Tracker Page
 	public String getTrackerName() {
 		return pro.getProperty("tName");
 	}
 	
 	public String getEmpVal() {
 		return pro.getProperty("empVal");
 	}
	
	

}
