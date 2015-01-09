package net.news;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetArticleContent.do")
public class ArticleContentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int nid = Integer.parseInt(req.getParameter("ID"));
		NewsDAO articleContentDAO = new NewsDAO();
		try {
			Post articlePost = articleContentDAO.findBynid(nid);
			req.setAttribute("ARTICLE", articlePost);
			RequestDispatcher dispatcher = req.getRequestDispatcher("article.jsp");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
		}
	}
}
