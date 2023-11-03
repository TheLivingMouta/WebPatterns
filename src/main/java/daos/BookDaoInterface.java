package daos;

//@Oran

import exceptions.DaoException;
import business.Book;

import java.util.ArrayList;

public interface BookDaoInterface {

    //    Get all books matching the supplied name exactly.
    public ArrayList<Book> selectBooksByTitle(String title) throws DaoException;

    //    Get all books with a title containing the supplied text.
    public ArrayList<Book> selectBookContainingTitle(String title)throws DaoException;

    //    Get the book matching the specified book Author.
    public ArrayList<Book> findBookByAuthor(String author)throws DaoException;

//    Return all the books in the library
    public ArrayList<Book> searchAllBooks()throws DaoException;



}

