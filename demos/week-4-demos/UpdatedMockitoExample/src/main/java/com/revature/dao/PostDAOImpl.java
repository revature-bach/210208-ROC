package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Post;

public class PostDAOImpl implements PostDAO {

	@Override
	public List<Post> getPostsByUsername(String username, Connection con) throws SQLException {
		String sql = "SELECT * FROM sql_demo.posts WHERE \"user\" = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, username);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<Post> posts = new ArrayList<>();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String content = rs.getString("content");
			
			Post post = new Post(id, content);
			
			posts.add(post);
		}
		
		return posts;
	}

	@Override
	public Post insertPost(Post post, Connection con, String username) throws SQLException {
		String sql = "INSERT INTO sql_demo.posts (content, \"user\") VALUES (?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		pstmt.setString(1, post.getContent());
		pstmt.setString(2, username);
		
		int count = pstmt.executeUpdate();
		
		if (count != 1) {
			throw new SQLException("Did not successfully insert Post " + post);
		}
		
		// Retrieve auto generated ID, and set it on our Post object
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			post.setId(id);
		}
		
		// return post object
		return post;
	}

}
