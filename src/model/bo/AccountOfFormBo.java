package model.bo;

import java.util.ArrayList;

import model.bean.AccountOfForm;
import model.dao.AccountOfFormDao;

public class AccountOfFormBo {
	AccountOfFormDao accountOfFormDao = new AccountOfFormDao();

	public boolean checkForm(int idForm) {
		return (boolean) accountOfFormDao.checkForm(idForm);
	}

	public int getIdAccountOfFormWithForm(int idForm) {
		return (int) accountOfFormDao.getIdAccountOfFormWithForm(idForm);
	}

	public void deleteAccountOfForm(int idAccountOfForm) {
		accountOfFormDao.deleteAccountOfForm(idAccountOfForm);
	}

	public boolean addAccountOfForm(AccountOfForm accountOfForm, int waitingTime) {
		if(accountOfForm.getIdSituation() == 2) waitingTime = 0;
		return (boolean) accountOfFormDao.addAccountOfForm(accountOfForm, waitingTime);
	}

	public ArrayList<AccountOfForm> getListRequestedForm(int idAccount) {
		return (ArrayList<AccountOfForm>) accountOfFormDao.getListRequestedForm(idAccount);
	}

	public ArrayList<AccountOfForm> getListJustRegistered() {
		return (ArrayList<AccountOfForm>) accountOfFormDao.getListJustRegistered();
	}

	public void unsubscribeForm(int idAccountOfForm) {
		accountOfFormDao.deleteAccountOfForm(idAccountOfForm);
	}

	public ArrayList<AccountOfForm> getListFormReceive() {
		return (ArrayList<AccountOfForm>) accountOfFormDao.getListFormReceive();
	}

	public ArrayList<AccountOfForm> getListTimeout() {
		return (ArrayList<AccountOfForm>) accountOfFormDao.getListTimeout();
	}

	public void receiveForm(int idAccountOfForm) {
		accountOfFormDao.deleteAccountOfForm(idAccountOfForm);
	}

	public void timeout(int idAccountOfForm) {
		accountOfFormDao.deleteAccountOfForm(idAccountOfForm);

	}

}
