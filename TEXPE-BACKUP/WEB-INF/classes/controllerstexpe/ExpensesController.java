package controllerstexpe;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.*;
import java.time.*;
import java.text.*;
import java.util.*;
import texpeclasses.*;
import exceptionstexpe.UserNotFoundApplicationException;


// author: ismgroup35


public class ExpensesController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = new PrintWriter(response.getWriter(), true);

	  RequestDispatcher insuccess = request.getRequestDispatcher("./expenses.jsp");
	  RequestDispatcher inerror = request.getRequestDispatcher("./expenses.jsp");

	  HttpSession session = request.getSession(true);

      //read parameters from request (data send via form)

    // Create an instance of SimpleDateFormat used for formatting
    // the string representation of date (day/month/year)
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    // Get the date today using Calendar object.
    Date today = Calendar.getInstance().getTime();

    // Using DateFormat format method we can create a string
    // representation of a date with the defined format.
    String reportDate = df.format(today);

    String iDate = reportDate;
	  float iAmount = Float.parseFloat(request.getParameter("expAmount"));
	  String iDesc = request.getParameter("expDescription");
	  String iCat = request.getParameter("expCategory");

    iDesc = new String(iDesc.getBytes("ISO-8859-1"), "UTF-8");
    iCat = new String(iCat.getBytes("ISO-8859-1"), "UTF-8");


      User user = (User)session.getAttribute("uobj");

      ExpensesDAO edao = new ExpensesDAO();

      String username = user.getUsername();


    	try {

      	Expenses exp = new Expenses(iDate,iAmount,iCat,iDesc, username);

      	session.setAttribute("expcome", exp);

      	edao.saveExpenses(exp);

        request.setAttribute( "success-message","Expense saved succefully!" );

      	insuccess.forward(request, response);

   	 	} catch (UserNotFoundApplicationException e) {


	   	 	request.setAttribute( "error-message", e.getMessage() );
			 inerror.forward(request, response);

 	 	} catch (Exception e) {

			throw new ServletException("Exception while saving income! Error: " + e.getMessage());

		}
   	}
   // End of doGet
}