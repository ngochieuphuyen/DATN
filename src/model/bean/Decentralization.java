package model.bean;

public class Decentralization {
	private int IdDecentralization;
	private String DecentralizationName;
	private String DescriptiveDecentralization;
	
	public Decentralization(){
		IdDecentralization = -1;
		DecentralizationName = null;
		DescriptiveDecentralization = null;
	}

	public Decentralization(int idDecentralization, String decentralizationName, String descriptiveDecentralization) {
		IdDecentralization = idDecentralization;
		DecentralizationName = decentralizationName;
		DescriptiveDecentralization = descriptiveDecentralization;
	}

	public int getIdDecentralization() {
		return IdDecentralization;
	}

	public void setIdDecentralization(int idDecentralization) {
		IdDecentralization = idDecentralization;
	}

	public String getDecentralizationName() {
		return DecentralizationName;
	}

	public void setDecentralizationName(String decentralizationName) {
		DecentralizationName = decentralizationName;
	}

	public String getDescriptiveDecentralization() {
		return DescriptiveDecentralization;
	}

	public void setDescriptiveDecentralization(String descriptiveDecentralization) {
		DescriptiveDecentralization = descriptiveDecentralization;
	}
	
	
}
