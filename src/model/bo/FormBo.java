package model.bo;

import java.util.ArrayList;

import model.bean.Form;
import model.dao.FormDao;

public class FormBo {
	FormDao formDao = new FormDao();

	public ArrayList<Form> getListForm() {
		return (ArrayList<Form>) formDao.getListForm();
	}

	public boolean addForm(Form form) {
		return (boolean) formDao.addForm(form);
	}

	public Form getForm(int idForm) {
		return (Form) formDao.getForm(idForm);
	}

	public boolean updateForm(Form form) {
		return (boolean) formDao.updateForm(form);
	}

	public void deleteForm(int idForm) {
		AccountOfFormBo accountOfFormBo = new AccountOfFormBo();
		while (accountOfFormBo.checkForm(idForm)) {
			int IdAccountOfForm = accountOfFormBo.getIdAccountOfFormWithForm(idForm);
			accountOfFormBo.deleteAccountOfForm(IdAccountOfForm);
		}
		formDao.deleteForm(idForm);
	}

}
