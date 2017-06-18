package model.bo;

import java.util.ArrayList;

import model.bean.Account;
import model.dao.AccountDao;

public class AccountBo {
	AccountDao accountDao = new AccountDao();

	public ArrayList<Account> getListAccount() {
		return (ArrayList<Account>) accountDao.getListAccount();
	}

	public Account getAccout(int idAccount) {
		return (Account) accountDao.getAccount(idAccount);
	}

	public boolean ChangePassword(Account account, String password, String newPassword) {
		if (!password.equals(account.getPassword()))
			return false;
		else {
			accountDao.ChangePassword(account, newPassword);
			return true;
		}
	}

	public boolean UpdateAccount(Account account) {
		// TODO Auto-generated method stub
		return (boolean) accountDao.UpdateAccount(account);
	}

	public void deleteAccount(int idAccount) {
		AccountOfNewsBo accountOfNewsBo = new AccountOfNewsBo();
		accountOfNewsBo.deleteAccountOfNews(idAccount);
		accountDao.deleteAccount(idAccount);

	}

	public boolean isLogin(String username, String password) {
		return (boolean) accountDao.isLogin(username, password);
	}

	public Account getAccountWithUsername(String username, String password) {
		return (Account) accountDao.getAccountWithUsername(username, password);
	}

	public Account getAccoutforAPI(int idAccount) {
		return (Account) accountDao.getAccoutforAPI(idAccount);
	}

	public void setOnline(int idAccount) {
		accountDao.setOnline(idAccount);
	}

	public void setOffline(int idAccount) {
		accountDao.setOffline(idAccount);
	}
}
