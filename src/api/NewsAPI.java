package api;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.bean.News;
import model.bo.NewsBo;

@Path("/news")
public class NewsAPI {
	@GET
	@Path("/list")
	@Produces(MediaType.TEXT_PLAIN)
	public String getNewsHot(@Context HttpServletResponse servletResponse) throws IOException, ServletException {
		NewsBo newsBo = new NewsBo();
		ArrayList<News> listNewsHot = newsBo.getlistNewsForAPI(50);
		String result = null;
		ObjectMapper om = new ObjectMapper();
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(listNewsHot);
			// System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GET
	@Path("/detail/{idNews}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getNews(@PathParam("idNews") int idNews, @Context HttpServletResponse servletResponse)
			throws IOException, ServletException {
		NewsBo newsBo = new NewsBo();
		News news = newsBo.getNewsDetail(idNews);
		String result = null;
		ObjectMapper om = new ObjectMapper();
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(news);
			// System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
