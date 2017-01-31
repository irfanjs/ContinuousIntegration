package com.infosys.continuousintegration.dto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infosys.dcsc.so.platform.cidb.CIDBHelper;
import com.infosys.dcsc.so.platform.cidb.CodeCoverage;

public class Sec {
	int projectid = 1;
	// static List<Map<String, Object>> data;
	// CodeCoverage cc;

	public Sec() {
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Sec a = new Sec();
		a.getLatestCiModulewise();
	}

	@SuppressWarnings("null")
	public String getLatestCiModulewise() throws IOException {
		Sec a;
		List<Map<String, Object>> data;
		try {
			data = getAllModulesAggregatedCodeCoverageDataForLatestBuild();
			System.out.println("value of data is " + data);
		} catch (SQLException | ClassNotFoundException e) {
			throw new IOException("Failed to fetch data for code coverage", e);
		}

		return getJSONDataAllModulesAggregate(data);
	}

	private String getJSONDataAllModulesAggregate(List<Map<String, Object>> data)
			throws JsonProcessingException, IOException {
		if (null != data) {
			return CIHelper.getInstance().getJSONDataForChartPivot(data);
		} else {
			throw new IOException("Build data for specified build id not found");
		}
	}

	public List<Map<String, Object>> getAllModulesAggregatedCodeCoverageDataForLatestBuild()
			throws SQLException, ClassNotFoundException {
		// String sql = "select modulename ,ROUND((cc.packages + cc.files +
		// cc.classes + cc.methods + cc.linesofcode + cc.conditions)/6) coverage
		// from (select id,sub.modulename from buildinfo bi INNER JOIN ( select
		// modulename, max(datetime) as dt from buildinfo group by modulename)
		// sub on sub.modulename = bi.modulename and bi.datetime = sub.dt) bi
		// LEFT JOIN codecoverage cc on cc.buildinfo_id = bi.id;";
		String sql = "select modulename ,ROUND(cc.linesofcode) coverage from (select id,sub.modulename from buildinfo bi INNER JOIN ( select modulename, max(datetime) as dt from buildinfo where project_id = "
				+ this.projectid
				+ " and nightlybuild_id is NULL group by modulename) sub on sub.modulename = bi.modulename and bi.datetime = sub.dt) bi LEFT JOIN codecoverage cc on cc.buildinfo_id = bi.id;";
		System.out.println(sql);

		return executeQuery(sql);

	}

	public List<Map<String, Object>> executeQuery(String sql) throws SQLException {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			conn = CIDBHelper.getInstance().getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);

			List<Map<String, Object>> lst;
			lst = CIDBHelper.getInstance().getEntitiesFromResultSet(resultSet);
			System.out.println("value of lst is " + lst.size());
			for (int i = 0; i < lst.size(); i++) {
				System.out.println(((Object) lst.get(i)));
			}
			return CIDBHelper.getInstance().getEntitiesFromResultSet(resultSet);
		}

		finally {
			CIDBHelper.close(conn, statement, resultSet);
		}

	}
}
