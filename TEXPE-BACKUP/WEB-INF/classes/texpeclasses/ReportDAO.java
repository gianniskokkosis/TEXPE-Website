
package texpeclasses;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.lang.*;


import texpeclasses.*;
 



/**
 *  IncomeDAO provides all the necessary methods related to user's income.
 *  @author ismgroup35
 */
public class ReportDAO{

   

    public List<Income>  getIncomes (User user) throws Exception {


        Connection con = null;
        DB db = new DB();    
        ResultSet rs = null;
        String sql = "SELECT * FROM income WHERE username = ? ";
        List<Income> incomes =  new ArrayList<Income>();
        try {
 

            con = db.getConnection();
            PreparedStatement stmt2 = con.prepareStatement(sql);
            stmt2.setString(1,user.getUsername());
            rs = stmt2.executeQuery();
            while (rs.next()) {
							
							Income inc = new Income(
                                    rs.getString("income.incomeDate"),
                                    rs.getFloat("income.incomeAmount"), 
                                    rs.getString("income.incomeCategory"),
                                    rs.getString("income.incomeDescription"),
                                    user.getUsername() );
									incomes.add( inc );

            // execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)

            }

            rs.close(); //closing ResultSet
            stmt2.close(); //closing PreparedStatement
            return incomes;
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

       public List<Expenses>  getExpenses (User user) throws Exception {
    
    
            Connection con = null;
            DB db = new DB();    
            ResultSet rs = null;
            String sql = "SELECT * FROM expenses WHERE username = ? ";
            List<Expenses> expenses =  new ArrayList<Expenses>();
            try {
     
    
                con = db.getConnection();
                PreparedStatement stmt3 = con.prepareStatement(sql);
                stmt3.setString(1,user.getUsername());
                rs = stmt3.executeQuery();
                while (rs.next()) {
                                
                                Expenses exp = new Expenses(
                                        rs.getString("expenses.expDate"),
                                        rs.getFloat("expenses.expAmount"), 
                                        rs.getString("expenses.expCategory"),
                                        rs.getString("expenses.expDescription"),
                                        user.getUsername() );
                                        expenses.add( exp );
    
                // execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
    
                }
    
                rs.close(); //closing ResultSet
                stmt3.close(); //closing PreparedStatement
                return expenses;
            } catch (Exception e) {
                throw new Exception("An error occured while getting user's expenses from the database: " + e.getMessage());
            } finally {
                try {
                    db.close();
                } catch (Exception e) {
                    //Dosen't need to do anything
                }
            }
    
    }
}