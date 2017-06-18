package model.bean;

public class NewsCategory {
	private int IdNewsCategory;
	private String NewsCategoryName;
	private String DescriptiveNewsCategory;
	
	public NewsCategory(){}

	public NewsCategory(int idNewsCategory, String newsCategoryName, String descriptiveNewsCategory) {
		super();
		IdNewsCategory = idNewsCategory;
		NewsCategoryName = newsCategoryName;
		DescriptiveNewsCategory = descriptiveNewsCategory;
	}

	public int getIdNewsCategory() {
		return IdNewsCategory;
	}

	public void setIdNewsCategory(int idNewsCategory) {
		IdNewsCategory = idNewsCategory;
	}

	public String getNewsCategoryName() {
		return NewsCategoryName;
	}

	public void setNewsCategoryName(String newsCategoryName) {
		NewsCategoryName = newsCategoryName;
	}

	public String getDescriptiveNewsCategory() {
		return DescriptiveNewsCategory;
	}

	public void setDescriptiveNewsCategory(String descriptiveNewsCategory) {
		DescriptiveNewsCategory = descriptiveNewsCategory;
	}
	
}
