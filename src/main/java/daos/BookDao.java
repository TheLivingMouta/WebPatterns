package daos;

import business.Book;
import exceptions.DaoException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class provides data access methods for interacting with the library database.
 *
 * @author Oran
 */

public class BookDao extends Dao implements BookDaoInterface {

    /**
     * Retrieve a list of books with an exact title match.
     *
     * @param title The exact title to search for.
     * @return A list of books matching the title.
     * @throws DaoException If a data access error occurs.
     */

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

    /**
     * Retrieve a list of books containing the specified title as a substring.
     *
     * @param title The title substring to search for.
     * @return A list of books containing the specified title.
     * @throws DaoException If a data access error occurs.
     */


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

    /**
     * Retrieve a list of books by a specific author.
     *
     * @param author The author's name to search for.
     * @return A list of books by the specified author.
     * @throws DaoException If a data access error occurs.
     */

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

    /**
     * Retrieve a list of all books in the database.
     *
     * @return A list of all books in the database.
     * @throws DaoException If a data access error occurs.
     */

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

    /**
     * Adds a book into the database.
     *
     * @return A list of all books in the database.
     * @throws DaoException If a data access error occurs.
     */
    @Override
    public boolean addBook(Book b) throws DaoException{

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rowsAffected = -1;
        try {
            con = getConnection();

            //language=MySQL
            String query = "INSERT INTO books(bookid, title, date, author, rentaldate) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);

            ps.setInt(1, b.getBookid());
            ps.setString(2, b.getTitle());
            ps.setDate(3, Date.valueOf(b.getDate()));
            ps.setString(4, b.getAuthor());
            ps.setDate(5, Date.valueOf(b.getRentaldate()));

        rowsAffected = ps.executeUpdate();


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
        return rowsAffected > 0;
    }
}



