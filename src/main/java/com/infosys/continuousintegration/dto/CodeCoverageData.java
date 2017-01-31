package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.infosys.dcsc.so.platform.cidb.CodeCoverage;
import org.apache.log4j.Logger;

public class CodeCoverageData implements CIData {

	CodeCoverage cc;
	 static Logger log = Logger.getLogger(CodeCoverageData.class.getName());

	public CodeCoverageData(int projectid) {
		cc = new CodeCoverage(projectid);
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
				
		List<Map<String, Object>> data;
		ChartData d = new ChartData();
		Gson gson = new Gson();
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("Coverage");
		arrayList.add("No Coverage");

		float cover = 0;
		float nocover;

		String json;

		ArrayList<Float> singleList = new ArrayList<Float>();

		try {
			data = cc.getccspecificbldno(buildno);

			if (data.size() != 0) {
				for (Map<String, Object> data1 : data) {
					for (Map.Entry<String, Object> entry : data1.entrySet()) {
						System.out.println(entry.getKey() + ": "
								+ entry.getValue());

						if (entry.getKey().equals("coverage")
								&& entry.getValue().toString().equals(null)) {
							// cover =
							// Float.parseFloat(entry.getValue().toString());
						} else {
							cover = Float.parseFloat(entry.getValue()
									.toString());
						}

					}
				}

				nocover = 100 - cover;

				singleList.add(cover);
				singleList.add(nocover);

				Map<String, Object> map = new HashMap<>();
				map.put("Data", singleList);

				ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
				dataList.add(map);

				d.setCategories(arrayList);
				d.setData(dataList);

				json = gson.toJson(d);
				return json;
			} else {
				return null;
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException(
					"Failed to fetch data for unit test code coverage", e);
		}

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

		List<Map<String, Object>> data;
		ChartData d = new ChartData();
		Gson gson = new Gson();
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("Coverage");
		arrayList.add("No Coverage");

		float cover = 0;
		float nocover;

		String json;

		ArrayList<Float> singleList = new ArrayList<Float>();

		try {
			data = cc.getAggregatedCodeCoverageDataForLatestNightlyBuild();

			if (data.size() != 0) {
				for (Map<String, Object> data1 : data) {
					for (Map.Entry<String, Object> entry : data1.entrySet()) {
						System.out.println(entry.getKey() + ": "
								+ entry.getValue());

						if (entry.getKey().equals("coverage")
								&& entry.getValue().toString().equals(null)) {
							// cover =
							// Float.parseFloat(entry.getValue().toString());
						} else {
							cover = Float.parseFloat(entry.getValue()
									.toString());
						}

					}
				}

				nocover = 100 - cover;

				singleList.add(cover);
				singleList.add(nocover);

				Map<String, Object> map = new HashMap<>();
				map.put("Data", singleList);

				ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
				dataList.add(map);

				d.setCategories(arrayList);
				d.setData(dataList);

				json = gson.toJson(d);
				return json;
			} else {
				return null;
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException(
					"Failed to fetch data for unit test code coverage", e);
		}
	}

	@Override
	public String getLatestCiModulewise() throws IOException {
		List<Map<String, Object>> data;
	//	HashMap data = new HashMap<String, Object>();
		try {
			data = cc.getAllModulesAggregatedCodeCoverageDataForLatestBuild();
			log.debug("the size of data is " + data.size());
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for code coverage", e);
		}

		return getJSONDataAllModulesAggregate(data);
	}

	private String getJSONDataAllModulesAggregate(List<Map<String, Object>> data)
			throws JsonProcessingException, IOException {
		if (null != data) {
			log.debug("the size of data in aggregate block " + data.size());
			return CIHelper.getInstance().getJSONDataForChartPivot(data);
		} else {
			throw new IOException("Build data for specified build id not found");
		}
	}

	@Override
	public String getTrendWeekData() throws IOException {

		ChartData d = new ChartData();
		Gson gson = new Gson();

		ObjectClass coverageTotal = new ObjectClass("Total");

		List<ObjectClass> result = new ArrayList<ObjectClass>();
		String json;

		List<Integer> arrayList = new ArrayList<Integer>();

		List<Map<String, Object>> data;
		Map<String, Object> map1;
		Map<String, Object> map2;

		try {
			data = cc.getWeekCcAggregateDataNightlyBuild();
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for unit test", e);
		}

		for (Map<String, Object> data1 : data) {
			for (Map.Entry<String, Object> entry : data1.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());

				if (entry.getKey().equals("buildnumber")) {
					arrayList
							.add(Integer.parseInt(entry.getValue().toString()));
				}

				else if (entry.getKey().equals("linescoverage")) {
					coverageTotal.data.add((int) Float.parseFloat(entry
							.getValue().toString()));
				}

			}

		}

		result.add(coverageTotal);
		d.setCategories(arrayList);
		d.setData(result);
		json = gson.toJson(d);
		return json;

	}

	@Override
	public String getTrendMonthData() throws IOException {
		ChartData d = new ChartData();
		Gson gson = new Gson();

		ObjectClass coverageTotal = new ObjectClass("Total");

		List<ObjectClass> result = new ArrayList<ObjectClass>();
		String json;

		List<Integer> arrayList = new ArrayList<Integer>();

		List<Map<String, Object>> data;
		Map<String, Object> map1;
		Map<String, Object> map2;

		try {
			data = cc.getMonthCcAggregateDataNightlyBuild();
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for unit test", e);
		}

		for (Map<String, Object> data1 : data) {
			for (Map.Entry<String, Object> entry : data1.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());

				if (entry.getKey().equals("buildnumber")) {
					arrayList
							.add(Integer.parseInt(entry.getValue().toString()));
				}

				else if (entry.getKey().equals("linescoverage")) {
					coverageTotal.data.add((int) Float.parseFloat(entry
							.getValue().toString()));
				}

			}

		}

		result.add(coverageTotal);
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

		ObjectClass coverageTotal = new ObjectClass("Total");

		List<ObjectClass> result = new ArrayList<ObjectClass>();
		String json;

		List<Integer> arrayList = new ArrayList<Integer>();

		List<Map<String, Object>> data;
		Map<String, Object> map1;
		Map<String, Object> map2;

		try {
			data = cc.getTrendCustomCcData(todate, fromdate);
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for unit test", e);
		}

		for (Map<String, Object> data1 : data) {
			for (Map.Entry<String, Object> entry : data1.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());

				if (entry.getKey().equals("buildnumber")) {
					arrayList
							.add(Integer.parseInt(entry.getValue().toString()));
				}

				else if (entry.getKey().equals("linescoverage")) {
					coverageTotal.data.add((int) Float.parseFloat(entry
							.getValue().toString()));
				}

			}

		}

		result.add(coverageTotal);
		d.setCategories(arrayList);
		d.setData(result);
		json = gson.toJson(d);
		return json;

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

	/*
	 * private String getJSONDataForPie(List<Map<String, Object>> data) throws
	 * JsonProcessingException, IOException { if(null != data){
	 * Map<String,String> selectDataList = new HashMap<String,String>();
	 * selectDataList.put("coverage","Coverage"); return
	 * CIHelper.getInstance().getJSONDataForChart(data,
	 * selectDataList,"No Coverage"); }else{ throw new
	 * IOException("Build data for specified build id not found"); } }
	 */
}
