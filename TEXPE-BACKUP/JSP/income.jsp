<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="apperror.jsp"%> 
<%@ page import="texpeclasses.* , java.util.* , java.time.* , java.text.*" %>


<%
User user = (User)session.getAttribute("uobj");
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
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Income</title>
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

    <link rel="stylesheet" type="text/css" href="css/income-outcome-theme.css">

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
                                <i class="fas fa-tachometer-alt"></i>Today</a>
                            
                        
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
                            <a href="./calendar.jsp">
                                <i class="fas fa-calendar-alt"></i>Calendar</a>
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
                        <li class="active has-sub">
                            <a class="js-arrow" href="today.jsp">
                                <i class="fas fa-tachometer-alt"></i>Today</a>
                           
                       
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-chart-bar"></i>This Period</a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
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
                            <a href="./calendar.jsp">
                                <i class="fas fa-calendar-alt"></i>Calendar</a>
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

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="overview-wrap">
                                    <!--grid System-->
                                    <div class="col-md-3"></div>
                                    
                                    <div class="col-md-6">
                                            <div class="income-header">
                                                <h3>Please input your income</h3> 
                                            </div>
                                            <br>
                                            
                                            <% if(request.getAttribute("error-message") != null) { %>       
                                                <div class="alert alert-danger" role="alert">
                                                    <%=(String)request.getAttribute("error-message") %>
                                                </div>
                                            <% } %>




                                        <form action="<%=request.getContextPath() %>/income" method="POST">
											<div class="form-group">

                                                <div class="income-header">
                                                        <p class="date-message"> 
                                                          <%  // Create an instance of SimpleDateFormat used for formatting 
                                                            // the string representation of date (month/day/year)
                                                            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                                                            // Get the date today using Calendar object.
                                                            Date today = Calendar.getInstance().getTime();        
                                                            // Using DateFormat format method we can create a string 
                                                            // representation of a date with the defined format.
                                                            String reportDate = df.format(today);
                                                            %>
                                                            <%=reportDate %>
                                                        </p>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="cc-income" class="control-label mb-1">Income</label>
                                                <input name="incomeAmount" type="number" required value=""  step="0.01" class="form-control" placeholder="enter your income">
                                            </div>

                                            <div class="form-group has-success">
                                                <label for="cc-description" class="control-label mb-1">Description</label>
                                                <input name="incomeDescription" type="text" class="form-control cc-name valid" placeholder="description of income">
                                                <span class="help-block field-validation-valid" data-valmsg-for="cc-name" data-valmsg-replace="true"></span>
                                            </div>

                                            <div class="form-group">
                                                <label for="cc-category-income" class="control-label mb-1">Category</label>
                                                <select class="form-control" name="incomeCategory">
                                                    <option value="" id="category-display">--- Please choose a category: ----</option>
                                                    <option value="1" id="category-display">Salary</option>
                                                    <option value="2" id="category-display">Savings</option>
                                                    <option value="3" id="category-display">Awards</option>
                                               </select>
                                            </div>
                                            
                                            <div>
                                                <button id="payment-button" type="submit" class="btn btn-lg btn-success btn-block">
                                                   <span class="glyphicon glyphicon-floppy-saved" aria-hidden="true">Store changes</span>
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                    
                                    <div class="col-md-3"></div>
                                    <!--/grid system-->
                                </div>
                            </div>
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
    <!-- Vendor JS -->
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
