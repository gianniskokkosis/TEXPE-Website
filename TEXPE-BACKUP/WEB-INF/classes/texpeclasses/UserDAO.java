package texpeclasses;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import exceptionstexpe.UserNotFoundApplicationException;


/**
 *  UserDAO provides all the necessary methods related to users.
 *  @author ismgroup35
 */
public class UserDAO {

    public void registerUser(User user) throws Exception {

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt1 = null;
        String sql = "INSERT INTO users(name,surname,username,email,password) VALUES(?,?,?,?,?);";

        try {
            con = db.getConnection();
            stmt1 = con.prepareStatement(sql);
            stmt1.setString(1, user.getName());
            stmt1.setString(2, user.getSurname());
            stmt1.setString(3, user.getUsername());
            stmt1.setString(4, user.getEmail());
            stmt1.setString(5, user.getPassword());
            stmt1.executeUpdate();
            stmt1.close();
        } catch (Exception e) {
            System.out.println("An error occured while getting users from database: " + e.getMessage());
        } finally {
            try {
                stmt1.close();
                db.close();
            } catch (Exception e) {

            }
        }
    }


    /**
     * Checks if the credentials are valid in the database, if yes then returns the User Object. Otherwise throws Exceptions
     * 
     * @param username, String
     * @param password, String
     * @return User, The User object
     * @throws UserNotFoundApplicationException, Exception.
     *          UserNotFoundApplicationExceptionLesson8: if the credentials are not valid.
     *          Exception: if any other error occured.
     */

    public User authenticate(String username, String password) 
		throws UserNotFoundApplicationException, Exception {

		Connection con = null;
		
		String sqlquery= "SELECT * FROM users WHERE username=? AND password=?;";
		
		DB db = new DB();
				
		try {
					
			con = db.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sqlquery);
			
			stmt.setString( 1, username );
			stmt.setString( 2, password );
			
			ResultSet rs = stmt.executeQuery();
			
            //if there is nothing in the result set give Wrong Credentials message
			if( !rs.next() ) {
				
				rs.close();
				stmt.close();
				
				throw new UserNotFoundApplicationException("Wrong Credentials!");
				
			}
			
			User user = new User( rs.getString("name"),
							rs.getString("surname"),
							rs.getString("username"),
							rs.getString("email"),
							rs.getString("password") );				
			
			rs.close();
			stmt.close();			
			
			return user;
			
		} catch (UserNotFoundApplicationException e) {
			
			throw new UserNotFoundApplicationException( e.getMessage() ); 
		
		} catch (Exception e) {
			
			throw new Exception("Error while trying to authenticate User: " + e.getMessage());
			
		} finally {
			
			try {
				db.close(); //closing connection
			} catch (Exception e) {				
				//no need to do anything...
			}
			
		}		
		
	}

    public User findUser(String username) throws Exception {

        DB db = new DB();
        User user = null;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement stmt3 = null;
        String sql = "SELECT * FROM users WHERE username = ?;";

        try {
            con = db.getConnection();
            stmt3 = con.prepareStatement(sql);
            stmt3.setString(1, username);
            rs = stmt3.executeQuery();
            while (rs.next()) {
                user = new User(rs.getString("name"),
                        rs.getString("surname"), rs.getString("email"), rs.getString("username"), rs.getString("password"));
            }
            return user;
        } catch (Exception e) {
            System.out.println("An error occured while getting users from database: " + e.getMessage());
        } finally {
            try {
                rs.close();
                stmt3.close();
                db.close();
            } catch (Exception e) {

            }
        }

        return null;
    }
	
	public void authenticate_email(String email) throws Exception {

        DB db = new DB();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement stmt4 = null;
        String sql = "SELECT email FROM users WHERE email = ?;";

        try {
            if (rs.next()) {
                con = db.getConnection();
                stmt4 = con.prepareStatement(sql);
                stmt4.setString(1, email);
                rs = stmt4.executeQuery();
            } else {
                throw new Exception("Wrong email");
            }
        } catch (Exception e) {
            System.out.println("An error occured while getting users from database: " + e.getMessage());
        } finally {
            try {
                rs.close();
                stmt4.close();
                db.close();
            } catch (Exception e) {

            }
        }

    }
}
