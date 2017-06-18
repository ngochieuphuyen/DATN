package model.bean;

public class RegistrationSituation {
	private int IdSituation;
	private String SituationName;
	private float Price;
	private String Description;
	
	public RegistrationSituation(){}

	public RegistrationSituation(int idSituation, String situationName, float price, String description) {
		super();
		IdSituation = idSituation;
		SituationName = situationName;
		Price = price;
		Description = description;
	}

	public int getIdSituation() {
		return IdSituation;
	}

	public void setIdSituation(int idSituation) {
		IdSituation = idSituation;
	}

	public String getSituationName() {
		return SituationName;
	}

	public void setSituationName(String situationName) {
		SituationName = situationName;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
}
