package model.bean;

import java.util.ArrayList;

public class Function {
	private int IdFunction;
	private String FunctionName;
	private String FunctionAddress;
	private String FunctionLogo;

	public Function() {
	}

	public int getIdFunction() {
		return IdFunction;
	}

	public void setIdFunction(int idFunction) {
		IdFunction = idFunction;
	}

	public String getFunctionName() {
		return FunctionName;
	}

	public void setFunctionName(String functionName) {
		FunctionName = functionName;
	}

	public String getFunctionAddress() {
		return FunctionAddress;
	}

	public void setFunctionAddress(String functionAddress) {
		FunctionAddress = functionAddress;
	}

	public String getFunctionLogo() {
		return FunctionLogo;
	}

	public void setFunctionLogo(String functionLogo) {
		FunctionLogo = functionLogo;
	}

	public static boolean checkedFunction(int idFunction, ArrayList<Integer> listIDFunctionChecked) {
		for (int i = 0; i < listIDFunctionChecked.size(); i++) {
			if (idFunction == listIDFunctionChecked.get(i))
				return true;
		}
		return false;
	}

}
