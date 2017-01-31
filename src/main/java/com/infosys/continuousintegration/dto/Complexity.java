package com.infosys.continuousintegration.dto;
/*package com.symantec.continuousintegration.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.lang.Object;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class Complexity {
	
	static String jsonText;
	
	public static void main(String[] args) throws ParserConfigurationException, MalformedURLException, SAXException, IOException  {
			
		InputStream is = new URL("http://10.211.64.231:9000/api/resources?metrics=function_complexity&format=json").openStream();
		 try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      jsonText = readAll(rd);
		      System.out.println(jsonText);
		
	  }finally {
	      is.close();
	    }
		 
		 Gson gson = new Gson();        
		 Book bk = gson.fromJson(jsonText,Book.class);


		 for (Msr item : bk.items)
		 System.out.println("    " + item.title);
		 		 
		 		 static class Msr{
		 			   	private String frmt_val;
		 			   	private String key;
		 			   	private Number val;

		 			 	public String getFrmt_val(){
		 					return this.frmt_val;
		 				}
		 				public void setFrmt_val(String frmt_val){
		 					this.frmt_val = frmt_val;
		 				}
		 			 	public String getKey(){
		 					return this.key;
		 				}
		 				public void setKey(String key){
		 					this.key = key;
		 				}
		 			 	public Number getVal(){
		 					return this.val;
		 				}
		 				public void setVal(Number val){
		 					this.val = val;
		 				}
		 			}
		 		 
		 		 static class Book{
		 			   	private String creationDate;
		 			   	private String date;
		 			   	private String description;
		 			   	private Number id;
		 			   	private String key;
		 			   	private String lname;
		 			   	private List<Msr> msr;
		 			   	private String name;
		 			   	private String qualifier;
		 			   	private String scope;
		 			   	private String version;

		 			 	public String getCreationDate(){
		 					return this.creationDate;
		 				}
		 				public void setCreationDate(String creationDate){
		 					this.creationDate = creationDate;
		 				}
		 			 	public String getDate(){
		 					return this.date;
		 				}
		 				public void setDate(String date){
		 					this.date = date;
		 				}
		 			 	public String getDescription(){
		 					return this.description;
		 				}
		 				public void setDescription(String description){
		 					this.description = description;
		 				}
		 			 	public Number getId(){
		 					return this.id;
		 				}
		 				public void setId(Number id){
		 					this.id = id;
		 				}
		 			 	public String getKey(){
		 					return this.key;
		 				}
		 				public void setKey(String key){
		 					this.key = key;
		 				}
		 			 	public String getLname(){
		 					return this.lname;
		 				}
		 				public void setLname(String lname){
		 					this.lname = lname;
		 				}
		 			 	public List getMsr(){
		 					return this.msr;
		 				}
		 				public void setMsr(List msr){
		 					this.msr = msr;
		 				}
		 			 	public String getName(){
		 					return this.name;
		 				}
		 				public void setName(String name){
		 					this.name = name;
		 				}
		 			 	public String getQualifier(){
		 					return this.qualifier;
		 				}
		 				public void setQualifier(String qualifier){
		 					this.qualifier = qualifier;
		 				}
		 			 	public String getScope(){
		 					return this.scope;
		 				}
		 				public void setScope(String scope){
		 					this.scope = scope;
		 				}
		 			 	public String getVersion(){
		 					return this.version;
		 				}
		 				public void setVersion(String version){
		 					this.version = version;
		 				}
		 			}
		 }

	}
		 
		 private static String readAll(BufferedReader rd) throws IOException {
			    StringBuilder sb = new StringBuilder();
			    int cp;
			    while ((cp = rd.read()) != -1) {
			      sb.append((char) cp);
			    }
			    return sb.toString();
			  }
		 
		 String json = readAll("http://www.javascriptkit.com/"
                 + "dhtmltutors/javascriptkit.json");


  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static net.sf.json.JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject();
      json.
      return json;
    }
  }
  }
*/