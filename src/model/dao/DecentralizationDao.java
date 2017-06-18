package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.Decentralization;

public class DecentralizationDao {
	Connection conn = ConnectionUtils.getConnection();

	public Decentralization getDecentralization(int typeAccount) {
		String sql = "select DecentralizationName from Decentralization where IdDecentralization = " + typeAccount;
		Decentralization decentralization = new Decentralization();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				decentralization.setIdDecentralization(typeAccount);
				decentralization.setDecentralizationName(rs.getString("DecentralizationName"));
//				decentralization.setDescriptiveDecentralization(rs.getString("DescriptiveDecentralization"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decentralization;
	}

	public ArrayList<Decentralization> getListDecentralization() {
		String sql = "select IdDecentralization, DecentralizationName from Decentralization";
		ArrayList<Decentralization> listDecentralization = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Decentralization decentralization = new Decentralization();
				decentralization.setIdDecentralization(rs.getInt("IdDecentralization"));
				decentralization.setDecentralizationName(rs.getString("DecentralizationName"));
//				decentralization.setDescriptiveDecentralization(rs.getString("DescriptiveDecentralization"));

				listDecentralization.add(decentralization);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDecentralization;
	}

	public int getIdDecentrlization(String DecentralizationName) {
		String sql = "select IdDecentralization from Decentralization where DecentralizationName =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, DecentralizationName);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("IdDecentralization");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void deleteDecentralization(int idDecentralization) {
		String sql = "delete from Decentralization where IdDecentralization = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idDecentralization);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted decentralization");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean createDecentralization(String decentralizationName, String description) {
		String sql = "insert into Decentralization values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, decentralizationName);
			ps.setString(2, description);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
