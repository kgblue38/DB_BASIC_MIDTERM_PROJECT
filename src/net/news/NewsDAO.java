package net.news;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewsDAO extends HttpServlet {
	
	public Connection getConnection() {
		String url = "jdbc:mysql://192.168.56.101:3306/NewsSite";
		String id = "dohyung";
		String pw = "intech7749";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void insertPost(Post post) throws SQLException {
		String sql = "insert into news(title,content,writer,creation) values(?,?,?,?)";
				
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setString(3, post.getWriter());
			pstmt.setString(4, post.getCreation());
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public ArrayList<Post> popArticle() throws SQLException {
		String sql = "select * from news";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery();
			
			ArrayList<Post> arrayPost = new ArrayList<Post>();
			while(rs.next()) {
				Post tmpPost = new Post(rs.getString("title"), rs.getString("writer"), rs.getString("content"), rs.getInt("nid"));
				arrayPost.add(tmpPost);
			}
			return arrayPost;
		} finally {
			if (rs != null) {
				rs.close();
			}
			
			if (pstmt != null) {
				pstmt.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public Post findBynid(int nid) throws SQLException {
		String sql = "select * from news where nid = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, nid);
			
			rs = pstmt.executeQuery();
			
			if (!rs.next()) {
				return null;
			}
			
			return new Post(
					rs.getString("title"),
					rs.getString("writer"),
					rs.getString("content"),
					rs.getInt("nid"));
		} finally {
			if (rs != null) {
				rs.close();
			}
			
			if (pstmt != null) {
				pstmt.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		}
		
	}
	
}
