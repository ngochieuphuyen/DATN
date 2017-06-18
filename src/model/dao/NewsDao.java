package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import conn.ConnectionUtils;
import model.bean.News;

public class NewsDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<News> getlistNews() {
		ArrayList<News> listNews = new ArrayList<>();
		String sql = "select IdNews, Title, PostTime, Views from News order by PostTime DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setIdNews(rs.getInt("IdNews"));
				// news.setIdCategory(rs.getInt("IdCategory"));
				news.setTitle(rs.getString("Title"));
				// news.setDescriptiveNews(rs.getString("DescriptiveNews"));
				// news.setDetail(rs.getString("Detail"));
				news.setPostTime(rs.getDate("PostTime"));
				news.setViews(rs.getInt("Views"));
				listNews.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNews;
	}

	public boolean addNews(News news) {
		String sql = "insert into News(IdCategory, Title, Descriptive, Detail, Image, PostTime, Views) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, news.getIdCategory());
			ps.setNString(2, news.getTitle());
			ps.setNString(3, news.getDescriptiveNews());
			ps.setNString(4, news.getDetail());
			ps.setBinaryStream(5, null);
			Calendar rightNow = Calendar.getInstance();
			String dateCurrent = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
					+ rightNow.get(Calendar.DAY_OF_MONTH);
			java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
			ps.setDate(6, date.valueOf(dateCurrent));
			ps.setInt(7, 0);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getIdNewsCreated() {
		String sql = "select top 1 IdNews from News order by IdNews DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("IdNews");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public News getNews(int idNews) {
		News news = new News();
		String sql = "select Title, Descriptive, Detail, PostTime, Views from News where IdNews =" + idNews;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				news.setIdNews(idNews);
				// news.setIdCategory(rs.getInt("IdCategory"));
				news.setTitle(rs.getString("Title"));
				news.setDescriptiveNews(rs.getString("Descriptive"));
				news.setDetail(rs.getString("Detail"));
				news.setPostTime(rs.getDate("PostTime"));
				news.setViews(rs.getInt("Views"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return news;
	}

	public boolean updateNews(News news) {
		String sql = "update News set IdCategory=?, Title=?, Descriptive=?, Detail=? where IdNews=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, news.getIdCategory());
			ps.setString(2, news.getTitle());
			ps.setString(3, news.getDescriptiveNews());
			ps.setString(4, news.getDetail());
			ps.setInt(5, news.getIdNews());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deleteNews(int idNews) {
		String sql = "delete from News where IdNews = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idNews);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted news");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean increaseView(int idNews) {
		String sql = "update News set Views= Views +1 where IdNews=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idNews);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<News> getListEvent(int top) {
		ArrayList<News> listNews = new ArrayList<>();
		String sql = "select top " + top
				+ " IdNews, Title, PostTime, Descriptive from News where IdCategory =1 order by PostTime DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setIdNews(rs.getInt("IdNews"));
				// news.setIdCategory(rs.getInt("IdCategory"));
				news.setTitle(rs.getString("Title"));
				news.setDescriptiveNews(rs.getString("Descriptive"));
				// news.setDetail(rs.getString("Detail"));
				news.setPostTime(rs.getDate("PostTime"));
				// news.setViews(rs.getInt("Views"));
				listNews.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNews;
	}

	public ArrayList<News> getNotification(int top) {
		ArrayList<News> listNews = new ArrayList<>();
		String sql = "select top " + top
				+ " IdNews, Title, PostTime, Descriptive from News where IdCategory =2 order by PostTime DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setIdNews(rs.getInt("IdNews"));
				// news.setIdCategory(rs.getInt("IdCategory"));
				news.setTitle(rs.getString("Title"));
				news.setDescriptiveNews(rs.getString("Descriptive"));
				// news.setDetail(rs.getString("Detail"));
				news.setPostTime(rs.getDate("PostTime"));
				// news.setViews(rs.getInt("Views"));
				listNews.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNews;
	}

	public ArrayList<News> getScholarship(int top) {
		ArrayList<News> listNews = new ArrayList<>();
		String sql = "select top " + top
				+ " IdNews, Title, PostTime, Descriptive from News where IdCategory =3 order by PostTime DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setIdNews(rs.getInt("IdNews"));
				// news.setIdCategory(rs.getInt("IdCategory"));
				news.setTitle(rs.getString("Title"));
				news.setDescriptiveNews(rs.getString("Descriptive"));
				// news.setDetail(rs.getString("Detail"));
				news.setPostTime(rs.getDate("PostTime"));
				// news.setViews(rs.getInt("Views"));
				listNews.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNews;
	}

	public ArrayList<News> getRecruitment(int top) {
		ArrayList<News> listNews = new ArrayList<>();
		String sql = "select top " + top
				+ " IdNews, Title, PostTime, Descriptive from News where IdCategory =4 order by PostTime DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setIdNews(rs.getInt("IdNews"));
				// news.setIdCategory(rs.getInt("IdCategory"));
				news.setTitle(rs.getString("Title"));
				news.setDescriptiveNews(rs.getString("Descriptive"));
				// news.setDetail(rs.getString("Detail"));
				news.setPostTime(rs.getDate("PostTime"));
				// news.setViews(rs.getInt("Views"));
				listNews.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNews;
	}

	public ArrayList<News> getNewsHot(int top) {
		ArrayList<News> listNews = new ArrayList<>();
		String sql = "select top " + top + " IdNews, Title, PostTime from News order by PostTime DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setIdNews(rs.getInt("IdNews"));
				// news.setIdCategory(rs.getInt("IdCategory"));
				news.setTitle(rs.getString("Title"));
				// news.setDescriptiveNews(rs.getString("DescriptiveNews"));
				// news.setDetail(rs.getString("Detail"));
				news.setPostTime(rs.getDate("PostTime"));
				// news.setViews(rs.getInt("Views"));
				listNews.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNews;
	}

	public ArrayList<News> getListNewsWithCategory(int idCategory, int top) {
		ArrayList<News> listNews = new ArrayList<>();
		String sql = "select top " + top + " IdNews, Title, PostTime, Descriptive from News where IdCategory="
				+ idCategory + " order by PostTime DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setIdNews(rs.getInt("IdNews"));
				// news.setIdCategory(rs.getInt("IdCategory"));
				news.setTitle(rs.getString("Title"));
				 news.setDescriptiveNews(rs.getString("Descriptive"));
				// news.setDetail(rs.getString("Detail"));
				news.setPostTime(rs.getDate("PostTime"));
				// news.setViews(rs.getInt("Views"));
				listNews.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNews;
	}

	public ArrayList<News> getlistNewsForAPI(int top) {
		ArrayList<News> listNews = new ArrayList<>();
		String sql = "select top " + top
				+ " IdNews, Title, PostTime, Views from News order by PostTime DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setIdNews(rs.getInt("IdNews"));
				news.setTitle(rs.getString("Title"));
				news.setPostTime(rs.getDate("PostTime"));
				 news.setViews(rs.getInt("Views"));
				listNews.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNews;
	}

	public void addNewsFromUser(News news) {
		String sql = "insert into News(IdCategory, Title, Descriptive, Detail, Image, PostTime, Views) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, news.getIdCategory());
			ps.setNString(2, news.getTitle());
			ps.setNString(3, news.getDescriptiveNews());
			ps.setNString(4, news.getDetail());
			ps.setBinaryStream(5, null);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String postTime = format.format(news.getPostTime());
			java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
			ps.setDate(6, date.valueOf(postTime));
			ps.setInt(7, 0);
			if (ps.executeUpdate() > 0)
				System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
