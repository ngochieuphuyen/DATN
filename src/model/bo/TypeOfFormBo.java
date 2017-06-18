package model.bo;

import java.util.ArrayList;

import model.bean.TypeOfForm;
import model.dao.TypeOfFormDao;

public class TypeOfFormBo {
	TypeOfFormDao typeOfFormDao = new TypeOfFormDao();

	public ArrayList<TypeOfForm> getListTypeOfForm() {
		return (ArrayList<TypeOfForm>) typeOfFormDao.getListTypeOfForm();
	}

	public String getTypeOfFormName(int idTypeOfForm) {
		return (String) typeOfFormDao.getTypeOfFormName(idTypeOfForm);
	}

}
