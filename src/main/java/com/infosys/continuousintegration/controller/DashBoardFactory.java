package com.infosys.continuousintegration.controller;

import java.io.FileNotFoundException;

import com.infosys.continuousintegration.dto.BatCodeCoverageDataNew;
import com.infosys.continuousintegration.dto.BatDataNew;
import com.infosys.continuousintegration.dto.CIData;
import com.infosys.continuousintegration.dto.CodeCoverageData;
import com.infosys.continuousintegration.dto.CodecollabData;
import com.infosys.continuousintegration.dto.CodecomplexData;
import com.infosys.continuousintegration.dto.FindbugDataNew;
import com.infosys.continuousintegration.dto.LocDataNew;
import com.infosys.continuousintegration.dto.NightlyBuildData;
import com.infosys.continuousintegration.dto.PmdDataNew;
import com.infosys.continuousintegration.dto.ProjectData;
import com.infosys.continuousintegration.dto.RegressionCodeCoverage;
import com.infosys.continuousintegration.dto.RegressionData;
import com.infosys.continuousintegration.dto.UnitTestDataNew;


public class DashBoardFactory {
	
	static public CIData getCIData(String moduleName,int projectid) throws FileNotFoundException{
		
		if (moduleName.equals("ut")){
			return new UnitTestDataNew(projectid);
		}
		
		else if (moduleName.equals("cc")){
			return new CodeCoverageData(projectid);
		}
		
		else if (moduleName.equals("fb")){
			return new FindbugDataNew(projectid);
		}
		
		else if (moduleName.equals("pm")){
			return new PmdDataNew(projectid);
		}
		
		else if (moduleName.equals("bat")){
			return new BatDataNew(projectid);
		}
		
		else if (moduleName.equals("regcc")){
			return new RegressionCodeCoverage(projectid);
		}
		
		else if (moduleName.equals("reg")){
			return new RegressionData(projectid);
		}
		
		else if (moduleName.equals("batcc")){
			return new BatCodeCoverageDataNew(projectid);
		}
		
		else if (moduleName.equals("bs")){
			return new NightlyBuildData();
		}
		
		else if (moduleName.equals("loc")){
			return new LocDataNew(projectid);
		}
		else if (moduleName.equals("codecollab")){
			return new CodecollabData(projectid);
		}
		else if (moduleName.equals("complex")){
			return new CodecomplexData(projectid);
		}
		
			
			throw new FileNotFoundException(String.format("'{0}' Module not found", moduleName));
		
	}
	
	/*static public CIData getProjectDesc(){
		
		return new ProjectData();
	}*/
}
