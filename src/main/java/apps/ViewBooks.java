package apps;

import business.Book;
import daos.BookDao;
import daos.BookDaoInterface;
import exceptions.DaoException;

import java.util.List;
import java.util.Scanner;

/**
 * This class provides a command-line interface for searching books in a library.
 *
 * @author Oran
 */
public class ViewBooks {
    /**
     * The main method for viewing the details of all books in the library
     *
     * @param args Command-line arguments (not used).
     * @throws DaoException If a data access error occurs.
     */
    public static void main(String[] args) throws DaoException {
        Scanner sc = new Scanner(System.in);
        System.out.println("How would you like to search?\nPlease press the corresponding button");
        System.out.println("1) Title");
        System.out.println("2) Author");
        System.out.println("3) View all books");
        int option = sc.nextInt();

        if (option == 1) {
            System.out.print("Enter book title: ");
            sc.nextLine();
            String title = sc.nextLine();
            selectBooksByTitle(title);
        }

        if (option == 2) {
            System.out.println("Enter book author: ");
            sc.nextLine();
            String author = sc.nextLine();
            findBookByAuthor(author);
        }
        if (option == 3) {
            searchAllBooks();
        }
    }

    /**
     * Search for books by their exact title.
     *
     * @param title The title of the book to search for.
     * @throws DaoException If a data access error occurs.
     */
    public static void selectBooksByTitle(String title) throws DaoException {
        try {
            BookDaoInterface dao = new BookDao();

            List<Book> books = dao.selectBooksByTitle(title);
            if (books.isEmpty()) {
                System.out.println("There are no books with the title: " + title + " here are some suggestions:");
                selectBookContainingTitle(title);
            } else {
                for (Book b : books) {
                    System.out.println(b);
                }
            }
        } catch (DaoException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    /**
     * Search for books containing a given title as a substring.
     *
     * @param title The title substring to search for.
     * @throws DaoException If a data access error occurs.
     */
    public static void selectBookContainingTitle(String title) throws DaoException {
        try {
            BookDaoInterface dao = new BookDao();

            List<Book> books = dao.selectBookContainingTitle(title);
            if (books.isEmpty()) {
                System.out.println("Unfortunately no suggestions matching: " + title);
            } else {
                for (Book b : books) {
                    System.out.println(b);
                }
            }
        } catch (DaoException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    /**
     * Search for books by a specific author.
     *
     * @param author The author's name to search for.
     * @throws DaoException If a data access error occurs.
     */
    public static void findBookByAuthor(String author) throws DaoException {
        try {
            BookDaoInterface dao = new BookDao();

            List<Book> books = dao.findBookByAuthor(author);
            if (books.isEmpty()) {
                System.out.println("There are no books with the author: " + author);
            } else {
                for (Book b : books) {
                    System.out.println(b);
                }
            }
        } catch (DaoException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    /**
     * Display all books in the library.
     *
     * @throws DaoException If a data access error occurs.
     */
    public static void searchAllBooks() throws DaoException {
        try {
            BookDaoInterface dao = new BookDao();

            List<Book> books = dao.searchAllBooks();
            if (books.isEmpty()) {
                System.out.println("There are no books in the library");
            } else {
                for (Book b : books) {
                    System.out.println(b);
                }
            }
        } catch (DaoException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
