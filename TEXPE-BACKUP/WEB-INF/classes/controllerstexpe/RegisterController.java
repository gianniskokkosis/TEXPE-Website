package controllerstexpe;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.List;
import texpeclasses.*;
import validationtexpe.UserDataValidator;

public class RegisterController extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
			
		response.setContentType("text/hmtl; charset=UTF-8");
		PrintWriter out = new PrintWriter(response.getWriter(), true);
		
		//read parameters from request
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String aggree = request.getParameter("aggree");

		name = 	new String(name.getBytes("ISO-8859-1"), "ISO-8859-7");
		surname = new String(surname.getBytes("ISO-8859-1"), "ISO-8859-7");
		username = new String(username.getBytes("ISO-8859-1"), "ISO-8859-7");
		email = new String(email.getBytes("ISO-8859-1"), "ISO-8859-7");
		password = new String(password.getBytes("ISO-8859-1"), "ISO-8859-7");
		confirm = new String(confirm.getBytes("ISO-8859-1"), "ISO-8859-7");
		aggree= new String(aggree.getBytes("ISO-8859-1"), "ISO-8859-7");
	
		
		//required objects for validation
		UserDAO udao = new UserDAO();
		UserDataValidator vldt = new UserDataValidator();
		
		//Dispatchers
		RequestDispatcher error = request.getRequestDispatcher("/register.jsp");
		RequestDispatcher success = request.getRequestDispatcher("/registerdone.jsp");
		
		try{
		
			//validate name
			if (!vldt.isNameValid(name)){
				request.setAttribute("error-message","Name is not valid!");
				error.forward(request,response);
				return;
			}
			//validate surname
			if (!vldt.isSurnameValid(surname)){
				request.setAttribute("error-message","Surname is not valid!");
				error.forward(request,response);
				return;
			}
			//validate username
			if (!vldt.isUsernameValid(username)){
				request.setAttribute("error-message","Username is not valid!");
				error.forward(request,response);
				return;
			}
			
			//validate Email
			if(!vldt.isValidEmailAddress(email)){
				request.setAttribute("error-message", "Email is not valid!");
				error.forward(request,response);
				return;
			}
			
			//validate Password
			if(!vldt.isPasswordValid(password)){
				request.setAttribute("error-message", "Password is not valid!");
				error.forward(request,response);
				return;
			}
			
			//validate Confirm
			if(vldt.isConfirmationValid(confirm,password)){
				request.setAttribute("error-message", "Password must match with Confirm Password!");
				error.forward(request,response);
				return;
			}

			//User is already exist validation
			if(!vldt.userExist(username)){
				request.setAttribute("error-message", "User already exist!");
				error.forward(request,response);
				return;
			}
			
			//valid notifications
			if(!vldt.isNotificationsValid(aggree)){
				request.setAttribute("error-message", "You must aggree to terms and conditions in order to register!");
				error.forward(request,response);
				return;
			}

			User user = new User(name,surname,username,email,password);
			
			udao.registerUser(user);
			request.setAttribute("uobj", user);
			success.forward(request,response);
			return;
				
		}catch(Exception ex){
			
				throw new ServletException("An error occured during registration. Error: " + ex.getMessage());
		}
	}

	public void doGet (HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
			response.sendRedirect("../register.jsp");
		}

}