package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.infosys.dcsc.so.platform.cidb.Regression;

public class RegressionData implements CIData {
	
	Regression rg;
	
	
	public RegressionData(int projectid)
	{
		rg = new Regression(projectid);
	}

	@Override
	public void setBuildNumber(int buildnumber) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getbuildwiseinfo(int projectid, int buildnumber)
			throws IOException {
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
		
		ChartData d = new ChartData();
		Gson gson = new Gson();

		ObjectClass testResultPass = new ObjectClass("Pass");
		ObjectClass testResultFail = new ObjectClass("Fail");
		ObjectClass testResultSkip = new ObjectClass("Skip");
		ObjectClass testResultTotal = new ObjectClass("Total");

		List<ObjectClass> result = new ArrayList<ObjectClass>();
		String json;

		List<Integer> arrayList = new ArrayList<Integer>();

		List<Map<String, Object>> data;
		Map<String, Object> map1;
		Map<String, Object> map2;

		try {
			data = rg.getWeekRegAggregateDataNightlyBuild();
		} catch (SQLException e) {
			throw new IOException("Failed to fetch data for unit test", e);
		}

		for (Map<String, Object> data1 : data) {
			for (Map.Entry<String, Object> entry : data1.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());

				if (entry.getKey().equals("buildnumber")) {
					arrayList.add(Integer.parseInt(entry.getValue().toString()));
				}

				else if (entry.getKey().equals("pass")) {
					testResultPass.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				}

				else if (entry.getKey().equals("fail")) {
					testResultFail.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				} else if (entry.getKey().equals("total")) {
					testResultTotal.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				}

				else if (entry.getKey().equals("skip")) {
					testResultSkip.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				}

			}

		}
		result.add(testResultPass);
		result.add(testResultFail);
		result.add(testResultTotal);
		result.add(testResultSkip);
		d.setCategories(arrayList);
		d.setData(result);
		json = gson.toJson(d);
		return json;
	}

	@Override
	public String getTrendMonthData() throws IOException {
		ChartData d = new ChartData();
		Gson gson = new Gson();

		ObjectClass testResultPass = new ObjectClass("Pass");
		ObjectClass testResultFail = new ObjectClass("Fail");
		ObjectClass testResultSkip = new ObjectClass("Skip");
		ObjectClass testResultTotal = new ObjectClass("Total");

		List<ObjectClass> result = new ArrayList<ObjectClass>();
		String json;

		List<Integer> arrayList = new ArrayList<Integer>();

		List<Map<String, Object>> data;
		Map<String, Object> map1;
		Map<String, Object> map2;

		try {
			data = rg.getMonthRegAggregateDataNightlyBuild();
		} catch (SQLException e) {
			throw new IOException("Failed to fetch data for unit test", e);
		}

		for (Map<String, Object> data1 : data) {
			for (Map.Entry<String, Object> entry : data1.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());

				if (entry.getKey().equals("buildnumber")) {
					arrayList.add(Integer.parseInt(entry.getValue().toString()));
				}

				else if (entry.getKey().equals("pass")) {
					testResultPass.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				}

				else if (entry.getKey().equals("fail")) {
					testResultFail.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				} else if (entry.getKey().equals("total")) {
					testResultTotal.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				}

				else if (entry.getKey().equals("skip")) {
					testResultSkip.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				}

			}

		}
		result.add(testResultPass);
		result.add(testResultFail);
		result.add(testResultTotal);
		result.add(testResultSkip);
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

		ObjectClass testResultPass = new ObjectClass("Pass");
		ObjectClass testResultFail = new ObjectClass("Fail");
		ObjectClass testResultSkip = new ObjectClass("Skip");
		ObjectClass testResultTotal = new ObjectClass("Total");

		List<ObjectClass> result = new ArrayList<ObjectClass>();
		String json;

		List<Integer> arrayList = new ArrayList<Integer>();

		List<Map<String, Object>> data;
		Map<String, Object> map1;
		Map<String, Object> map2;

		try {
			data = rg.getCustomRegAggregateDataNightlyBuild(todate,fromdate);
		} catch (SQLException e) {
			throw new IOException("Failed to fetch data for unit test", e);
		}

		for (Map<String, Object> data1 : data) {
			for (Map.Entry<String, Object> entry : data1.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());

				if (entry.getKey().equals("buildnumber")) {
					arrayList.add(Integer.parseInt(entry.getValue().toString()));
				}

				else if (entry.getKey().equals("pass")) {
					testResultPass.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				}

				else if (entry.getKey().equals("fail")) {
					testResultFail.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				} else if (entry.getKey().equals("total")) {
					testResultTotal.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				}

				else if (entry.getKey().equals("skip")) {
					testResultSkip.data.add(Integer.parseInt(entry.getValue()
							.toString()));
				}

			}

		}
		result.add(testResultPass);
		result.add(testResultFail);
		result.add(testResultTotal);
		result.add(testResultSkip);
		d.setCategories(arrayList);
		d.setData(result);
		json = gson.toJson(d);
		return json;
	
	}

}
