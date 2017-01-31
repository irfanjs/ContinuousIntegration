package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.infosys.dcsc.so.platform.cidb.ProductDesc;
import com.infosys.dcsc.so.platform.cidb.ProjectNames;

public class ProjectData {

	public String getProjectNames() throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ProjectNames pd = new ProjectNames();
		List<Map<String, Object>> data;
		data = pd.getProjectNamesId();
		List<ProductDesc> result = new ArrayList<ProductDesc>();
		
		 
		 Gson gson = new Gson();
		 String json;
		for (Map<String, Object> data1 : data) {
			ProductDesc p = new ProductDesc();
			for (Map.Entry<String, Object> entry : data1.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());

				if (entry.getKey().equals("id"))
				{
					p.setId(Integer.parseInt(entry.getValue().toString()));
				}

				else if (entry.getKey().equals("name"))
				{
					p.setDn(entry.getValue().toString());
				}
			}
		   result.add(p);
		   
		}
		
		json = gson.toJson(result);
		return json;
	}
	
	/*public String getProjectNames() throws ClassNotFoundException, SQLException
	{
		
		ProjectNames pd = new ProjectNames();
		List<Map<String, Object>> data;
		data = pd.getProjectNames();
		
		return null;
		
	}
*/
}
