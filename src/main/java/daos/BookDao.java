package daos;

import business.Book;
import exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookDao extends Dao implements BookDaoInterface{

    @Override
    public ArrayList<Book> selectBooksByTitle(String title) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList<>();

        try {
            con = getConnection();

            //language=MySQL
            String query = "SELECT * FROM books WHERE title = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            rs = ps.executeQuery();

            while (rs.next()) {
                int bookid = rs.getInt("bookid");
                title = rs.getString("title");
                LocalDate date = rs.getDate("date").toLocalDate();
                String author = rs.getString("author");
                LocalDate rentaldate = rs.getDate("rentaldate").toLocalDate();

                Book b = new Book(bookid, title, date, author, rentaldate);
                books.add(b);
            }

        } catch (SQLException e) {
            throw new DaoException("selectBooksByTitle(): " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("selectBooksByTitle(): " + e.getMessage());
            }
        }
        return books;
    }

    @Override
    public ArrayList<Book> selectBookContainingTitle(String title) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList<>();

        try {
            con = getConnection();

            //language=MySQL
            String query = "SELECT * FROM books WHERE title like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + title + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                int bookid = rs.getInt("bookid");
                title = rs.getString("title");
                LocalDate date = rs.getDate("date").toLocalDate();
                String author = rs.getString("author");
                LocalDate rentaldate = rs.getDate("rentaldate").toLocalDate();

                Book b = new Book(bookid, title, date, author, rentaldate);
                books.add(b);
            }

        } catch (SQLException e) {
            throw new DaoException("selectBooksByTitle(): " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("selectBooksByTitle(): " + e.getMessage());
            }
        }
        return books;
    }


    @Override
    public ArrayList<Book> findBookByAuthor(String author) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList<>();

        try {
            con = getConnection();

            //language=MySQL
            String query = "SELECT * FROM books WHERE author = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, author);
            rs = ps.executeQuery();

            while (rs.next()) {
                int bookid = rs.getInt("bookid");
                String title = rs.getString("title");
                LocalDate date = rs.getDate("date").toLocalDate();
                author = rs.getString("author");
                LocalDate rentaldate = rs.getDate("rentaldate").toLocalDate();

                Book b = new Book(bookid, title, date, author, rentaldate);
                books.add(b);
            }

        } catch (SQLException e) {
            throw new DaoException("findBookByAuthor(): " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findBookByAuthor(): " + e.getMessage());
            }
        }
        return books;
    }

    @Override
    public ArrayList<Book> searchAllBooks() throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList<>();

        try {
            con = getConnection();

            //language=MySQL
            String query = "SELECT * FROM books";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int bookid = rs.getInt("bookid");
                String title = rs.getString("title");
                LocalDate date = rs.getDate("date").toLocalDate();
                String author = rs.getString("author");
                LocalDate rentaldate = rs.getDate("rentaldate").toLocalDate();

                Book b = new Book(bookid, title, date, author, rentaldate);
                books.add(b);
            }

        } catch (SQLException e) {
            throw new DaoException("selectBooksByTitle(): " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("selectBooksByTitle(): " + e.getMessage());
            }
        }
        return books;
    }

}

