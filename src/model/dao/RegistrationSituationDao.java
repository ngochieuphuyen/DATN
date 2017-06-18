package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.RegistrationSituation;

public class RegistrationSituationDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<RegistrationSituation> getListRegistrationSituation() {
		ArrayList<RegistrationSituation> listRegistrationSituation = new ArrayList<>();
		String sql = "select IdSituation, SituationName, Price, Description from RegistrationSituation";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RegistrationSituation situation = new RegistrationSituation();
				situation.setIdSituation(rs.getInt("IdSituation"));
				situation.setSituationName(rs.getString("SituationName"));
				situation.setPrice(rs.getFloat("Price"));
				situation.setDescription(rs.getString("Description"));
				listRegistrationSituation.add(situation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRegistrationSituation;
	}

}
