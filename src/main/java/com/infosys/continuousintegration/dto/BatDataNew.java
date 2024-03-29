package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.infosys.dcsc.so.platform.cidb.BAT;

public class BatDataNew implements CIData {
	
	BAT bt;
	
	public BatDataNew(int projectid)
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
		
		List<Map<String, Object>> data;
		ChartData d = new ChartData();
		Gson gson = new Gson();
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("Pass");
		arrayList.add("Fail");
		

		int pas = 0;
		int fail = 0;
		
		String json;

		ArrayList<Integer> singleList = new ArrayList<Integer>();
		try {
			data = bt.getbatspecificbldno(buildno);
			if (data.size() != 0) {
				for (Map<String, Object> data1 : data) {
					for (Map.Entry<String, Object> entry : data1.entrySet()) {
						System.out.println(entry.getKey() + ": "
								+ entry.getValue());

						if (entry.getKey().equals("pass")) {
							pas = Integer.parseInt(entry.getValue().toString());
						} else if (entry.getKey().equals("fail")) {
							fail = Integer
									.parseInt(entry.getValue().toString());
						} 

					}

					singleList.add(pas);
					singleList.add(fail);
					

					Map<String, Object> map = new HashMap<>();
					map.put("Data", singleList);

					ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
					dataList.add(map);

					d.setCategories(arrayList);
					d.setData(dataList);

					json = gson.toJson(d);
					return json;

				}
			} else {
				return null;
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for unit test", e);
		}
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
		
		List<Map<String, Object>> data;
		ChartData d = new ChartData();
		Gson gson = new Gson();
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("Pass");
		arrayList.add("Fail");
		
		
		int pas = 0;
		int fail = 0;
		int skip = 0;
		String json;
		
		ArrayList<Integer> singleList = new ArrayList<Integer>();
		
		try {
			data = bt.getAggregatedBATDataForLatestNightlyBuild();
			for (Map<String, Object> data1 : data) {
			    for (Map.Entry<String, Object> entry : data1.entrySet()) {
			       System.out.println(entry.getKey() + ": " + entry.getValue());
			       
			       if (entry.getKey().equals("pass"))
			       {
			    	    pas = Integer.parseInt(entry.getValue().toString());
			       }
			       else if (entry.getKey().equals("fail"))
			       {
			    	    fail = Integer.parseInt(entry.getValue().toString());
			       }
			       else if (entry.getKey().equals("skip"))
			       {
			    	    skip = Integer.parseInt(entry.getValue().toString());
			       }
			       
			    }
			    
			    singleList.add(pas);
			    singleList.add(fail);
		
			    
			    Map<String, Object> map = new HashMap<>();
				map.put("Data", singleList);
				
				ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
				dataList.add(map);
				
			    d.setCategories(arrayList);
			    d.setData(dataList);
			    
			    json = gson.toJson(d);
			    return json;
			    
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for bat",e);
		}
    	//return getJSONData(data,true);
		
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
			data = bt.getWeekBtAggregateDataNightlyBuild();
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
			data = bt.getMonthBtAggregateDataNightlyBuild();
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
			throws IOException, ClassNotFoundException {
		
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
			data = bt.getCustomBtAggregateDataNightlyBuild(todate,fromdate);
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
