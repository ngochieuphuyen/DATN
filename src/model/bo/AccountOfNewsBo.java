package model.bo;

import model.dao.AccountOfNewsDao;

public class AccountOfNewsBo {
	AccountOfNewsDao accountOfNewsDao = new AccountOfNewsDao();

	public void deleteAccountOfNews(int idAccount) {
		if (checkAccountWithNews(idAccount)) {
			accountOfNewsDao.deleteAccountOfNews(idAccount);
		}

	}

	private boolean checkAccountWithNews(int idAccount) {
		return (boolean) accountOfNewsDao.checkAccountWithNews(idAccount);
	}

	public boolean addAccountOfNews(int idAccount, int idNews) {
		return (boolean) accountOfNewsDao.addAccountOfNews(idAccount, idNews);
	}

	public boolean checkAccountOfNews(int idNews) {
		return (boolean) accountOfNewsDao.checkAccountOfNews(idNews);
	}

	public int getIdAccountOfNews(int idNews) {
		return (int) accountOfNewsDao.getIdAccountOfNews(idNews);
	}

	public void deleteAccountOfNewsWithIDKey(int idAccountOfNews) {
		accountOfNewsDao.deleteAccountOfNewsWithIDKey(idAccountOfNews);

	}

	public int getIdAccount(int idNews) {
		return (int) accountOfNewsDao.getIdAccount(idNews);
	}

}
