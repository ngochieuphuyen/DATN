package model.bo;

import java.util.ArrayList;

import model.bean.NewsCategory;
import model.dao.NewsCategoryDao;

public class NewsCategoryBo {
	NewsCategoryDao newsCategoryDao = new NewsCategoryDao();

	public ArrayList<NewsCategory> getListNewCategory() {
		return (ArrayList<NewsCategory>) newsCategoryDao.getListNewCategory();
	}

	public NewsCategory getNewsCategory(int idCategory) {
		return (NewsCategory) newsCategoryDao.getNewsCategory(idCategory);
	}

}
