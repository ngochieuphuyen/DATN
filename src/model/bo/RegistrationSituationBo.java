package model.bo;

import java.util.ArrayList;

import model.bean.RegistrationSituation;
import model.dao.RegistrationSituationDao;

public class RegistrationSituationBo {
	RegistrationSituationDao registrationSituationDao = new RegistrationSituationDao();

	public ArrayList<RegistrationSituation> getListRegistrationSituation() {
		return (ArrayList<RegistrationSituation>) registrationSituationDao.getListRegistrationSituation();
	}

}
