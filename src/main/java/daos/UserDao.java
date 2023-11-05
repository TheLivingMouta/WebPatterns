package daos;


import business.Book;
import business.User;
import exceptions.DaoException;

import java.sql.*;
import java.util.ArrayList;

public class UserDao extends Dao implements UserDaoInterface{

    /**
     * Gets all users
     * @return an array list of all users
     * @throws DaoException
     */
    @Override
        public ArrayList<User> getAllUsers() throws DaoException {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            ArrayList<User> users = new ArrayList<>();

            try {
                con = getConnection();

                //language=MySQL
                String query = "SELECT * FROM users";
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    int userid = rs.getInt("id");
                    String username = rs.getString("name");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    String phonenumber = rs.getString("phone");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");

                    User u = new User(userid, username, password, email, phonenumber, firstname, lastname);
                    users.add(u);
                }

            } catch (SQLException e) {
                throw new DaoException("getAllUsers(): " + e.getMessage());
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
                    throw new DaoException("getAllUsers(): " + e.getMessage());
                }
            }
            return users;

    }

    /**
     * Gets a users by their username
     * @param name the username of the user
     * @return An array list of information about the user
     * @throws DaoException
     */
    @Override
    public ArrayList<User> getUserByUsername(String name) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            con = getConnection();

            //language=MySQL
            String query = "SELECT * FROM users WHERE name = ?";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int userid = rs.getInt("id");
                String username = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phonenumber = rs.getString("phone");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");

                User u = new User(userid, username, password, email,phonenumber, firstname, lastname);
                users.add(u);
            }

        } catch (SQLException e) {
            throw new DaoException("getUserByUsername(): " + e.getMessage());
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
                throw new DaoException("getUserByUsername(): " + e.getMessage());
            }
        }
        return users;

    }

    /**
     * Gets a users by their ID
     * @param id the ID of the user
     * @return Information of the user
     * @throws DaoException
     */
    @Override
    public ArrayList<User> getUserById(int id) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            con = getConnection();

            //language=MySQL
            String query = "SELECT * FROM users WHERE id = ?";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int userid = rs.getInt("id");
                String username = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phonenumber = rs.getString("phone");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");

                User u = new User(userid, username, password, email, phonenumber, firstname, lastname);
                users.add(u);
            }

        } catch (SQLException e) {
            throw new DaoException("getUserById(): " + e.getMessage());
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
                throw new DaoException("getUserById(): " + e.getMessage());
            }
        }
        return users;

    }

    /**
     * Get a user by their phone number
     * @param phone the phone number of the user
     * @return the phone number of the user
     * @throws DaoException
     */
    @Override
    public ArrayList<User> getUserByPhone(String phone) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            con = getConnection();

            //language=MySQL
            String query = "SELECT * FROM users WHERE phone = ?";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int userid = rs.getInt("id");
                String username = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phonenumber = rs.getString("phone");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");

                User u = new User(userid, username, password, email, phonenumber, firstname, lastname);
                users.add(u);
            }

        } catch (SQLException e) {
            throw new DaoException("getUserByPhone(): " + e.getMessage());
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
                throw new DaoException("getUserByPhone(): " + e.getMessage());
            }
        }
        return users;

    }

    @Override
    public boolean addUser(User u) throws DaoException{

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rowsAffected = -1;
        try {
            con = getConnection();

            //language=MySQL
            String query = "INSERT INTO users(id, name, password, email, phone, firstname, lastname) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);

            ps.setInt(1, u.getId());
            ps.setString(2, u.getName());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getFirstname());
            ps.setString(6, u.getLastname());

            rowsAffected = ps.executeUpdate();


        } catch (SQLException e) {
            throw new DaoException("addUser: " + e.getMessage());
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
                throw new DaoException("addUser: " + e.getMessage());
            }
        }
        return rowsAffected > 0;
    }

}
