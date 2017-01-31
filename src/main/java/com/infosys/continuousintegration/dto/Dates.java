package com.infosys.continuousintegration.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dates d = new Dates();

	}
	
	public Dates()
	{
		//String dateString = new String("12/12/2005");
		String dateString = new String("07/APR/2014");
		java.util.Date dtDate = new Date();
	//	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		SimpleDateFormat sdfAct = new SimpleDateFormat("dd/MMM/yyyy");
		try
		{
		dtDate = sdfAct.parse(dateString);
		System.out.println("Date After parsing in required format:"+(sdf.format(dtDate)));
		}
		catch (ParseException e)
		{
		System.out.println("Unable to parse the date string");
		e.printStackTrace();
		}
	}

}
