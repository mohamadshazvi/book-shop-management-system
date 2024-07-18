package guiprogramming.bookshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {
	
	private BookDatabase database;
	
	public BookDao() {
		
		database = new BookDatabase(); 
		
	}
	
	public void insertBook(Book book) {
		
		final String INSERT_BOOK_SQL="insert into tablebook"+
		"(authorname,bookname,edition,price)values"+"(?,?,?,?);";
		
		Connection con = database.getDatabseConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_BOOK_SQL);
			
			ps.setString(1, book.getAuthorName());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getEditionYear());
			ps.setString(4, book.getBookPrice());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void updateBook(Book book) {
		
		
		
		try {
			
			final String UPDATE_BOOK_SQL="update tablebook set authorname=?,bookname=?,edition=?,price=?where id=?";
			
			Connection con = database.getDatabseConnection();
			
			
			PreparedStatement ps = con.prepareStatement(UPDATE_BOOK_SQL);
			
			ps.setString(1, book.getAuthorName());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getEditionYear());
			ps.setString(4, book.getBookPrice());
			ps.setInt(5, book.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	public void deleteBook(Book book) {
	    final String DELETE_BOOK_SQL = "DELETE FROM tablebook WHERE id=?";
	    try (Connection con = database.getDatabseConnection();
	         PreparedStatement ps = con.prepareStatement(DELETE_BOOK_SQL)) {
	        
	        ps.setInt(1, book.getId());
	        int result = ps.executeUpdate();
	        if (result == 0) {
	            System.out.println("No book found with the given ID.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	
	
	
	public ResultSet loadTableData() {
		
		final String ALL_BOOKDETAILS_SQL="select * from tablebook";
		
		Connection con = database.getDatabseConnection();
		
		PreparedStatement ps;
		ResultSet rs=null;
		
		
		try {
			ps = con.prepareStatement(ALL_BOOKDETAILS_SQL);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
		
		
		
	}
	
	
	
}
		
		