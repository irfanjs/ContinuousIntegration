package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.infosys.dcsc.so.platform.cidb.BAT;

public class BatCodeCoverageDataNew implements CIData {
	
	
	BAT bt;
	
	public BatCodeCoverageDataNew(int projectid)
	{
		bt = new BAT(projectid);
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
		ChartData d = new ChartData();
		Gson gson = new Gson();
		
		List<Map<String, Object>> data;
		
		float cover = 29;
		float noncover = 71;
		String json;
		String nocoverage = null;
		
		
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("Coverage");
		arrayList.add("No coverage");
		ArrayList<Float> singleList = new ArrayList<Float>();
		singleList.add(cover);
		singleList.add(noncover);
		
		 Map<String, Object> map = new HashMap<>();
			map.put("Data", singleList);
			
			ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			dataList.add(map);
		
			d.setCategories(arrayList);
		    d.setData(dataList);
		    
		    json = gson.toJson(d);
		    return json;
		//    return null;
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
