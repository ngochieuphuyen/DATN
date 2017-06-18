package model.bo;

import java.util.ArrayList;
import model.bean.News;
import model.bean.NewsOfUser;
import model.dao.NewsDao;

public class NewsBo {
	NewsDao newsDao = new NewsDao();

	public ArrayList<News> getlistNews() {
		return (ArrayList<News>) newsDao.getlistNews();
	}

	public boolean addNews(News news) {
		news.setViews(0);
		return (boolean) newsDao.addNews(news);
	}

	public int getIdNewsCreated() {
		return (int) newsDao.getIdNewsCreated();
	}

	public News getNews(int idNews) {
		return (News) newsDao.getNews(idNews);
	}

	public boolean updateNews(News news) {
		return (boolean) newsDao.updateNews(news);
	}

	public void deleteNews(int idNews) {
		AccountOfNewsBo accountOfNewsBo = new AccountOfNewsBo();
		while (accountOfNewsBo.checkAccountOfNews(idNews)) {
			int idAccountOfNews = accountOfNewsBo.getIdAccountOfNews(idNews);
			accountOfNewsBo.deleteAccountOfNewsWithIDKey(idAccountOfNews);
		}
		newsDao.deleteNews(idNews);

	}

	public News getNewsDetail(int idNews) {

		if (newsDao.increaseView(idNews)) {
			return newsDao.getNews(idNews);
		}
		return null;
	}

	public ArrayList<News> getListEvent(int top) {
		return (ArrayList<News>) newsDao.getListEvent(top);
	}

	public ArrayList<News> getNotification(int top) {
		return (ArrayList<News>) newsDao.getNotification(top);
	}

	public ArrayList<News> getScholarship(int top) {
		return (ArrayList<News>) newsDao.getScholarship(top);
	}

	public ArrayList<News> getRecruitment(int top) {
		return (ArrayList<News>) newsDao.getRecruitment(top);
	}

	public ArrayList<News> getNewsHot(int top) {
		return (ArrayList<News>) newsDao.getNewsHot(top);
	}

	public ArrayList<News> getListNewsWithCategory(int idCategory, int top) {
		return (ArrayList<News>) newsDao.getListNewsWithCategory(idCategory, top);
	}

	public ArrayList<News> getlistNewsForAPI(int top) {
		return (ArrayList<News>) newsDao.getlistNewsForAPI(top);
	}

	public void acceptNews(int idNewsOfUser) {
		NewsOfUserBo newsOfUserBo = new NewsOfUserBo();
		NewsOfUser newsOfUser = newsOfUserBo.getNewsOfUser(idNewsOfUser);
		newsOfUserBo.deleteNews(idNewsOfUser);
		News news = new News();
		news.setTitle(newsOfUser.getTitle());
		news.setDescriptiveNews(newsOfUser.getDescriptive());
		news.setDetail(newsOfUser.getDetail());
		news.setPostTime(newsOfUser.getPostTime());
		news.setIdCategory(newsOfUser.getIdCategory());
		// check add news for user
		newsDao.addNewsFromUser(news);
		int idNews = getIdNewsCreated();
		AccountOfNewsBo accountOfNewsBo = new AccountOfNewsBo();
		accountOfNewsBo.addAccountOfNews(newsOfUser.getIdAccount(), idNews);
		
	}

}
