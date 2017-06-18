package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conn.ConnectionUtils;

public class AccountOfNewsDao {
	Connection conn = ConnectionUtils.getConnection();

	public void deleteAccountOfNews(int idAccount) {
		String sql = "delete from AccountOfNews where IdAccount = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idAccount);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted news with account");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkAccountWithNews(int idAccount) {
		String sql = "select IdAccountOfNews from AccountOfNews where IdAccount = " + idAccount;
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

	public boolean addAccountOfNews(int idAccount, int idNews) {
		String sql = "insert into AccountOfNews values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idAccount);
			ps.setInt(2, idNews);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkAccountOfNews(int idNews) {
		String sql = "select IdAccountOfNews from AccountOfNews where IdNews = " + idNews;
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

	public int getIdAccountOfNews(int idNews) {
		String sql = "select IdAccountOfNews from AccountOfNews where IdNews = " + idNews;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("IdAccountOfNews");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void deleteAccountOfNewsWithIDKey(int idAccountOfNews) {
		String sql = "delete from AccountOfNews where IdAccountOfNews = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idAccountOfNews);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted news with account");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getIdAccount(int idNews) {
		String sql = "select IdAccount from AccountOfNews where IdNews = " + idNews;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("IdAccount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
