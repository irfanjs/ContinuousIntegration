package com.infosys.continuousintegration.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Mapcheck {

	public static void main(String[] args) {

		ChartData d = new ChartData();
		Gson gson = new Gson();

		String json;

		List<TestResult> result = new ArrayList<TestResult>();

		TestResult testResultPass = new TestResult("pass");
		testResultPass.data.add(10);
		testResultPass.data.add(20);
		
		TestResult testResultFail = new TestResult("fail");
		testResultFail.data.add(30);
		testResultFail.data.add(40);

		
		result.add(testResultPass);
		result.add(testResultFail);

		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(10);
		arrayList.add(20);

		List<Integer> arrayList1 = new ArrayList<Integer>();
		List<Integer> arrayList2 = new ArrayList<Integer>();

		arrayList1.add(30);
		arrayList1.add(40);

		arrayList2.add(50);
		arrayList2.add(60);

		d.setCategories(arrayList);
		d.setData(result);
		json = gson.toJson(d);
		System.out.println(json);

	}

}
class TestResult {
	public TestResult(String resultType) {
		name = resultType;
	}
	public String name;
	public List<Integer> data = new ArrayList<Integer>();
}
