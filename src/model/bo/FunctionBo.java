package model.bo;

import java.util.ArrayList;

import model.bean.Function;
import model.dao.DecentralizationOfFunctionDao;
import model.dao.FunctionDao;

public class FunctionBo {
	FunctionDao functionDao = new FunctionDao();
	DecentralizationOfFunctionDao decentralizationOfFunctionDao = new DecentralizationOfFunctionDao();

	public ArrayList<Function> getListFunction(int idDecentralization) {
		ArrayList<Integer> listIdFunction = decentralizationOfFunctionDao.getListIdFunction(idDecentralization);
		ArrayList<Function> listFunction = new ArrayList<>();
		for (int i = 0; i < listIdFunction.size(); i++) {
			Function function = functionDao.getFunction(listIdFunction.get(i).intValue());
			listFunction.add(function);
		}
		return listFunction;
	}

	public ArrayList<Function> getListFunctionFull() {
		return (ArrayList<Function>) functionDao.getListFunctionFull();
	}
}
