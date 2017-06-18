package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import conn.ConnectionUtils;
import model.bean.AccountOfForm;

public class AccountOfFormDao {
	Connection conn = ConnectionUtils.getConnection();

	public boolean checkForm(int idForm) {
		String sql = "select IdAccountOfForm from AccountOfForm where IdForm = " + idForm;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getIdAccountOfFormWithForm(int idForm) {
		String sql = "select IdAccountOfForm from AccountOfForm where IdForm = " + idForm;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("IdAccountOfForm");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void deleteAccountOfForm(int idAccountOfForm) {
		String sql = "delete from AccountOfForm where IdAccountOfForm = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idAccountOfForm);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted form with account");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addAccountOfForm(AccountOfForm accountOfForm, int waitingTime) {
		String sql = "insert into AccountOfForm (IdForm, IdAccount, IdSituation, TimeOfRegistration, ReceivingTime) values(?,?,?,?,?)";
//		System.out.println(accountOfForm.getIdForm()+"/"+accountOfForm.getIdAccount()+"/"+accountOfForm.getIdSituation());
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountOfForm.getIdForm());
			ps.setInt(2, accountOfForm.getIdAccount());
			ps.setInt(3, accountOfForm.getIdSituation());
			Calendar rightNow = Calendar.getInstance();
			String dateCurrent = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
					+ rightNow.get(Calendar.DAY_OF_MONTH);
			java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
			ps.setDate(4, date.valueOf(dateCurrent));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			rightNow.setTime(sdf.parse(dateCurrent));
			rightNow.add(Calendar.DATE, waitingTime);
			String receivingTime = sdf.format(rightNow.getTime());
			ps.setDate(5, date.valueOf(receivingTime));
			
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("acount");
		}
		return false;
	}

	public ArrayList<AccountOfForm> getListRequestedForm(int idAccount) {
		ArrayList<AccountOfForm> listRequested = new ArrayList<>();
		String sql ="select IdForm, TimeOfRegistration, ReceivingTime from AccountOfForm where IdAccount = ? and ReceivingTime >= ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idAccount);
			Calendar rightNow = Calendar.getInstance();
			String dateCurrent = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
					+ rightNow.get(Calendar.DAY_OF_MONTH);
			java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
			
			ps.setDate(2, date.valueOf(dateCurrent));
			ResultSet rs = ps.executeQuery();
			FormDao formDao = new FormDao();
			while (rs.next()){
				AccountOfForm accountOfForm = new AccountOfForm();
				accountOfForm.setTimeOfRegistration(rs.getDate("TimeOfRegistration"));
				accountOfForm.setReceivingTime(rs.getDate("ReceivingTime"));
				accountOfForm.setFormName(formDao.getForm(rs.getInt("IdForm")).getFormName());
				listRequested.add(accountOfForm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRequested;
	}

	public ArrayList<AccountOfForm> getListJustRegistered() {
		ArrayList<AccountOfForm> listRequested = new ArrayList<>();
		String sql ="select IdAccountOfForm, IdForm, TimeOfRegistration, ReceivingTime, IdAccount from AccountOfForm where ReceivingTime > ? order by IdAccountOfForm DESC";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			Calendar rightNow = Calendar.getInstance();
			String dateCurrent = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
					+ rightNow.get(Calendar.DAY_OF_MONTH);
			java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			rightNow.setTime(sdf.parse(dateCurrent));
			rightNow.add(Calendar.DATE, 2);
			String receiving = sdf.format(rightNow.getTime());
			ps.setDate(1, date.valueOf(receiving));
			ResultSet rs = ps.executeQuery();
			FormDao formDao = new FormDao();
			AccountDao accountDao = new AccountDao();
			while (rs.next()){
				AccountOfForm accountOfForm = new AccountOfForm();
				accountOfForm.setIdAccountOfForm(rs.getInt("IdAccountOfForm"));
				accountOfForm.setTimeOfRegistration(rs.getDate("TimeOfRegistration"));
				accountOfForm.setReceivingTime(rs.getDate("ReceivingTime"));
				accountOfForm.setFormName(formDao.getForm(rs.getInt("IdForm")).getFormName());
				String username = accountDao.getAccount(rs.getInt("IdAccount")).getUsername();
				accountOfForm.setUsername(username);
				listRequested.add(accountOfForm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRequested;
	}

	public ArrayList<AccountOfForm> getListFormReceive() {
		ArrayList<AccountOfForm> listReceive = new ArrayList<>();
		String sql ="select IdAccountOfForm, IdForm, TimeOfRegistration, ReceivingTime, IdAccount from AccountOfForm where ReceivingTime<= ? and ReceivingTime >= ? order by IdAccountOfForm DESC";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			Calendar rightNow = Calendar.getInstance();
			String dateCurrent = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
					+ rightNow.get(Calendar.DAY_OF_MONTH);
			java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
			ps.setDate(1, date.valueOf(dateCurrent));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			rightNow.setTime(sdf.parse(dateCurrent));
			rightNow.add(Calendar.DATE, -3);
			String receiving = sdf.format(rightNow.getTime());
			ps.setDate(2, date.valueOf(receiving));
			ResultSet rs = ps.executeQuery();
			FormDao formDao = new FormDao();
			AccountDao accountDao = new AccountDao();
			while (rs.next()){
				AccountOfForm accountOfForm = new AccountOfForm();
				accountOfForm.setIdAccountOfForm(rs.getInt("IdAccountOfForm"));
				accountOfForm.setTimeOfRegistration(rs.getDate("TimeOfRegistration"));
				accountOfForm.setReceivingTime(rs.getDate("ReceivingTime"));
				accountOfForm.setFormName(formDao.getForm(rs.getInt("IdForm")).getFormName());
				String username = accountDao.getAccount(rs.getInt("IdAccount")).getUsername();
				accountOfForm.setUsername(username);
				listReceive.add(accountOfForm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listReceive;
	}

	public ArrayList<AccountOfForm> getListTimeout() {
		ArrayList<AccountOfForm> listTimeout = new ArrayList<>();
		String sql ="select IdAccountOfForm, IdForm, TimeOfRegistration, ReceivingTime, IdAccount from AccountOfForm where ReceivingTime < ? order by IdAccountOfForm DESC";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			Calendar rightNow = Calendar.getInstance();
			String dateCurrent = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
					+ rightNow.get(Calendar.DAY_OF_MONTH);
			java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			rightNow.setTime(sdf.parse(dateCurrent));
			rightNow.add(Calendar.DATE, -3);
			String receiving = sdf.format(rightNow.getTime());
			ps.setDate(1, date.valueOf(receiving));
			ResultSet rs = ps.executeQuery();
			FormDao formDao = new FormDao();
			AccountDao accountDao = new AccountDao();
			while (rs.next()){
				AccountOfForm accountOfForm = new AccountOfForm();
				accountOfForm.setIdAccountOfForm(rs.getInt("IdAccountOfForm"));
				accountOfForm.setTimeOfRegistration(rs.getDate("TimeOfRegistration"));
				accountOfForm.setReceivingTime(rs.getDate("ReceivingTime"));
				accountOfForm.setFormName(formDao.getForm(rs.getInt("IdForm")).getFormName());
				String username = accountDao.getAccount(rs.getInt("IdAccount")).getUsername();
				accountOfForm.setUsername(username);
				listTimeout.add(accountOfForm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTimeout;
	}

}
