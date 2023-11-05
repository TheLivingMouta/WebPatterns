package apps;

import business.Book;
import business.User;
import daos.BookDao;
import daos.BookDaoInterface;
import daos.UserDao;
import daos.UserDaoInterface;
import exceptions.DaoException;

import java.time.LocalDate;
import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) throws DaoException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Username");
        String username = sc.nextLine();

        System.out.println("Enter a password");
        String password = sc.nextLine();
        System.out.println("Enter your email");
        String email = sc.nextLine();

        System.out.println("Enter your phone number");
        String phonenumber = sc.nextLine();

        System.out.println("Enter your First name");
        String firstname = sc.nextLine();

        System.out.println("Enter your Last name");
        String lastname = sc.nextLine();

        System.out.println("Enter an ID");
        int userId = sc.nextInt();
        addUser(username, password, userId, email, phonenumber, firstname, lastname);

    }

    public static void addUser(String username, String password, int id, String email, String phone, String firstname, String lastname) throws DaoException {

        System.out.println("ADDING USER...");

        try{
            UserDaoInterface dao = new UserDao();
            User u = new User(id, username, email, password, phone, firstname, lastname);

            boolean rowsAffected = dao.addUser(u);

            if(!rowsAffected){
                System.out.println("USER WAS UNABLE TO BE ADDED");
            } else {
                System.out.println("USER WAS SUCCESSFULLY ADDED" + u);
            }

        } catch (DaoException e) {
            System.out.println("ERROR " + e.getMessage());
        }

    }

}
