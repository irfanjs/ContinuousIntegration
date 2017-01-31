package com.infosys.continuousintegration.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Test54 {
	
	public Test54()
	{
		
	}
	
	

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		String jsonText;
		
		InputStream is = new URL("http://10.211.64.231:9000/api/resources?metrics=function_complexity&format=json").openStream();
		 try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      jsonText = readAll(rd);
		      System.out.println(jsonText);
		
	  }finally {
	      is.close();
	    }
		 
		 Gson gson = new Gson();        
		 
		 JsonParser parser = new JsonParser();
		    JsonArray jArray = parser.parse(jsonText).getAsJsonArray();
		    
		    ArrayList<Book> lcs = new ArrayList<Book>();
		   // ArrayList<Msr> lcs1 = new ArrayList<Msr>();
		    
		    for(JsonElement obj : jArray )
		    {
		        Book cse = gson.fromJson( obj , Book.class);
		        lcs.add(cse);
		       // Msr m = gson.fromJson(obj , Msr.class);
		       // lcs1.add(m);
		        //System.out.println(lcs.toArray());
		    }
		    
		    
		    Iterator<Book> it = lcs.iterator();
		    
		   // Iterator<Msr> it1 = lcs1.iterator();
		    
		    /*List lcs1 = new ArrayList<Book>();
		    
		    Book b = new Book();
		    lcs1 = b.getMsr();
		    
		    Iterator<Book> it1 = lcs1.iterator();*/
		    List lcs1 = new ArrayList<String>();
		    Map <String, Float> hm = new HashMap<String, Float>();
		    while(it.hasNext())
		    {
		        Book obj = it.next();
		        System.out.println(obj.getKey());
		        System.out.println(obj.getMsr().get(0).getVal());
		        
		        hm.put(obj.getName(), obj.getMsr().get(0).getVal());
		        
		        
		        //Msr m = it1.next();
		        //System.out.println(m.getVal());
		       // Book obj1 = it1.next();
		       // System.out.println(obj1.get);
		       // System.out.println(obj.getMsr());
		        //Do something with obj
		    }
		    
		    Iterator it23 = hm.entrySet().iterator();
		    while (it23.hasNext()) {
		        Map.Entry pairs = (Map.Entry)it23.next();
		        System.out.println(pairs.getKey() + " = " + pairs.getValue());
		   
		    }
	}
		    
		    
		    
		// Book bk = gson.fromJson(jsonText,Book.class);
		 
		/* for (Msr msr : bk.msr)
			 System.out.println("    " + msr.val);

	}*/
	
	 private static String readAll(BufferedReader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }

}
