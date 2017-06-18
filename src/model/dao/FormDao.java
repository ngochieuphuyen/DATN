package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.Form;

public class FormDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<Form> getListForm() {
		ArrayList<Form> listForm = new ArrayList<>();
		String sql = "select IdForm, FormName from Form";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Form form = new Form();
				form.setIdForm(rs.getInt("IdForm"));
				form.setFormName(rs.getString("FormName"));
//				form.setIdTypeOfForm(rs.getInt("IdTypeOfForm"));
//				form.setWaitingTime(rs.getInt("WaitingTime"));
//				form.setDescriptions(rs.getString("Descriptions"));

				listForm.add(form);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listForm;
	}

	public boolean addForm(Form form) {
		String sql = "insert into Form values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, form.getFormName());
			ps.setInt(2, form.getIdTypeOfForm());
			ps.setInt(3, form.getWaitingTime());
			ps.setString(4, form.getDescriptions());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Form getForm(int idForm) {
		Form form = new Form();
		String sql = "select FormName, IdTypeOfForm, WaitingTime, Descriptions from Form where IdForm =" + idForm;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				form.setIdForm(idForm);
				form.setFormName(rs.getString("FormName"));
				form.setIdTypeOfForm(rs.getInt("IdTypeOfForm"));
				form.setWaitingTime(rs.getInt("WaitingTime"));
				form.setDescriptions(rs.getString("Descriptions"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return form;
	}

	public boolean updateForm(Form form) {
		String sql = "update Form set FormName=?, IdTypeOfForm=?, WaitingTime=?, Descriptions=? where IdForm=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, form.getFormName());
			ps.setInt(2, form.getIdTypeOfForm());
			ps.setInt(3, form.getWaitingTime());
			ps.setString(4, form.getDescriptions());
			ps.setInt(5, form.getIdForm());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deleteForm(int idForm) {
		String sql = "delete from Form where IdForm = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idForm);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted form");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
