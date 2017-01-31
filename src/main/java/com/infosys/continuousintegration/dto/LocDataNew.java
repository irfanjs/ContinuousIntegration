package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.infosys.dcsc.so.platform.cidb.LocCount;

public class LocDataNew implements CIData {
	LocCount lc;
	
	public LocDataNew(int projectid)
	{
		lc = new LocCount(projectid);	
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
		List<Map<String, Object>> data;
		try {
			//	data = lc.getTotalLOCCountForNightlyBuildId();
			data = lc.getLocCountforLatestCIbuild();
				
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for code coverage",e);
		}
    	
    	return getJSONDataAllModulesAggregate(data);
		
	}
	
	private String getJSONDataAllModulesAggregate(List<Map<String, Object>> data)
			throws JsonProcessingException, IOException {
		if(null != data){    		
    		return CIHelper.getInstance().getJSONDataForChartPivot(data);
    	}else{
    		throw new IOException("Build data for specified build id not found");
    	}
	}


	@Override
	public String getTrendWeekData() throws IOException {
		
		ChartData d = new ChartData();
		Gson gson = new Gson();
		
		ObjectClass total = new ObjectClass("Total");
		
		List<ObjectClass> result = new ArrayList<ObjectClass>();
		String json;
		 
	        List<Integer> arrayList = new ArrayList<Integer>();
	        
	        List<Map<String, Object>> data;
	        Map<String, Object> map1;
	        Map<String, Object> map2;
	        
			try {
				data = lc.getLocCountforweekTrend();
			} catch (SQLException | ClassNotFoundException e) {
				throw new IOException("Failed to fetch data for loc",e);
			}
			
			for (Map<String, Object> data1 : data) {
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("buildnumber"))
			       {
			    	   arrayList.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			       else if (entry.getKey().equals("loc"))
			       {
			    	   total.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       		
	}
	
	}
			result.add(total);
			d.setCategories(arrayList);
			d.setData(result);
			json = gson.toJson(d);
			return json;

	}

	@Override
	public String getTrendMonthData() throws IOException {
		
		ChartData d = new ChartData();
		Gson gson = new Gson();
		
		ObjectClass total = new ObjectClass("Total");
		
		List<ObjectClass> result = new ArrayList<ObjectClass>();
		String json;
		 
	        List<Integer> arrayList = new ArrayList<Integer>();
	        
	        List<Map<String, Object>> data;
	        Map<String, Object> map1;
	        Map<String, Object> map2;
	        
			try {
				data = lc.getLocCountformonthTrend();
			} catch (SQLException | ClassNotFoundException e) {
				throw new IOException("Failed to fetch data for loc",e);
			}
			
			for (Map<String, Object> data1 : data) {
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("buildnumber"))
			       {
			    	   arrayList.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			       else if (entry.getKey().equals("loc"))
			       {
			    	   total.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       		
	}
	
	}
			result.add(total);
			d.setCategories(arrayList);
			d.setData(result);
			json = gson.toJson(d);
			return json;
	}

	
	@Override
	public String getTrendCustomData(String todate, String fromdate)
			throws IOException {
		// TODO Auto-generated method stub
		
		ChartData d = new ChartData();
		Gson gson = new Gson();
		
		ObjectClass locTotal = new ObjectClass("Total");
		
		List<ObjectClass> result = new ArrayList<ObjectClass>();
		String json;
		
	        List<Integer> arrayList = new ArrayList<Integer>();
	        
	        List<Map<String, Object>> data;
	        Map<String, Object> map1;
	        Map<String, Object> map2;
	        
			try {
				data = lc.getLocCountforCustomTrend(todate,fromdate);
			} catch (SQLException | ClassNotFoundException e) {
				throw new IOException("Failed to fetch data for loc",e);
			}
			
			for (Map<String, Object> data1 : data) {
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("buildnumber"))
			       {
			    	   arrayList.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			       else if (entry.getKey().equals("loc"))
			       {
			    	   locTotal.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
	}
	
	}
			
			result.add(locTotal);
			d.setCategories(arrayList);
			d.setData(result);
			json = gson.toJson(d);
			return json;


	}

	@Override
	public String getLatestNightlyaggregate() throws IOException {
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
