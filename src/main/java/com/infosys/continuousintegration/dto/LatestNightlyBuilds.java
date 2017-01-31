package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.infosys.dcsc.so.platform.cidb.NightlyBuild;

public class LatestNightlyBuilds {
	NightlyBuild n;
	
	public LatestNightlyBuilds(int projectid)
	{
		n = new NightlyBuild(projectid);
	}
	
	public String getLatestNightlybuilds(int projectid) throws IOException
	{
		
		List<Map<String, Object>> data;
		Gson gson = new Gson();
		List<Object> arrayList = new ArrayList<Object>();
		
		String json;
			
		try {
			
			data = n.getBuildArtifactsForLatestNightlyBuild();
			if (data.size()!=0)
			{
			for (Map<String, Object> data1 : data) {
				NightArtifacts na = new NightArtifacts();
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("buildnumber"))
			       {
			    //	    pas = Integer.parseInt(entry.getValue().toString());
			    	   // na.setId(Integer.parseInt(entry.getValue().toString()));
			    	    na.setBuildnumber(Integer.parseInt(entry.getValue().toString()));
			       }
			       else if (entry.getKey().equals("loc"))
			       {
			    	    na.setLoc(Integer.parseInt(entry.getValue().toString()));
			       }
			       else if (entry.getKey().equals("result"))
			       {
			    	    na.setResult(entry.getValue().toString());
			       }
			       
			       else if (entry.getKey().equals("reason"))
			       {
			    	    na.setReason(entry.getValue().toString());
			       }
			       
			       else if (entry.getKey().equals("datetime"))
			       {
			    	    na.setDatetime(entry.getValue().toString());
			       }
			       
			       else if (entry.getKey().equals("reviewidcount"))
			       {
			    	    na.setReviewidcount(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			    }
			    
			    arrayList.add(na);
			     
			}
			
			json = gson.toJson(arrayList);
			return json;
			}
			else
			{
				return null;
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for latest nightly build artifact",e);
		}
    	
	}

}
