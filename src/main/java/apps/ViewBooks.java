package apps;

//@Oran

import business.Book;
import daos.BookDao;
import daos.BookDaoInterface;
import exceptions.DaoException;

import java.util.List;
import java.util.Scanner;

public class ViewBooks {
    public static void main(String[] args) throws DaoException {
        Scanner sc = new Scanner(System.in);
        System.out.println("How would you like to search?\nPlease press the corresponding button");
        System.out.println("1) Title");
        System.out.println("2) Author");
       int option = sc.nextInt();

        if(option == 1) {
            System.out.print("Enter book title: ");
            sc.nextLine();
            String title = sc.nextLine();
            selectBooksByTitle(title);
        }

        if(option == 2) {
            System.out.println("Enter book author: ");
            sc.nextLine();
            String author = sc.nextLine();
            findBookByAuthor(author);
        }

    }
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

    public static void findBookByAuthor(String author)throws DaoException{
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
}

