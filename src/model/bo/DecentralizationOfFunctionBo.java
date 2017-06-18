package model.bo;


import java.util.ArrayList;

import model.bean.Function;
import model.dao.DecentralizationOfFunctionDao;

public class DecentralizationOfFunctionBo {
	DecentralizationOfFunctionDao decentralizationOfFunctionDao = new DecentralizationOfFunctionDao();

	public ArrayList<Integer> getListIdFunction(int idDecentralization) {
		return (ArrayList<Integer>) decentralizationOfFunctionDao.getListIdFunction(idDecentralization);
	}

	public boolean upateFunction(int idDecentralization, ArrayList<Integer> listIdChecked) {
		FunctionBo functionBo = new FunctionBo();
		ArrayList<Function> listFunction = functionBo.getListFunctionFull();
		for (int i = 0; i < listFunction.size(); i++) {
			if (Function.checkedFunction(listFunction.get(i).getIdFunction(), listIdChecked))
				decentralizationOfFunctionDao.createOrUpdate(idDecentralization, listFunction.get(i).getIdFunction(),
						true);
			else {
				decentralizationOfFunctionDao.createOrUpdate(idDecentralization, listFunction.get(i).getIdFunction(),
						false);
			}
		}
		return true;
	}

	public void deleteDecentralizationOfFunction(int idDecentralization) {
		decentralizationOfFunctionDao.deleteDecentralizationOfFunction(idDecentralization);
	}

}
