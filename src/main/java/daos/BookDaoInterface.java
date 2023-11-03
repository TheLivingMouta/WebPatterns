package daos;

//@Oran

import exceptions.DaoException;
import business.Book;

import java.util.ArrayList;

/**
 * This interface defines methods for interacting with the book database and the BookDao.
 *
 * @author Oran
 */

public interface BookDaoInterface {

    /**
     * Get all books matching the supplied title exactly.
     *
     * @param title The exact title to search for.
     * @return A list of books matching the title.
     * @throws DaoException If a data access error occurs.
     */

    public ArrayList<Book> selectBooksByTitle(String title) throws DaoException;

    /**
     * Get all books with a title containing the supplied text.
     *
     * @param title The title substring to search for.
     * @return A list of books containing the specified title.
     * @throws DaoException If a data access error occurs.
     */

    public ArrayList<Book> selectBookContainingTitle(String title)throws DaoException;

    /**
     * Get the book matching the specified book author.
     *
     * @param author The author's name to search for.
     * @return A list of books by the specified author.
     * @throws DaoException If a data access error occurs.
     */

    public ArrayList<Book> findBookByAuthor(String author)throws DaoException;

    /**
     * Return all the books in the library.
     *
     * @return A list of all books in the library.
     * @throws DaoException If a data access error occurs.
     */

    public ArrayList<Book> searchAllBooks()throws DaoException;



}

