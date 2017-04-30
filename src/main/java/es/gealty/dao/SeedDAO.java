package es.gealty.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.gealty.bean.SeedBean;

public class SeedDAO extends BaseDAO {

	public SeedBean getBean() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		SeedBean result = new SeedBean();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select count(1) as count from seed");
			rs = stmt.executeQuery();
			
			if(rs.next()){
				result.setName(String.valueOf(rs.getInt("count")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
		return result;

	}

}
