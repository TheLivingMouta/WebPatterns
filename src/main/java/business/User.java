package business;

import java.util.Objects;

/**
 *
 *
 * @author Brian
 */

public class User {

  private int id;
  private String name;
  private String email;
  private String password;
  private String phone;
  private String firstname;
  private String lastname;

  /**
   * Default constructor
   */
  public User() {
  }

  /**
   * Paramatised constructor
   * @param id
   * @param name
   * @param email
   * @param password
   * @param phone
   * @param firstname
   * @param lastname
   */
  public User(int id, String name, String email, String password, String phone, String firstname, String lastname) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.firstname = firstname;
    this.lastname = lastname;
  }


  /**
   * Get the user ID
   * @return id
   */
  public int getId() {
    return id;
  }

  /**
   *  sets the user id
   * @param id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the username of a user
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * sets the username of a user
   * @param name
   */

  public void setName(String name) {
    this.name = name;
  }

  /**
   * gets the current email of a user
   * @return
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email of a user
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * gets the password of a user
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * sets the password of the user
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * gets the phone number of a user
   * @return
   */
  public String getPhone() {
    return phone;
  }

  /**
   * sets the phone number of a user
   * @param phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * gets the first name of a user
   * @return
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * sets the first name of a user
   * @param firstname
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * gets the last name of a user
   * @return
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * sets the last name of a user
   * @param lastname
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * to string override
   *
   */
  public String toString() {
    return "User{" +
            "Username=" + name +
            ", User ID='" + id + '\'' +
            ", Email=" + email +
            ", phone='" + phone + '\'' +
            ", First name=" + firstname +
            ", Last name=" + lastname +
            '}';
  }

  /**
   * Equals override
   * @param object
   * @return
   */
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    if (!super.equals(object)) return false;
    User users = (User) object;
    return password == users.password;
  }

  /**
   * HashCode Override
   * @return
   */
  @Override
  public int hashCode() {
    return Objects.hash(password);
  }
}

//  public int hashCode() {
//    return Objects.hash(super.hashCode(), id);
//  }
//}


