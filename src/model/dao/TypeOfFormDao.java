package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.TypeOfForm;

public class TypeOfFormDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<TypeOfForm> getListTypeOfForm() {
		ArrayList<TypeOfForm> listTypeOfForm = new ArrayList<>();
		String sql = "select IdTypeOfForm, TypeOfFormName from TypeOfForm";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TypeOfForm typeOfForm = new TypeOfForm();
				typeOfForm.setIdTypeOfForm(rs.getInt("IdTypeOfForm"));
				typeOfForm.setTypeOfFormName(rs.getString("TypeOfFormName"));
//				typeOfForm.setDesriptions(rs.getString("Desriptions"));

				listTypeOfForm.add(typeOfForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTypeOfForm;
	}

	public String getTypeOfFormName(int idTypeOfForm) {
		String sql = "select TypeOfFormName from TypeOfForm where IdTypeOfForm =" + idTypeOfForm;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("TypeOfFormName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
