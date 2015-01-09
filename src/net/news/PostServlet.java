package net.news;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostNews.do")
public class PostServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("TITLE");
		String writer = req.getParameter("WRITER");
		String content = req.getParameter("CONTENT");
		
		Post post = new Post(title, writer, content);
		NewsDAO postDAO = new NewsDAO();
		try {
			postDAO.insertPost(post);
			
		} catch (SQLException e) {
		
		}
		
		resp.sendRedirect("/");
	}
}
