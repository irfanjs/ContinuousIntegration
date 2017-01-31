package com.infosys.continuousintegration.dto;

import java.util.ArrayList;

import com.google.gson.Gson;

public class Simplejson {

	public static void main(String[] args) {
		// 
		String name = "so";
		String id = "1";
		
		Details d = new Details();
		ArrayList<Details> singleList = new ArrayList<Details>();
		
		
		d.setDisplayname(name);
		d.setProjectId(id);
		
		Gson gson = new Gson();
		singleList.add(d);
		
		
		String json = gson.toJson(singleList);
		System.out.println(json);
		
		

	}

}
