package texpeclasses;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.lang.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 

import texpeclasses.*;
 



/**
 *  IncomeDAO provides all the necessary methods related to user's income.
 *  @author ismgroup35
 */
public class IncomeDAO{

    //that method saves the income o a specific user!
    public void saveIncome(Income inc) throws Exception{

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt1 = null;
        String sql = "INSERT INTO income(incomeDate,incomeAmount,incomeCategory,incomeDescription,username) VALUES (?,?,?,?,?);";
        try {
            con = db.getConnection();
            stmt1 = con.prepareStatement(sql);
            stmt1.setString(1, inc.getIncomeDate());
            stmt1.setFloat(2, inc.getIncomeAmount());
            stmt1.setString(3, inc.getIncomeCategory());
            stmt1.setString(4,inc.getIncomeDescription());
            stmt1.setString(5,inc.getUsername());
            stmt1.executeUpdate();
        } catch (Exception e) {
           throw new Exception("An error occured while getting user's income from the database: " + e.getMessage());
        }finally{
            try {
                stmt1.close();
                db.close();
            } catch (Exception e) {
                //Dosen't need to do anything
            }

        }
    }

    // that method returns today's sum of income.

    public float sumTodayIncome (User user, String td) throws Exception {


        Connection con = null;
        DB db = new DB();    
        ResultSet rs = null;
        String sql = "SELECT incomeAmount FROM income WHERE username = ? AND incomeDate = ?";
        try {


            con = db.getConnection();
            PreparedStatement stmt2 = con.prepareStatement(sql);
            stmt2.setString(1,user.getUsername());
            stmt2.setString(2,td);


            // execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
            rs = stmt2.executeQuery();

            float sum = 0;

            while (rs.next()) {

                sum = rs.getFloat("income.incomeAmount") + sum;

            }

            rs.close(); //closing ResultSet
            stmt2.close(); //closing PreparedStatement
            return sum;

        } catch (Exception e) {
            throw new Exception("An error occured while getting user's income from the database: " + e.getMessage());
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                //Dosen't need to do anything
            }
        }

    }
}