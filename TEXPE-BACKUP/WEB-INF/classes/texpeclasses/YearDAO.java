package texpeclasses;

import java.sql.*;
import texpeclasses.*;
 

/**
 *  IncomeDAO provides all the necessary methods related to user's income.
 *  @author ismgroup35
 */
public class YearDAO{

    // that method returns today's sum of income.

    public float yearBalance (User user, String year) throws Exception {


        Connection con = null;
        DB db = new DB();    
        ResultSet rs = null;
        String sql = "Select ( SELECT  sum(income.incomeAmount) FROM income WHERE income.username = ?  AND (SUBSTRING(income.incomeDate,7,4 ) = ?) ) as inc , (SELECT sum(expenses.expAmount) FROM expenses WHERE expenses.username = ?  AND (SUBSTRING(expenses.expDate,7,4 ) = ?) ) as exp";
        try {


            con = db.getConnection();
            PreparedStatement stmt2 = con.prepareStatement(sql);
            stmt2.setString(1,user.getUsername());
            stmt2.setString(2,year);
            stmt2.setString(3,user.getUsername());
            stmt2.setString(4,year);

            rs = stmt2.executeQuery();

            float balance = 0;

            while (rs.next()) {

                balance = rs.getFloat("inc") - rs.getFloat("exp");

            }

            rs.close(); //closing ResultSet
            stmt2.close(); //closing PreparedStatement
            return balance;

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