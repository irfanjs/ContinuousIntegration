package com.infosys.continuousintegration.dto;

import java.util.ArrayList;
import java.util.List;

public class ObjectClassCodeCollaborator {
	
	public ObjectClassCodeCollaborator(String dataName,String graphtype,int axis,ObjectMarker mark,String dashstyle,ObjectTooltip toltip) {
		name = dataName;
		type = graphtype;
		yAxis = axis;
		marker = mark;
		dashstle = dashstyle;
		tooltip = toltip;
	}

	public String name;
	public String type;
	public int yAxis;
	public List<Integer> data = new ArrayList<Integer>();
	public ObjectMarker marker;
	public String dashstle;
	public ObjectTooltip tooltip;


}
