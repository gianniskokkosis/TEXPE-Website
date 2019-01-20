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


public class IncomeController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = new PrintWriter(response.getWriter(), true);

	  RequestDispatcher insuccess = request.getRequestDispatcher("./income.jsp");
	  RequestDispatcher inerror = request.getRequestDispatcher("./income.jsp");

	  HttpSession session = request.getSession(true);

      //read parameters from request (data send via form)

    // Create an instance of SimpleDateFormat used for formatting
    // the string representation of date (month/day/year)
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    // Get the date today using Calendar object.
    Date today = Calendar.getInstance().getTime();

    // Using DateFormat format method we can create a string
    // representation of a date with the defined format.

    String reportDate = df.format(today);

    String iDate = reportDate;

	  //String iDate = session.getAttribute("date");
	  float iAmount = Float.parseFloat((request.getParameter("incomeAmount")));
	  String iDesc = request.getParameter("incomeDescription");
	  String iCat = request.getParameter("incomeCategory");

    iDesc = new String(iDesc.getBytes("ISO-8859-1"), "UTF-8");
    iCat = new String(iCat.getBytes("ISO-8859-1"), "UTF-8");




    User user = (User)session.getAttribute("uobj");

    IncomeDAO idao = new IncomeDAO();

    String username = user.getUsername();


    try {

      	Income inc = new Income(iDate,iAmount,iCat,iDesc, username);

      	session.setAttribute("uincome", inc);

      	idao.saveIncome(inc);

        request.setAttribute( "success-message","Income saved succefully!" );


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