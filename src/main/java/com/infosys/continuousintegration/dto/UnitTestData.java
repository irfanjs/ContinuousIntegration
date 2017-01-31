package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infosys.dcsc.so.platform.cidb.UnitTest;

public class UnitTestData implements CIData{
	
	UnitTest ut;
	public UnitTestData(int projectid) {
		//super(projectid);
		ut = new UnitTest(projectid);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getAggregatedDataForLatestBuild() throws IOException{
    	List<Map<String, Object>> data;
		try {
				data = ut.getAggregatedUnitTestDataForLatestBuild();
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for unit test",e);
		}
    	
    	return getJSONData(data,true);
	}
	
	@Override
	public String getAggregatedDataForBuild(int buildno) throws IOException {
		throw new IOException("Not implemented");
	}

	@Override
	public String getAggregatedDataForNightlyBuild(int buildno)
			throws IOException {
		throw new IOException("Not implemented");
	}

	@Override
	public String getAggregatedDataForLatestNightlyBuild() throws IOException {
		List<Map<String, Object>> data;
		try {
			data = ut.getAggregatedUnitTestDataForLatestNightlyBuild();
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for unit test",e);
		}
    	return getJSONData(data,true);
	}

	@Override
	public String getAllModuleDataForBuild(int buildno) throws IOException {
		throw new IOException("Not implemented");
	}

	@Override
	public String getModuleDataForLatestBuild() throws IOException {
		List<Map<String, Object>> data;
		try {
			data = ut.getUnitTestDataForLatestBuildId();
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for unit test",e);
		}
    	
    	return getJSONData(data,true);
	}

	@Override
	public String getModuleDataForBuild(int buildno) throws IOException {
		throw new IOException("Not implemented");
	}

	@Override
	public String getAllModuleDataForLatestNightlyBuild() throws IOException {
		List<Map<String, Object>> data;
		try {
			data = ut.getAllModulesUnitTestForLatestNightlyBuild();
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for unit test",e);
		}
    	
		return getJSONDataForColumnwise(data);
	}

	@Override
	public String getAllModuleDataForNightlyBuild(int buildno)
			throws IOException {
		throw new IOException("Not implemented");
	}

	@Override
	public String getModuleDataForLatestNightlyBuild() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModuleDataForNightlyBuild(int buildno) throws IOException {
		throw new IOException("Not implemented");
	}

	@Override
	public String getAllModuleDataForLatestBuild() throws IOException {
		List<Map<String, Object>> data;
		try {
			data = ut.getAllModulesUnitTestForLatestBuild();
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for unit test",e);
		}
    	
    	return getJSONDataForColumnwise(data);
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
	

	private String getJSONData(List<Map<String, Object>> data,boolean skipTotal)
			throws JsonProcessingException, IOException {
		if(null != data){    		
    		Map<String,String> selectDataList = new HashMap<String,String>();
    		selectDataList.put("total","Total");
    		selectDataList.put("fail","Fail");
    		selectDataList.put("pass","Pass");
    		selectDataList.put("skip","Skip");
    		return CIHelper.getInstance().getJSONDataForChart(data, selectDataList);
    	}else{
    		throw new IOException("Build data for specified build id not found");
    	}
	}
	
	private String getJSONDataForColumnwise(List<Map<String, Object>> data)
			throws JsonProcessingException, IOException {
		if(null != data){    		
			Map<String,String> selectDataList = new HashMap<String,String>();
    		selectDataList.put("fail","Fail");
    		selectDataList.put("pass","Pass");
    		selectDataList.put("skip","Skip");
    		return CIHelper.getInstance().getJSONDataForChartColumnWise(data, "modulename", selectDataList);
    	}else{
    		throw new IOException("Build data for specified build id not found");
    	}
	}

	@Override
	public String getLatestNightlyaggregate() throws IOException {
		// TODO Auto-generated method stub
		return null;
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
