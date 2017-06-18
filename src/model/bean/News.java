package model.bean;

import java.util.Date;

public class News {
	private int IdNews;
	private int IdCategory;
	private String Title;
	private String DescriptiveNews;
	private String Detail;
	private Date PostTime;
	private int Views;
	private String Image;
	
	public News(){}

	public News(int idNews, int idCategory, String title, String descriptiveNews, String detail, Date postTime,
			int views, String image) {
		super();
		IdNews = idNews;
		IdCategory = idCategory;
		Title = title;
		DescriptiveNews = descriptiveNews;
		Detail = detail;
		PostTime = postTime;
		Views = views;
		Image = image;
	}

	public int getIdNews() {
		return IdNews;
	}

	public void setIdNews(int idNews) {
		IdNews = idNews;
	}

	public int getIdCategory() {
		return IdCategory;
	}

	public void setIdCategory(int idCategory) {
		IdCategory = idCategory;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescriptiveNews() {
		return DescriptiveNews;
	}

	public void setDescriptiveNews(String descriptiveNews) {
		DescriptiveNews = descriptiveNews;
	}

	public String getDetail() {
		return Detail;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}

	public Date getPostTime() {
		return PostTime;
	}

	public void setPostTime(Date postTime) {
		PostTime = postTime;
	}

	public int getViews() {
		return Views;
	}

	public void setViews(int views) {
		Views = views;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}
	
}
