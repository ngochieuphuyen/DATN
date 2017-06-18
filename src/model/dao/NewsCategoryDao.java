package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.NewsCategory;

public class NewsCategoryDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<NewsCategory> getListNewCategory() {
		ArrayList<NewsCategory> listNewsCategory = new ArrayList<>();
		String sql = "select IdCategory, CategoryName from Categories";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NewsCategory newsCategory = new NewsCategory();
				newsCategory.setIdNewsCategory(rs.getInt("IdCategory"));
				newsCategory.setNewsCategoryName(rs.getString("CategoryName"));
				// newsCategory.setDescriptiveNewsCategory(rs.getString("DescriptiveCategory"));
				listNewsCategory.add(newsCategory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNewsCategory;
	}

	public NewsCategory getNewsCategory(int idCategory) {
		String sql = "select CategoryName from Categories where IdCategory =" + idCategory;
		NewsCategory newsCategory = new NewsCategory();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// newsCategory.setIdNewsCategory(rs.getInt("IdCategory"));
				newsCategory.setNewsCategoryName(rs.getString("CategoryName"));
				// newsCategory.setDescriptiveNewsCategory(rs.getString("DescriptiveCategory"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsCategory;
	}

}
