package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.infosys.dcsc.so.platform.cidb.CodeCollaborator;

public class CodecollabData implements CIData {
	
	CodeCollaborator cc;
	
	public CodecollabData(int projectid)
	{
		cc = new CodeCollaborator(projectid);
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
	public String getLatestNightlyaggregate() throws IOException {
		
		Gson gson = new Gson();
				
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> data;
		int reviewidcnt = 0;
		
		String json;
		try 
		{
			data = cc.getAggregatedCodeCollabDataForLatestNightlyBuild();
			for (Map<String, Object> data1 : data) {
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("reviewidcount"))
			       {
			    	   reviewidcnt = Integer.parseInt(entry.getValue().toString());
			       }
			       
			    }
			}
			
			map.put("reviewidcnt", reviewidcnt);
			
			 json = gson.toJson(map);
			    return json;
		 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	
	public String getTrendWeekData() throws IOException {
		
		ChartData d = new ChartData();
		Gson gson = new Gson();
		
		ObjectTooltip ot = new ObjectTooltip();
		ot.setValueSuffix("");
		
		ObjectTooltip ot1 = new ObjectTooltip();
		ot1.setValueSuffix("min");
		
		ObjectMarker om = new ObjectMarker();
		om.setEnabled("true");
		
		ObjectClassCodeCollaborator reviewIdCountTotal = new ObjectClassCodeCollaborator("Total Reviews","column",0,om,"longdashdot",ot);
		ObjectClassCodeCollaborator reviewTimeSpentTotal = new ObjectClassCodeCollaborator("Total Time Spent(min.)","line",1,om,"longdashdot",ot1);
		ObjectClassCodeCollaborator reviewBugCountTotal = new ObjectClassCodeCollaborator("Total Bugs/Conversations","line",2,om,"shortdot",ot);
		
		
		List<ObjectClassCodeCollaborator> result = new ArrayList<ObjectClassCodeCollaborator>();
		String json;
		
	        List<Integer> arrayList = new ArrayList<Integer>();
	        
	        List<Map<String, Object>> data;
	        Map<String, Object> map1;
	        Map<String, Object> map2;
	        
			try {
				data = cc.getWeekCodeCollabTrendData();
			} catch (SQLException | ClassNotFoundException e) {
				throw new IOException("Failed to fetch data for code collab data ",e);
			}
			
			for (Map<String, Object> data1 : data) {
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("buildnumber"))
			       {
			    	   arrayList.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			       else if (entry.getKey().equals("reviewidcount"))
			       {
			    	   reviewIdCountTotal.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       else if (entry.getKey().equals("reviewbugcount"))
			       {
			    	   reviewBugCountTotal.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			       else if (entry.getKey().equals("timespent"))
			       {
			    	   reviewTimeSpentTotal.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
	}
	
	}
			
			result.add(reviewIdCountTotal);
			result.add(reviewTimeSpentTotal);
			result.add(reviewBugCountTotal);
			
			d.setCategories(arrayList);
			d.setData(result);
			json = gson.toJson(d);
			return json;
	}
	
	@Override
	public String getTrendMonthData() throws IOException {
		
		ChartData d = new ChartData();
		Gson gson = new Gson();
		
		ObjectTooltip ot = new ObjectTooltip();
		ot.setValueSuffix("");
		
		ObjectTooltip ot1 = new ObjectTooltip();
		ot1.setValueSuffix("min");
		
		ObjectMarker om = new ObjectMarker();
		om.setEnabled("true");
		
		ObjectClassCodeCollaborator reviewIdCountTotal = new ObjectClassCodeCollaborator("Total Reviews","column",0,om,"longdashdot",ot);
		ObjectClassCodeCollaborator reviewTimeSpentTotal = new ObjectClassCodeCollaborator("Total Time Spent(min.)","line",1,om,"longdashdot",ot1);
		ObjectClassCodeCollaborator reviewBugCountTotal = new ObjectClassCodeCollaborator("Total Bugs/Conversations","line",2,om,"shortdot",ot);
		
		List<ObjectClassCodeCollaborator> result = new ArrayList<ObjectClassCodeCollaborator>();
		String json;
		
	        List<Integer> arrayList = new ArrayList<Integer>();
	        
	        List<Map<String, Object>> data;
	        Map<String, Object> map1;
	        Map<String, Object> map2;
	        
			try {
				data = cc.getMonthCodeCollabTrendData();
			} catch (SQLException | ClassNotFoundException e) {
				throw new IOException("Failed to fetch data for code collab data ",e);
			}
			
			for (Map<String, Object> data1 : data) {
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("buildnumber"))
			       {
			    	   arrayList.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			       else if (entry.getKey().equals("reviewidcount"))
			       {
			    	   reviewIdCountTotal.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			       else if (entry.getKey().equals("reviewbugcount"))
			       {
			    	   reviewBugCountTotal.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			       else if (entry.getKey().equals("timespent"))
			       {
			    	   reviewTimeSpentTotal.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			    }
	
			}
			
			result.add(reviewIdCountTotal);
			result.add(reviewTimeSpentTotal);
			result.add(reviewBugCountTotal);
			
			d.setCategories(arrayList);
			d.setData(result);
			json = gson.toJson(d);
			return json;

	}

	@Override
	public String getTrendCustomData(String todate, String fromdate)
			throws IOException {
		ChartData d = new ChartData();
		Gson gson = new Gson();
		
		ObjectTooltip ot = new ObjectTooltip();
		ot.setValueSuffix("");
		
		ObjectTooltip ot1 = new ObjectTooltip();
		ot1.setValueSuffix("min");
		
		ObjectMarker om = new ObjectMarker();
		om.setEnabled("true");
		
		ObjectClassCodeCollaborator reviewIdCountTotal = new ObjectClassCodeCollaborator("Total Reviews","column",0,om,"longdashdot",ot);
		ObjectClassCodeCollaborator reviewTimeSpentTotal = new ObjectClassCodeCollaborator("Total Time Spent(min.)","line",1,om,"longdashdot",ot1);
		ObjectClassCodeCollaborator reviewBugCountTotal = new ObjectClassCodeCollaborator("Total Bugs/Conversations","line",2,om,"shortdot",ot);
		
		List<ObjectClassCodeCollaborator> result = new ArrayList<ObjectClassCodeCollaborator>();
		String json;
		
	        List<Integer> arrayList = new ArrayList<Integer>();
	        
	        List<Map<String, Object>> data;
	        Map<String, Object> map1;
	        Map<String, Object> map2;
	        
			try {
				data = cc.getCustomCodeCollabTrenddata(todate,fromdate);
			} catch (SQLException | ClassNotFoundException e) {
				throw new IOException("Failed to fetch data for review",e);
			}
			
			for (Map<String, Object> data1 : data) {
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("buildnumber"))
			       {
			    	   arrayList.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
			       else if (entry.getKey().equals("reviewidcount"))
			       {
			    	   reviewIdCountTotal.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       else if (entry.getKey().equals("reviewbugcount"))
			       {
			    	   reviewBugCountTotal.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       else if (entry.getKey().equals("timespent"))
			       {
			    	   reviewTimeSpentTotal.data.add(Integer.parseInt(entry.getValue().toString()));
			       }
			       
	}
	
	}
			
			result.add(reviewIdCountTotal);
			result.add(reviewTimeSpentTotal);
			result.add(reviewBugCountTotal);
			
			d.setCategories(arrayList);
			d.setData(result);
			json = gson.toJson(d);
			return json;
	}

	@Override
	public String getLatestCiModulewise() throws IOException {
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
