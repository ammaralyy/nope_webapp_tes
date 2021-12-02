package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonReader {

	public String firstname, lastname , email , password  ; 

	public void JsonDataReader() throws IOException, org.json.simple.parser.ParseException 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";

		File srcFile = new File(filePath); 

		JSONParser parser = new JSONParser(); 

		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile)); 

		for(Object jsonObj : jarray) 
		{
			JSONObject person = (JSONObject) jsonObj ; 
			firstname  = (String) person.get("firstName"); 
			System.out.println(firstname);

			lastname = (String) person.get("lastName"); 
			System.out.println(lastname);

			email = (String) person.get("email"); 
			System.out.println(email);

			password = (String) person.get("password"); 
			System.out.println(password);

		}

	}
}
