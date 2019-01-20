<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="apperror.jsp"%> 
<%@ page import="texpeclasses.* , java.util.* , java.time.* , java.text.* , java.util.ArrayList" %>
<%
User user = (User)session.getAttribute("uobj");
ReportDAO rdao = new ReportDAO();

List<Income> incomes = rdao.getIncomes(user);
int counter = 0;
int counter2 = 0;
List<Expenses> expenses = rdao.getExpenses(user);
if (user == null){
    request.setAttribute("notauth", "You are not authorized to access this resource. Please login.");
%>
<jsp:forward page="login.jsp" /> 
<%
}
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="IsmGroup35">
    <meta name="keywords" content="">

    <!-- Title Page-->
    <title>Year Balance</title>
    <link rel="apple-touch-icon" href="images/favicon16x16.png">
    <link rel="shortcut icon" type="image/ico" href="images/favicon16x16.png" />

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="today.jsp">
                            <img src="images/texpe.png" alt="T-EXPE" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="navbar-mobile__list list-unstyled">
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-tachometer-alt"></i>Home</a>
                            
                        
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-copy"></i>This Period</a>
                            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                <li>
                                    <a href="report.jsp">Report</a>
                                </li>
                                <li>
                                    <a href="month.jsp">This Month</a>
                                </li>
                                <li>
                                    <a href="year.jsp">This Year</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="calendar.jsp">
                                <i class="fas fa-calendar-alt"></i>Calendar</a>
                        </li>
                            </ul>
                        </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="./today.jsp">
                    <img src="images/texpe.png" alt="T-EXPE" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li >
                            <a class="js-arrow" href="today.jsp">
                                <i class="fas fa-tachometer-alt"></i>Today</a>
                           
                       
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-chart-bar"></i>This Period</a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                 <li>
                                    <a href="report.jsp">Report</a>
                                </li >
                                <li>
                                    <a href="month.jsp">This Month</a>
                                </li>
                                <li class="active has-sub">
                                    <a href="year.jsp">This Year</a>
                                </li>
                            </ul>
                        </li>
                       <li>
                            <a href="calendar.jsp">
                                <i class="fas fa-calendar-alt"></i>Calendar</a>
                        </li>
                            </ul>
                        </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                            <form>
                            </form>
                            <div class="header-button">                 
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="images/icon/texpeuser.jpg"/>
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#"><%= user.getUsername()%></a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="images/icon/texpeuser.jpg"/>
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#"><%= user.getUsername()%></a>
                                                    </h5>
                                                    <span class="email"><%= user.getEmail()%></span>
                                                </div>
                                            </div>
                                            
                                            <div class="account-dropdown__footer">
                                                <a href="logout.jsp">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- HEADER DESKTOP-->
            <%  
                //Date
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date today = Calendar.getInstance().getTime();  
                String reportDate = df.format(today);
                String currentYear = reportDate.substring(6,10);

            %>
 
            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="overview-wrap">
                                    <h1 class="title-1"> Report</h1>
                                  
                                </div>
                            </div>
                        </div>
				   </div>
                </div>
                <div class="page-container-today">
                    
					<br><br>
              <h2 style="color: #022C38">Your Incomes</h2>
              <br>
              <br>
					
					<div class="table-responsive ">
					
						<table class="table table-bordered table-condensed">
														
								<tr class="bg-cyan" style="color: aliceblue">
									<th>#</th>
									<th>Date</th>
									<th>Amount</th>
									<th>Description</th>
									<th>Category</th>									
								</tr>

						<%  for(Income income : incomes) { %>	
								<tr>
									<td><%=++counter %></td>
									<td><%=income.getIncomeDate() %></td>
									<td><%=income.getIncomeAmount() %></td>
									<td><%=income.getIncomeDescription() %></td>
									<td><%=income.getIncomeCategory() %></td>
									
									<%	} %>
									
						
								<%  
						
							if(incomes.size() == 0) { 	%>	
									<tr>
										<td colspan="9" class="text-center">No income found!</td>
									</tr>	
						<%	} %>	
						</table>					
						
					</div>					
<br><br>
              <h2 style="color: #022C38">Your Expenses</h2>
              <br>
              <br>
					
					<div class="table-responsive">
					
						<table class="table table-bordered table-condensed">
														
								<tr class="bg-cyan"  style="color: aliceblue">
									<th>#</th>
									<th>Date</th>
									<th>Amount</th>
									<th>Description</th>
									<th>Category</th>									
								</tr>

						<%  for(Expenses expense : expenses) { %>	
								<tr>
									<td><%=++counter2 %></td>
									<td><%=expense.getExpensesDate() %></td>
									<td><%=expense.getExpensesAmount() %></td>
									<td><%=expense.getExpensesDescription() %></td>
									<td><%=expense.getExpensesCategory() %></td>
									
									<%	} %>
									
						
								<%  if(expenses.size() == 0) { 	%>	
									<tr>
										<td colspan="9" class="text-center">No expenses found!</td>
									</tr>	
						<%	} %>	
						</table>					
						
					</div>					
	            </div>
				</div>  
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
			<footer>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>&copy; Copyright 2018 T-EXPE. All rights reserved. </p>
                                </div>
                            </div>
                        </div>
						</footer>
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>
<!-- end document-->
