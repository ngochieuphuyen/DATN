package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;

public class DecentralizationOfFunctionDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<Integer> getListIdFunction(int idDecentralization) {
		ArrayList<Integer> listIdFunction = new ArrayList<>();
		String sql = "select IdFunction from DecentralizationOfFunction where IsAccept ='true' and IdDecentralization ="
				+ idDecentralization;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listIdFunction.add(rs.getInt("IdFunction"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listIdFunction;
	}

	public void createOrUpdate(int idDecentralization, int idFunction, boolean b) {
		String sql = "select IdFunction from DecentralizationOfFunction where IdFunction = ? and IdDecentralization = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idFunction);
			ps.setInt(2, idDecentralization);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String sql1 = "update DecentralizationOfFunction set IsAccept=? where IdFunction = ? and IdDecentralization = ?";
				try {
					PreparedStatement ps1 = conn.prepareStatement(sql1);
					ps1.setBoolean(1, b);
					ps1.setInt(2, idFunction);
					ps1.setInt(3, idDecentralization);
					ps1.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				String sql1 = "insert into DecentralizationOfFunction values(?,?,?)";
				try {
					PreparedStatement ps1 = conn.prepareStatement(sql1);
					ps1.setBoolean(3, b);
					ps1.setInt(2, idFunction);
					ps1.setInt(1, idDecentralization);
					ps1.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteDecentralizationOfFunction(int idDecentralization) {
		String sql = "delete from DecentralizationOfFunction where IdDecentralization = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idDecentralization);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted decentralization of function");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
