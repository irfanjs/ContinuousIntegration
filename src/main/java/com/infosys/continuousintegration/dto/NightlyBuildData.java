package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.infosys.dcsc.so.platform.cidb.NightlyBuild;

public class NightlyBuildData implements CIData {	
	NightlyBuild nb = new NightlyBuild(0);
	public String getSummaryData() throws IOException{
    	List<Map<String, Object>> data;
		try {
				data = nb.getSummaryDataLatestBuild();
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for nightly build summary",e);
		}
    	
    	return getJSONData(data);
	}
	
	private String getJSONData(List<Map<String, Object>> data) throws JsonProcessingException{
		if(0 < data.size()){
			NightlyChartData nChartData = new NightlyChartData();
			Map<String, Object> map =  data.get(0);
			nChartData.setBuildNumber(map.get("buildnumber").toString());
			nChartData.setResult(map.get("result").toString());
			nChartData.setReason(map.get("reason").toString());
			
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(nChartData);
		}
		
		return "[]";
	}
	
	class NightlyChartData{
		private String buildNumber;
		private String result;
		private String reason;
		
		public String getBuildNumber() {
			return this.buildNumber;
		}
		
		public void setBuildNumber(String buildNumber) {
			this.buildNumber = buildNumber;
		}
		
		public String getResult() {
			return result;
		}
		
		public void setResult(String result) {
			this.result = result;
		}
		
		public String getReason() {
			return reason;
		}
		
		public void setReason(String reason) {
			this.reason = reason;
		}
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
		int bn = 0;
		String result = null;
		String reason = null;
		int loc = 0;
		String datetime = null;
		
		String json;
		try 
		{
			data = nb.getSummaryDataLatestBuild();
			for (Map<String, Object> data1 : data) {
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("buildnumber"))
			       {
			    	    bn = Integer.parseInt(entry.getValue().toString());
			       }
			       
			       else if (entry.getKey().equals("result"))
			       {
			    	    result = entry.getValue().toString();
			       }
			       
			       else if (entry.getKey().equals("reason"))
			       {
			    	   reason = entry.getValue().toString();
			       }
			       else if (entry.getKey().equals("datetime"))
			       {
			    	   datetime = (entry.getValue().toString());
			       }
			       else if (entry.getKey().equals("loc"))
			       {
			    	   loc = Integer.parseInt(entry.getValue().toString());
			       }
			       
			    }
			}
			map.put("buildNumber", bn);
			map.put("result", result);
			map.put("reason", reason);
			map.put("datetime", datetime);
			map.put("loc", loc);
			
			 json = gson.toJson(map);
			    return json;
			
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for build summary",e);
		}
		
}

	@Override
	public String getLatestCiModulewise() throws IOException {
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

			