package es.gealty.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.gealty.bean.SeedLocation;

public class LocationDAO extends BaseDAO {

	public List<SeedLocation> getLocations() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		List<SeedLocation> result = new ArrayList<SeedLocation>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(
					"select s.id, l.lattitude, l.longitude from  seed s, location l WHERE  s.id = l.id_seed");
			rs = stmt.executeQuery();

			while (rs.next()) {
				SeedLocation sLocation = new SeedLocation();
				sLocation.setId(rs.getLong("ID"));
				sLocation.setLat(rs.getDouble("latitude"));
				sLocation.setLng(rs.getDouble("longitude"));

				result.add(sLocation);
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
