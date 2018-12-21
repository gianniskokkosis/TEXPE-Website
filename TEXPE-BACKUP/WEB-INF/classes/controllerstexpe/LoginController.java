package controllerstexpe;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.List;
import texpeclasses.*;
import exceptionstexpe.UserNotFoundApplicationException;


// author: ismgroup35


public class LoginController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = new PrintWriter(response.getWriter(), true);


      RequestDispatcher loginerror = request.getRequestDispatcher("./login.jsp");
	  RequestDispatcher loginsuccess = request.getRequestDispatcher("./today.jsp");

	  HttpSession session = request.getSession(true);
      
      //read parameters from request (data send via login form)
	  String uname = request.getParameter("username");
	  String passwd = request.getParameter("password");

	  uname = new String(uname.getBytes("ISO-8859-1"), "UTF-8");
      passwd = new String(passwd.getBytes("ISO-8859-1"), "UTF-8");


      UserDAO udao = new UserDAO();


    	try {

      	User user = udao.authenticate(uname, passwd);

      	session.setAttribute("uobj", user);
			
		//add a welcome message to user
		request.setAttribute( "success-message", "Welcome " + user.getName() );
			
		loginsuccess.forward(request, response);


   	 	} catch (UserNotFoundApplicationException e) { 


	   	 	request.setAttribute( "error-message", e.getMessage() );
			loginerror.forward(request, response);

 	 	} catch (Exception e) {
			
			throw new ServletException("Exception while login! Error: " + e.getMessage());		  			
		  
		}
   	}
   // End of doPost

   	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Set response content type
		response.sendRedirect("./login.jsp");

	}
}