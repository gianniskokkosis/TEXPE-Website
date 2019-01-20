package texpeclasses;

/**
 * 
 * @author ismgroup35
 */
public class User {

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;

    /**
     * Constructor
     *  
     * @param name
     * @param surname
     * @param username
     * @param email
     * @param password
     */

    public User(String name, String surname, String username, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String emai) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Name = " + name + "|| Surname = " + surname + "|| Username = " + username + "|| Email = " + email;
    }

}
