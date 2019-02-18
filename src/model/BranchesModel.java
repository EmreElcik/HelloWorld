package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionUtils;
import entity.Branches;

public class BranchesModel {

	public List<Branches> getAll() {
		List<Branches> result = new ArrayList<Branches>();
		
		Connection con = null;// = ConnectionUtils.getConnection();
		PreparedStatement ps = null;// = con.prepareStatement("sql");
		ResultSet rs = null;
		
		try {
			
			con = ConnectionUtils.getConnection();
			ps = con.prepareStatement("select * from eelcik.koc_oc_branches");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				Branches row = new Branches();
				row.setBranchId(rs.getInt("branch_id"));
				row.setBranchName(rs.getString("branch_name"));
				row.setBranchShortName(rs.getString("branch_name"));
				
				result.add(row);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionUtils.closeAll(con, ps, rs);
		}
		
		
		return result;
		
	}

	public void saveBranch(Branches branches) {
		
		String sql = "Insert into eelcik.koc_oc_branches(BRANCH_ID, BRANCH_NAME, BRANCH_SHORT_NAME)"
				+ " Values(?, ?, ?)";
		
		
		
		//Java 1.7 ile geldi, Java 7 öncesinde finally ile kapatmak gerekiyor
		//Auto Closable Interface Conn, Ps, Rs, file implents AC
		try (	Connection c = ConnectionUtils.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		
		{
			ps.setInt(1, branches.getBranchId());
			ps.setString(2, branches.getBranchName());
			ps.setString(3, branches.getBranchShortName());
			ps.executeUpdate();
			//ps.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
