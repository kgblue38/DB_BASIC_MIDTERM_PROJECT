package net.news;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetArticleTitles.do")
public class ArticleServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");		
		NewsDAO articleDAO = new NewsDAO();
		try {
			req.setAttribute("posts", articleDAO.popArticle());
			RequestDispatcher dispatcher = req.getRequestDispatcher("view.jsp");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
		}
		
		
	}
	
}





