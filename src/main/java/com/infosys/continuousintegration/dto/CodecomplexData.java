package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.infosys.dcsc.so.platform.cidb.CodeComplex;

public class CodecomplexData implements CIData {
	
	CodeComplex cc;
	
	public CodecomplexData(int projectid)
	{
		cc = new CodeComplex(projectid);	
		
	}
	

	@Override
	public String getAggregatedDataForBuild(int buildno) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAggregatedDataForLatestBuild() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAggregatedDataForNightlyBuild(int buildno)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAggregatedDataForLatestNightlyBuild() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllModulesAggregatedDataForLatestBuild()
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllModulesAggregatedDataForLatestNightlyBuild()
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllModuleDataForBuild(int buildno) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModuleDataForLatestBuild() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModuleDataForBuild(int buildno) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllModuleDataForLatestNightlyBuild() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllModuleDataForNightlyBuild(int buildno)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModuleDataForLatestNightlyBuild() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModuleDataForNightlyBuild(int buildno) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllModuleDataForLatestBuild() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public String getLatestCiModulewise() throws IOException {
		// TODO Auto-generated method stub
		
		ChartData d = new ChartData();
		Gson gson = new Gson();
		List<String> arrayList = new ArrayList<String>();
		
		
		float function = 0;
		
		String json;
		
		ArrayList<Float> singleList = new ArrayList<Float>();
		
		List<Map<String, Object>> data;
		try {
			data = cc.getAllModulesCodeComplexForLatestBuild();
			for (Map<String, Object> data1 : data) {
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("modulename"))
			       {
			    	    
			    	    arrayList.add(entry.getValue().toString());
			    	    
			       }
			       
			       else if (entry.getKey().equals("function"))
			       {
			    	    function = Float.parseFloat(entry.getValue().toString());
			    	    singleList.add(function);
			       }
			       
				 
			     }
			}
			   d.setCategories(arrayList);
			    d.setData(singleList);
			    
			    json = gson.toJson(d);
			    return json;	
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for unit test",e);
		}
		
    	//return getJSONDataAllModulesAggregate(data);
	}

	@Override
	public String getLatestNightlyaggregate() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrendWeekData() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrendMonthData() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrendCustomData(String todate, String fromdate)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setBuildNumber(int buildnumber) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getbuildwiseinfo(int projectid, int buildnumber)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}


