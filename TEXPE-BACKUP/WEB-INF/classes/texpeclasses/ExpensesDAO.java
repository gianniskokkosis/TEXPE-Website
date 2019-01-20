package texpeclasses;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.lang.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 

import texpeclasses.*;
 

/**
 *  IncomeDAO provides all the necessary methods related to user's Expenses.
 *  @author ismgroup35
 */
public class ExpensesDAO{

    //that method saves the Expenses o a specific user!
    public void saveExpenses(Expenses exp) throws Exception{

        DB db = new DB();
        Connection con = null;
        PreparedStatement stmt1 = null;
        String sql = "INSERT INTO expenses(expDate,expAmount,expCategory,expDescription,username) VALUES (?,?,?,?,?);";
        try {
            con = db.getConnection();
            stmt1 = con.prepareStatement(sql);
            stmt1.setString(1, exp.getExpensesDate());
            stmt1.setFloat(2, exp.getExpensesAmount());
            stmt1.setString(3, exp.getExpensesCategory());
            stmt1.setString(4,exp.getExpensesDescription());
            stmt1.setString(5,exp.getUsername());
            stmt1.executeUpdate();
        } catch (Exception e) {
           throw new Exception("An error occured while getting user's Expenses from the database: " + e.getMessage());
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

    public float sumTodayExpenses (User user, Boolean on) throws Exception {


        if (on) {
            return 0;
        }

        Connection con = null;
        DB db = new DB();
        ResultSet rs = null;
        String sql = "SELECT expAmount FROM expenses WHERE username = ?";
        try {

            con = db.getConnection();
            PreparedStatement stmt2 = con.prepareStatement(sql);
            stmt2.setString(1,user.getUsername());

            // execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
            rs = stmt2.executeQuery();

            float sum = 0;

            while (rs.next()) {

                sum = rs.getFloat("expenses.expAmount") + sum;

            }

            rs.close(); //closing ResultSet
            stmt2.close(); //closing PreparedStatement
            return sum;

        } catch (Exception e) {
            throw new Exception("An error occured while getting user's Expenses from the database: " + e.getMessage());
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                //Dosen't need to do anything
            }
        }

    }


    public float sumTodayExpenses (User user, String td) throws Exception {

        Connection con = null;
        DB db = new DB();
        ResultSet rs = null;
        String sql = "SELECT expAmount FROM expenses WHERE username = ? AND expDate = ?";
        try {

            con = db.getConnection();
            PreparedStatement stmt2 = con.prepareStatement(sql);
            stmt2.setString(1,user.getUsername());
            stmt2.setString(2,td);

            // execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
            rs = stmt2.executeQuery();

            float sum = 0;

            while (rs.next()) {

                sum = rs.getFloat("expenses.expAmount") + sum;

            }

            rs.close(); //closing ResultSet
            stmt2.close(); //closing PreparedStatement
            return sum;

        } catch (Exception e) {
            throw new Exception("An error occured while getting user's Expenses from the database: " + e.getMessage());
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                //Dosen't need to do anything
            }
        }

    }
}