package resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pojopackage.Googleaddplacepaipost;
import pojopackage.location;

public class Testdatabuild {

	public Googleaddplacepaipost addplacepayload (String language,String name,String phonenumber ) {
		
		Googleaddplacepaipost addplaceobj = new Googleaddplacepaipost();
		
		addplaceobj.setAccuracy(50);
		addplaceobj.setAddress("29, side layout, cohen 09");
		addplaceobj.setLanguage(language);
		addplaceobj.setName(name);
		addplaceobj.setPhone_number(phonenumber);
		addplaceobj.setWebsite("http://google.com");
		
		List<String> typeslistobj = new ArrayList<String>();
		
		typeslistobj.add("shoe park");
		typeslistobj.add(getRandomString(15));
		
		addplaceobj.setTypes(typeslistobj);
		
		
		location locationobj = new location();
		locationobj.setLat(-38.383494);
		locationobj.setLng(33.427362);
		addplaceobj.setLocation(locationobj);
		
		return addplaceobj;
		
	}
	
	
    public  String getRandomString(int length){
    	
    	String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
        Random random = new Random();   
        
        StringBuffer sb = new StringBuffer(); 
        
        for (int i = 0; i < length; i++) {   
        	
            int number = random.nextInt(base.length());   
            sb.append(base.charAt(number));   
           System.out.println(sb);
            
            
        } 
        
        System.out.println(sb);
        return sb.toString();   
        
       
    }
	
	
	
	public String deleteplacepayload(String placeidvalue)
	{
		return ("{\r\n" + 
				"    \"place_id\":\""+placeidvalue+"\"   	 \r\n" + 
				"}\r\n" + 
				"");
	}
	
}
