package model.bo;

import java.util.ArrayList;

import model.bean.Decentralization;
import model.dao.DecentralizationDao;

public class DecentralizationBo {
	DecentralizationDao decentralizationDao = new DecentralizationDao();

	public Decentralization getDecentralization(int typeAccount) {
		return (Decentralization) decentralizationDao.getDecentralization(typeAccount);
	}

	public ArrayList<Decentralization> getListDecentralization() {
		return (ArrayList<Decentralization>) decentralizationDao.getListDecentralization();
	}

	public void deleteDecentralization(int idDecentralization) {
		DecentralizationOfFunctionBo decentralizationOfFunctionBo = new DecentralizationOfFunctionBo();
		decentralizationOfFunctionBo.deleteDecentralizationOfFunction(idDecentralization);
		decentralizationDao.deleteDecentralization(idDecentralization);

	}

	public boolean createDecentralization(String decentralizationName, String description) {
		return (boolean) decentralizationDao.createDecentralization(decentralizationName, description);
	}
}
