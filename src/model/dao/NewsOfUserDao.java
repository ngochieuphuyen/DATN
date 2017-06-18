package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import conn.ConnectionUtils;
import model.bean.News;
import model.bean.NewsOfUser;

public class NewsOfUserDao {
	Connection conn = ConnectionUtils.getConnection();

	public boolean addNews(NewsOfUser newsOfUser) {
		String sql = "insert into NewsOfUser(IdCategory, IdAccount, Title, Descriptive, Detail, PostTime) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newsOfUser.getIdCategory());
			ps.setInt(2, newsOfUser.getIdAccount());
			ps.setNString(3, newsOfUser.getTitle());
			ps.setNString(4, newsOfUser.getDescriptive());
			ps.setNString(5, newsOfUser.getDetail());
			Calendar rightNow = Calendar.getInstance();
			String dateCurrent = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
					+ rightNow.get(Calendar.DAY_OF_MONTH);
			java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
			ps.setDate(6, date.valueOf(dateCurrent));
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<NewsOfUser> getListNewsAccept() {
		ArrayList<NewsOfUser> listNewsOfUser = new ArrayList<>();
		String sql = "select IdNewsOfUser, Title, PostTime, IdAccount from NewsOfUser order by PostTime DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NewsOfUser newsOfUser = new NewsOfUser();
				newsOfUser.setIdNewsOfUser(rs.getInt("IdNewsOfUser"));
				newsOfUser.setTitle(rs.getString("Title"));
				newsOfUser.setPostTime(rs.getDate("PostTime"));
				newsOfUser.setIdAccount(rs.getInt("IdAccount"));
				listNewsOfUser.add(newsOfUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNewsOfUser;
	}

	public void deleteNews(int idNewsOfUser) {
		String sql = "delete from NewsOfUser where IdNewsOfUser = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idNewsOfUser);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted news");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NewsOfUser getNewsOfUser(int idNewsOfUser) {
		NewsOfUser newsOfUser = new NewsOfUser();
		String sql = "select Title, Descriptive, Detail, PostTime, IdAccount, IdCategory from NewsOfUser where IdNewsOfUser =" + idNewsOfUser;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				newsOfUser.setIdNewsOfUser(idNewsOfUser);
				newsOfUser.setTitle(rs.getString("Title"));
				newsOfUser.setDescriptive(rs.getString("Descriptive"));
				newsOfUser.setDetail(rs.getString("Detail"));
				newsOfUser.setPostTime(rs.getDate("PostTime"));
				newsOfUser.setIdAccount(rs.getInt("IdAccount"));
				newsOfUser.setIdCategory(rs.getInt("IdCategory"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsOfUser;
	}

}
