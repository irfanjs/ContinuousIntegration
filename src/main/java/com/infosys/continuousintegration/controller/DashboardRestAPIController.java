package com.infosys.continuousintegration.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infosys.continuousintegration.dto.CIData;
import com.infosys.continuousintegration.dto.DateRange;
import com.infosys.continuousintegration.dto.LatestNightlyBuilds;
import com.infosys.continuousintegration.dto.ProjectData;


@Controller
@RequestMapping("/dashboard")
public class DashboardRestAPIController extends ExceptionHandlingController{

	@RequestMapping(value="/{projectid}/{section}/aggregate1",   
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)
            //produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAggregated(@PathVariable("projectid") String projectid,
			@PathVariable("section") String section,
			@RequestParam("buildtype") String buildtype,
			@RequestParam("build") String build) throws Exception {
	 
		if(Integer.parseInt(projectid) == 2){
			throw new Exception("");
		}
		return "{\"name\":\"" + buildtype + "\",\"staffName\":[\"" + build + "\",\"1\"]}";
	}
	
	@RequestMapping(value="/{projectid}/{section}/aggregate",   
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)    
    public @ResponseBody String getAggregatedDataForSectionOfNightlyBuild (@PathVariable("projectid") int projectid,
			@PathVariable("section") String section,
			@RequestParam("buildtype") String buildtype,
			@RequestParam("build") String build) throws Exception {
		
		buildtype = "nightly";
		CIData cidata = DashBoardFactory.getCIData(section,projectid);
		
		if(build.toLowerCase().equals("latest") && buildtype.equals("nightly")){
			return cidata.getLatestNightlyaggregate();
		}
		else{
			return cidata.getAggregatedDataForNightlyBuild(Integer.parseInt(build));
		}
		
    }
	
	@RequestMapping(value="/{projectid}/{section}/modulewise",   
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)    
    public @ResponseBody String getModulewiseDataForSectionOfCiBuild (@PathVariable("projectid") int projectid,
			@PathVariable("section") String section,
			@RequestParam("buildtype") String buildtype,
			@RequestParam("build") String build) throws Exception {
		
			buildtype = "ci";
			CIData cidata = DashBoardFactory.getCIData(section,projectid);
			
			if(build.toLowerCase().equals("latest") && buildtype.equals("ci")){
				return cidata.getLatestCiModulewise();
			}
			else{
				return cidata.getAggregatedDataForNightlyBuild(Integer.parseInt(build));
			}
		
	}
	
	@RequestMapping(value="/{projectid}/{section}/week",   
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)    
    public @ResponseBody String getWeekDataForSectionBuild (@PathVariable("projectid") int projectid,
			@PathVariable("section") String section) throws Exception {
			
			CIData cidata = DashBoardFactory.getCIData(section,projectid);
			return cidata.getTrendWeekData();
	}
	
	@RequestMapping(value="/{projectid}/{section}/month",   
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)    
    public @ResponseBody String getMonthDataForSectionBuild (@PathVariable("projectid") int projectid,
			@PathVariable("section") String section) throws Exception {
			
			CIData cidata = DashBoardFactory.getCIData(section,projectid);
			return cidata.getTrendMonthData();
	
	}
	
	@RequestMapping(value="/{projectid}/{section}/custom",   
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)    
    public @ResponseBody String getCustomDataForSectionOfNightlyBuild (@PathVariable("projectid") int projectid,
			@PathVariable("section") String section,
			@RequestParam("todate") String todate,
			@RequestParam("fromdate") String fromdate) throws Exception {
		
		//buildtype = "nightly";
		CIData cidata = DashBoardFactory.getCIData(section,projectid);
		
		return cidata.getTrendCustomData(todate,fromdate);
    }
	
	@RequestMapping(value="/projects",   
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)    
    public @ResponseBody String getProjectDetails() throws ClassNotFoundException, IOException, SQLException{
		 ProjectData cidata = new ProjectData();
		 
		 return cidata.getProjectNames();
		
	}
	
	@RequestMapping(value="/{projectid}/latestnightlybuilds",   
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)    
    public @ResponseBody String getLatestAvailableNightlyBuilds (@PathVariable("projectid") int projectid) throws Exception {
		
		LatestNightlyBuilds cidata = new LatestNightlyBuilds(projectid);
		
		return cidata.getLatestNightlybuilds(projectid);
    }
	
	@RequestMapping(value="/daterange",   
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)    
    public @ResponseBody String getdaterange () throws Exception {
		
		DateRange cidata = new DateRange();
		
		return cidata.getdaterange();
    }
	
	@RequestMapping(value="/{projectid}/{section}/{buildnumber}",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody String getbuildnumberwiseinfo(@PathVariable("projectid") int projectid,
			@PathVariable("section") String section,@PathVariable("buildnumber") int buildnumber) throws Exception {
			CIData cidata = DashBoardFactory.getCIData(section,projectid);
			return cidata.getAggregatedDataForNightlyBuild(buildnumber);
		
	}
}

