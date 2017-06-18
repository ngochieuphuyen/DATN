package model.bo;

import java.util.ArrayList;

import model.bean.NewsOfUser;
import model.dao.NewsOfUserDao;

public class NewsOfUserBo {
	NewsOfUserDao newsOfUserDao = new NewsOfUserDao();

	public boolean addNews(NewsOfUser newsOfUser) {
		return (boolean) newsOfUserDao.addNews(newsOfUser);
	}

	public ArrayList<NewsOfUser> getListNewsAccept() {
		return (ArrayList<NewsOfUser>) newsOfUserDao.getListNewsAccept();
	}

	public void deleteNews(int idNewsOfUser) {
		newsOfUserDao.deleteNews(idNewsOfUser);

	}

	public NewsOfUser getNewsOfUser(int idNewsOfUser) {
		return (NewsOfUser) newsOfUserDao.getNewsOfUser(idNewsOfUser);
	}
}
