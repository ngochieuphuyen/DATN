package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.Account;

public class AccountDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<Account> getListAccount() {
		ArrayList<Account> listAccount = new ArrayList<>();
		String sql = "select IdAccount, Username, Email from Accounts";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setIdAccount(rs.getInt("IdAccount"));
				account.setUsername(rs.getString("Username"));
//				account.setPassword(rs.getString("Password"));
				account.setEmail(rs.getString("Email"));
//				account.setTypeAccount(rs.getInt("TypeAccount"));

				listAccount.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("khong getList duoc");
		}
		return listAccount;
	}

	// public static void main(String args[]){
	// AccountDao accountDao = new AccountDao();
	// ArrayList<Account> list = accountDao.getListAccount();
	// System.out.println("hien thi:");
	// System.out.println(list.size());
	// }
	public Account getAccount(int idAccount) {
		String sql = "select Username, Password, Email, TypeAccount from Accounts where IdAccount =" + idAccount;
		Account account = new Account();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account.setIdAccount(idAccount);
				account.setUsername(rs.getString("Username"));
				account.setPassword(rs.getString("Password"));
				account.setEmail(rs.getString("Email"));
				account.setTypeAccount(rs.getInt("TypeAccount"));
				account.setDecentralizationName(getAccountType(rs.getInt("TypeAccount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	public String getAccountType(int TypeAccount) {
		String sql = "select DecentralizationName from Decentralization where IdDecentralization = " + TypeAccount;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString("DecentralizationName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void ChangePassword(Account account, String newPassword) {
		String sql = "update Accounts set Password=? where IdAccount=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, account.getIdAccount());
			if (ps.executeUpdate() > 0)
				System.out.println("update password");
		} catch (Exception e) {
		}
	}

	public boolean UpdateAccount(Account account) {
		String sql = "update Accounts set Username=?, Email=?, TypeAccount=? where IdAccount=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getEmail());
			ps.setInt(3, account.getTypeAccount());
			ps.setInt(4, account.getIdAccount());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deleteAccount(int idAccount) {
		String sql = "delete from Accounts where IdAccount = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idAccount);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted account");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean isLogin(String username, String password) {
		String sql = "select IdAccount from Accounts where Username =? and Password =? and Status =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setBoolean(3, false);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Account getAccountWithUsername(String username, String password) {
		String sql = "select IdAccount, Email, TypeAccount from Accounts where Username =? and Password =?";
		Account account = new Account();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account.setIdAccount(rs.getInt("IdAccount"));
				account.setUsername(username);
				account.setPassword(password);
				account.setEmail(rs.getString("Email"));
				account.setTypeAccount(rs.getInt("TypeAccount"));
				account.setDecentralizationName(getAccountType(rs.getInt("TypeAccount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	public boolean addAccount(Account account) {
		String sql = "insert into Accounts values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getEmail());
			ps.setInt(4, account.getTypeAccount());
			ps.setBinaryStream(5, null);
			ps.setBoolean(6, false);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("acount");
		}

		return false;
	}

	public int getIdAccount(String username) {
		String sql = "select IdAccount from Accounts where Username =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("IdAccount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Account getAccoutforAPI(int idAccount) {
		String sql = "select Username, Password, Email from Accounts where IdAccount =" + idAccount;
		Account account = new Account();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account.setIdAccount(idAccount);
				account.setUsername(rs.getString("Username"));
				account.setPassword(rs.getString("Password"));
				account.setEmail(rs.getString("Email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	public void setOnline(int idAccount) {
		String sql = "update Accounts set Status=? where IdAccount=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setInt(2, idAccount);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setOffline(int idAccount) {
		String sql = "update Accounts set Status=? where IdAccount=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, false);
			ps.setInt(2, idAccount);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
