package net.news;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	private String title;
	private String writer;
	private String content;
	private String creation;
	private int nid;
	
	public Post(String title, String writer, String content){
		this(title,writer,content, 0);
	}
	
	public Post(String title, String writer, String content, int nid){
		this.title = title;
		this.writer = writer;
		this.content = content;
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.creation = dayTime.format(new Date(time));
		this.nid = nid;
	}
	
	public int getNid() {
		return nid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getCreation() {
		return creation;
	}
	
}